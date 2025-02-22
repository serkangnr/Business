package com.businessapi.controllers;

import com.businessapi.dto.request.FinancialReportSaveRequestDTO;
import com.businessapi.dto.request.FinancialReportUpdateRequestDTO;
import com.businessapi.dto.request.PageRequestDTO;
import com.businessapi.dto.response.ResponseDTO;
import com.businessapi.entity.FinancialReport;
import com.businessapi.services.FinancialReportService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.businessapi.constants.Endpoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT + FINANCIALREPORT)
@CrossOrigin("*")
public class FinancialReportController {
    private final FinancialReportService financialReportService;

    @PostMapping(SAVE)
    @Operation(summary = "Saves new financial report")
    public ResponseEntity<ResponseDTO<Boolean>> save(FinancialReportSaveRequestDTO dto) {
        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(financialReportService.save(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @PutMapping(UPDATE)
    @Operation(summary = "Updates an existing financial report")
    public ResponseEntity<ResponseDTO<Boolean>> update(FinancialReportUpdateRequestDTO dto) {
        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(financialReportService.update(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "Deletes an existing financial report")
    public ResponseEntity<ResponseDTO<Boolean>> delete(Long id) {
        return ResponseEntity.ok(ResponseDTO
                .<Boolean>builder()
                .data(financialReportService.delete(id))
                .message("Success")
                .code(200)
                .build());
    }

    @PostMapping(FIND_ALL)
    @Operation(summary = "Lists all the financial reports with respect to the given page and size")
    public ResponseEntity<ResponseDTO<List<FinancialReport>>> findAll(@RequestBody PageRequestDTO dto) {
        return ResponseEntity.ok(ResponseDTO
                .<List<FinancialReport>>builder()
                .data(financialReportService.findAll(dto))
                .message("Success")
                .code(200)
                .build());
    }

    @PostMapping(FIND_BY_ID)
    @Operation(summary = "Finds a financial report by its id")
    public ResponseEntity<ResponseDTO<FinancialReport>> findById(Long id) {
        return ResponseEntity.ok(ResponseDTO
                .<FinancialReport>builder()
                .data(financialReportService.findById(id))
                .message("Success")
                .code(200)
                .build());
    }
}
