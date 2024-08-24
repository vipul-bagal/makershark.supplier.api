package com.makershark.supplier.api.service;

import com.makershark.supplier.api.dto.SupplierRequest;
import com.makershark.supplier.api.exception.InvalidPageNumberException;
import com.makershark.supplier.api.model.Supplier;
import com.makershark.supplier.api.model.ManufacturingProcess;
import com.makershark.supplier.api.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> findSuppliers(SupplierRequest request) {
        int page = request.getPageNumber();
        int size = request.getSize();

        long totalItems = supplierRepository.countSuppliersByCriteria(request.getLocation(), request.getBusinessType(), request.getManufacturingProcesses());

        int totalPages = (int) Math.ceil(((double) totalItems /size));

        if(page > totalPages){
            throw new InvalidPageNumberException("Invalid page number!");
        }

        // Proceed to fetch data if valid
        Pageable pageable = PageRequest.of(page, size);
        return supplierRepository.findSuppliersByCriteria(
                request.getLocation(),
                request.getBusinessType(),
                request.getManufacturingProcesses(),
                pageable);

    }


    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
}
