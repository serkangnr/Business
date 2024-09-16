package com.financeservice.dto.request;

import com.financeservice.entity.enums.EInvoiceStatus;
import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceSaveRequestDTO(
        Long customerIdOrSupplierId,
        LocalDate invoiceDate,
        BigDecimal totalAmount,
        BigDecimal paidAmount,
        EInvoiceStatus invoiceStatus,
        String description
) {
}
