package com.makershark.supplier.api.controller;

import com.makershark.supplier.api.dto.SupplierRequest;
import com.makershark.supplier.api.exception.InvalidPageNumberException;
import com.makershark.supplier.api.model.Supplier;
import com.makershark.supplier.api.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(@RequestBody SupplierRequest request){
        Page<Supplier> suppliers = supplierService.findSuppliers(request);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        return new ResponseEntity<>(supplierService.getAllSuppliers(), HttpStatus.OK);
    }

}
