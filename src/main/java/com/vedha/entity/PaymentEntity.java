package com.vedha.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
@Schema(name = "Payment", description = "Payment details")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String paymentType;

    private String cardType;

    private String cardName;

    private String cardNumber;

    private int expiryYear;

    private int expiryMonth;

    private int csv;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long orderId;

}
