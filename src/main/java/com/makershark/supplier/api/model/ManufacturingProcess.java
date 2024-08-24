package com.makershark.supplier.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Table(name = "manufacturing_process")
public class ManufacturingProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long processId;

    @Column(name = "process_name", unique = true, nullable = false)
    private String processName;

    @ManyToMany(mappedBy = "manufacturingProcesses")
    @JsonIgnore
    private Set<Supplier> suppliers;

    public ManufacturingProcess(String name, HashSet<Supplier> es) {
        this.processName = name;
        this.suppliers = es;
    }

    public ManufacturingProcess(Long id, String processName) {
        this.processId = id;
        this.processName = processName;
    }

    public ManufacturingProcess() {
        super();
    }

    //public ManufacturingProcess(){}


    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
