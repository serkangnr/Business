package com.businessapi.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseUpdateRequestDTO(
        Long id,
        LocalDate expenseDate,
        BigDecimal amount,
        String description
) {
}