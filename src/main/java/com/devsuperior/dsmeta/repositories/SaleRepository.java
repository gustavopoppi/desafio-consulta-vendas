package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryBySellerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT NEW com.devsuperior.dsmeta.dto.SaleReportDTO(obj.id, obj.date, obj.amount, obj.seller.name) " +
            " FROM Sale obj " +
            "WHERE obj.date BETWEEN :minDate AND :maxDate " +
            "  AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<SaleReportDTO> findSaleReport(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);

    Page<SalesSummaryBySellerDTO> findSumSaleBySeller(LocalDate minDate, LocalDate maxDate, Pageable pageable);
}
