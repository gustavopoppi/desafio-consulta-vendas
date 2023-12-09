package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryBySellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
        SaleMinDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/report")
    public ResponseEntity<Page<SaleReportDTO>> getReport(@RequestParam(defaultValue = "") String minDate,
                                                         @RequestParam(defaultValue = "") String maxDate,
                                                         @RequestParam(defaultValue = "") String name,
                                                         Pageable pageable) {
        Page<SaleReportDTO> dto = service.findSaleReport(minDate, maxDate, name, pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/summary")
    public ResponseEntity<Page<SalesSummaryBySellerDTO>> getSummary(@RequestParam(defaultValue = "") String minDate,
                                                                    @RequestParam(defaultValue = "") String maxDate,
                                                                    Pageable pageable) {

        Page<SalesSummaryBySellerDTO> dto = service.findSalesSummaryBySeller(minDate, maxDate, pageable);
        return ResponseEntity.ok(dto);
    }
}
