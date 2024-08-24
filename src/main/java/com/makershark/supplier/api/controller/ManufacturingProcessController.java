package com.makershark.supplier.api.controller;

import com.makershark.supplier.api.model.ManufacturingProcess;
import com.makershark.supplier.api.service.ManufacturingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/manufacturing-process")
public class ManufacturingProcessController {

    @Autowired
    private ManufacturingProcessService manufacturingProcessService;

    @PostMapping
    public ResponseEntity<ManufacturingProcess> createManufacturingProcess(@RequestBody ManufacturingProcess process) {
        try {
            ManufacturingProcess savedProcess = manufacturingProcessService.createManufacturingProcess(process);
            return new ResponseEntity<>(savedProcess, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // 409 Conflict if the process name already exists
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ManufacturingProcess>> getAllManufacturingProcesses() {
        List<ManufacturingProcess> processes = manufacturingProcessService.getAllManufacturingProcesses();
        return new ResponseEntity<>(processes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturingProcess> getManufacturingProcessById(@PathVariable Long id) {
        Optional<ManufacturingProcess> process = manufacturingProcessService.getManufacturingProcessById(id);
        return process.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // 404 Not Found if the process does not exist
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturingProcess> updateManufacturingProcess(
            @PathVariable Long id, @RequestBody ManufacturingProcess updatedProcess) {
        try {
            ManufacturingProcess process = manufacturingProcessService.updateManufacturingProcess(id, updatedProcess);
            return new ResponseEntity<>(process, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found if the process does not exist
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManufacturingProcess(@PathVariable Long id) {
        try {
            manufacturingProcessService.deleteManufacturingProcess(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content if deletion is successful
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found if the process does not exist
        }
    }
}
