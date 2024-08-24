package com.makershark.supplier.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

public class SupplierRequest {

    @NotBlank(message = "location is required!")
    private String location;

    @NotBlank(message = "nature of business is required!")
    private String businessType;

    private List<String> manufacturingProcesses;

    @Positive(message = "Page number ")
    private int pageNumber = 0;

    @Positive(message = "Page size must be greater than 0.")
    private int size = 10;

    public @NotBlank(message = "location is required!") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "location is required!") String location) {
        this.location = location;
    }

    public @NotBlank(message = "nature of business is required!") String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(@NotBlank(message = "nature of business is required!") String businessType) {
        this.businessType = businessType;
    }

    public List<String> getManufacturingProcesses() {
        return manufacturingProcesses;
    }

    public void setManufacturingProcesses(List<String> manufacturingProcesses) {
        this.manufacturingProcesses = manufacturingProcesses;
    }

    @Positive(message = "Page number ")
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(@Positive(message = "Page number ") int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Positive(message = "Page size must be greater than 0.")
    public int getSize() {
        return size;
    }

    public void setSize(@Positive(message = "Page size must be greater than 0.") int size) {
        this.size = size;
    }
}
