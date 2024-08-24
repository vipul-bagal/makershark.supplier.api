package com.makershark.supplier.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "website", nullable = true)
    private String website;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "business_type", nullable = false)
    private String businessType;


    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "supplier_manufacturing_process",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturing_process_id")
    )
    private List<ManufacturingProcess> manufacturingProcesses;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public void setManufacturingProcesses(List<ManufacturingProcess> manufacturingProcesses) {
        this.manufacturingProcesses = manufacturingProcesses;
    }

    public String getCompanyName() {
        return this.companyName;
    }
}
