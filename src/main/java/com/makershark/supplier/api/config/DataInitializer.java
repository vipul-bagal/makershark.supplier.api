package com.makershark.supplier.api.config;

import com.makershark.supplier.api.model.ManufacturingProcess;
import com.makershark.supplier.api.repository.ManufacturingProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ManufacturingProcessRepository manufacturingProcessRepository;

    @Override
    public void run(String... args) throws Exception {

        if (manufacturingProcessRepository.count() != 0) {return;}
        // Dummy manufacturing processes
        List<String> processes = List.of("moulding", "3d_printing", "casting", "coating");

        for (String processName : processes) {
            if (manufacturingProcessRepository.findByProcessName(processName).isEmpty()) {
                ManufacturingProcess process = new ManufacturingProcess();
                process.setProcessName(processName);
                manufacturingProcessRepository.save(process);
            }
        }
    }


}
