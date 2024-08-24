package com.makershark.supplier.api.controller;

import com.makershark.supplier.api.service.DataCleanupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private DataCleanupService dataCleanupService;

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAllData() {
        dataCleanupService.deleteAllData();
        return new ResponseEntity<>("All records have been deleted from Supplier and ManufacturingProcess tables.", HttpStatus.OK);
    }
}
