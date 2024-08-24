package com.makershark.supplier.api.service;

import com.makershark.supplier.api.repository.ManufacturingProcessRepository;
import com.makershark.supplier.api.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataCleanupService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ManufacturingProcessRepository manufacturingProcessRepository;

    public void deleteAllData() {
        // Delete all suppliers first to avoid foreign key constraint violation
        supplierRepository.deleteAll();
        // Delete all manufacturing processes
        manufacturingProcessRepository.deleteAll();
    }
}
