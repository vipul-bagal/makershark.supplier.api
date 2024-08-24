package com.makershark.supplier.api.repository;

import com.makershark.supplier.api.model.ManufacturingProcess;
import com.makershark.supplier.api.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    void deleteAll();

    @Query("SELECT s FROM Supplier s " +
            "JOIN s.manufacturingProcesses mp " +
            "WHERE s.location = :location " +
            "AND s.businessType = :businessType " +
            "AND mp.processName IN :processNames")
    Page<Supplier> findSuppliersByCriteria(
            @Param("location") String location,
            @Param("businessType") String businessType,
            @Param("processNames") List<String> processNames,
            Pageable pageable
    );



    @Query("SELECT COUNT(s) FROM Supplier s " +
            "JOIN s.manufacturingProcesses mp " +
            "WHERE s.location = :location " +
            "AND s.businessType = :businessType " +
            "AND mp.processName IN :processNames")
    long countSuppliersByCriteria(
            @Param("location") String location,
            @Param("businessType") String businessType,
            @Param("processNames") List<String> processNames
    );
}
