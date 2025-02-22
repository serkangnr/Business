package com.businessapi.services;

import com.businessapi.dto.request.FinancialReportSaveRequestDTO;
import com.businessapi.dto.request.FinancialReportUpdateRequestDTO;
import com.businessapi.dto.request.PageRequestDTO;
import com.businessapi.entity.FinancialReport;
import com.businessapi.entity.enums.EStatus;
import com.businessapi.exception.ErrorType;
import com.businessapi.exception.FinanceServiceException;
import com.businessapi.repositories.FinancialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialReportService {
    private final FinancialRepository financialRepository;

    public Boolean save(FinancialReportSaveRequestDTO dto) {
        FinancialReport financialReport = FinancialReport.builder()
                .financialReportType(dto.financialReportType())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .totalIncome(dto.totalIncome())
                .totalOutcome(dto.totalOutcome())
                .totalProfit(dto.totalProfit())
                .build();

        financialRepository.save(financialReport);
        return true;
    }

    public Boolean update(FinancialReportUpdateRequestDTO dto) {
        FinancialReport financialReport = financialRepository.findById(dto.id()).orElseThrow(() -> new FinanceServiceException(ErrorType.FINANCIAL_REPORT_NOT_FOUND));
        financialReport.setFinancialReportType(dto.financialReportType());
        financialReport.setStartDate(dto.startDate());
        financialReport.setEndDate(dto.endDate());
        financialReport.setTotalIncome(dto.totalIncome());
        financialReport.setTotalOutcome(dto.totalOutcome());
        financialReport.setTotalProfit(dto.totalProfit());

        financialRepository.save(financialReport);
        return true;
    }

    public Boolean delete(Long id) {
        FinancialReport financialReport = financialRepository.findById(id).orElseThrow(() -> new FinanceServiceException(ErrorType.FINANCIAL_REPORT_NOT_FOUND));
        financialReport.setStatus(EStatus.DELETED);
        financialRepository.save(financialReport);
        return true;
    }

    public List<FinancialReport> findAll(PageRequestDTO dto) {
        return financialRepository.findAll(PageRequest.of(dto.page(), dto.size())).getContent();
    }

    public FinancialReport findById(Long id) {
        return financialRepository.findById(id).orElseThrow(() -> new FinanceServiceException(ErrorType.FINANCIAL_REPORT_NOT_FOUND));
    }
}

