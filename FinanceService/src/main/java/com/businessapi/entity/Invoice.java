package com.businessapi.entity;

import com.businessapi.entity.enums.EInvoiceStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblinvoice")
public class Invoice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long customerIdOrSupplierId;
    LocalDate invoiceDate;
    BigDecimal totalAmount;
    BigDecimal paidAmount;
    @Enumerated(EnumType.STRING)
    EInvoiceStatus invoiceStatus;
    String description;
}
