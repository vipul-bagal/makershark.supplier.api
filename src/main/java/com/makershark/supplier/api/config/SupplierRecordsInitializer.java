package com.makershark.supplier.api.config;

import com.makershark.supplier.api.model.ManufacturingProcess;
import com.makershark.supplier.api.model.Supplier;
import com.makershark.supplier.api.repository.ManufacturingProcessRepository;
import com.makershark.supplier.api.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SupplierRecordsInitializer implements CommandLineRunner {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ManufacturingProcessRepository processRepository;

    @Override
    public void run(String... args) throws Exception {

        if (supplierRepository.count() != 0) {return;}

        List<String> locations = Arrays.asList("Mumbai", "Delhi", "Bengaluru");
        List<String> businessTypes = Arrays.asList("small_scale", "medium_scale", "large_scale");
        List<String> processNames = Arrays.asList("moulding", "3d_printing", "casting", "coating");

        // List of meaningful company names
        List<String> companyNames = Arrays.asList(
                "Apex Manufacturing Ltd.", "Vertex Industries", "TechnoForge Pvt. Ltd.",
                "Innovate Plastics"
        );

        for (String name : processNames) {
            if (processRepository.findByProcessName(name).isEmpty()) {
                processRepository.save(new ManufacturingProcess( name, new HashSet<>()));
            }
        }

        // Fetch all manufacturing processes
        List<ManufacturingProcess> processes = processRepository.findAll();

// Define the maximum number of suppliers you want to create
        int maxSuppliers = 25;
        int currentSupplierCount = 0;

// Iterate through predefined lists to create suppliers
        int companyIndex = 0, locationIndex = 0, businessTypeIndex = 0;

// Loop until we create the desired number of suppliers
        while (currentSupplierCount < maxSuppliers) {
            // Cycle through the list indices
            if (companyIndex >= companyNames.size()) companyIndex = 0;
            if (locationIndex >= locations.size()) locationIndex = 0;
            if (businessTypeIndex >= businessTypes.size()) businessTypeIndex = 0;

            // Create a new Supplier object
            Supplier supplier = new Supplier();
            supplier.setCompanyName(companyNames.get(companyIndex++));
            supplier.setWebsite("https://www." + supplier.getCompanyName().replaceAll(" ", "").toLowerCase() + ".com");
            supplier.setLocation(locations.get(locationIndex++));
            supplier.setBusinessType(businessTypes.get(businessTypeIndex++));

            // Assign a random set of processes to the supplier
            Set<ManufacturingProcess> assignedProcesses = processes.stream()
                    .limit(2) // Assign a couple of processes randomly to each supplier
                    .collect(Collectors.toSet());
            supplier.setManufacturingProcesses(assignedProcesses);

            // Save the supplier to the database
            supplierRepository.save(supplier);

            // Increment the count
            currentSupplierCount++;
        }

    }
}
