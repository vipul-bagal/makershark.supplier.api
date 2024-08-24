package com.makershark.supplier.api.service;

import com.makershark.supplier.api.model.ManufacturingProcess;
import com.makershark.supplier.api.repository.ManufacturingProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturingProcessService {

    @Autowired
    private ManufacturingProcessRepository manufacturingProcessRepository;

    // Create a new manufacturing process
    public ManufacturingProcess createManufacturingProcess(ManufacturingProcess process) {
        if (manufacturingProcessRepository.findByProcessName(process.getProcessName()).isPresent()) {
            throw new IllegalArgumentException("Process name already exists");
        }
        return manufacturingProcessRepository.save(process);
    }

    // Get all manufacturing processes
    public List<ManufacturingProcess> getAllManufacturingProcesses() {
        return manufacturingProcessRepository.findProcesses();
    }

    // Get a specific manufacturing process by ID
    public Optional<ManufacturingProcess> getManufacturingProcessById(Long id) {
        return manufacturingProcessRepository.findById(id);
    }

    // Update an existing manufacturing process
    public ManufacturingProcess updateManufacturingProcess(Long id, ManufacturingProcess updatedProcess) {
        return manufacturingProcessRepository.findById(id)
                .map(process -> {
                    process.setProcessName(updatedProcess.getProcessName());
                    return manufacturingProcessRepository.save(process);
                })
                .orElseThrow(() -> new IllegalArgumentException("Process not found"));
    }

    // Delete a manufacturing process
    public void deleteManufacturingProcess(Long id) {
        if (manufacturingProcessRepository.existsById(id)) {
            manufacturingProcessRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Process not found");
        }
    }
}
