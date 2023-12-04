package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT NEW com.devsuperior.dsmeta.dto.SaleReportDTO(obj.id, obj.date, obj.amount, obj.seller.name) " +
            " FROM Sale obj " +
            "WHERE obj.date BETWEEN :minDate AND :maxDate " +
            "  AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    List<SaleReportDTO> findSaleReport(LocalDate minDate, LocalDate maxDate, String name);
}
