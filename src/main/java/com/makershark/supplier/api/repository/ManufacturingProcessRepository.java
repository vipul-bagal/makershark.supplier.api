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
import java.util.Optional;

@Repository
public interface ManufacturingProcessRepository extends JpaRepository<ManufacturingProcess, Long> {

    void deleteAll();

    Optional<ManufacturingProcess> findByProcessName(String processName);

    @Query("SELECT new com.makershark.supplier.api.model.ManufacturingProcess(m.id, m.processName) FROM ManufacturingProcess m")
    List<ManufacturingProcess> findProcesses();
}
