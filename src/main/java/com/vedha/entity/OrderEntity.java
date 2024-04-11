package com.vedha.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table
@Schema(name = "Order", description = "Order details")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String orderTrackingNumber;

    private int totalQuantity;

    private BigDecimal totalPrice;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String status;

    @CreationTimestamp
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime lastUpdated;

    private Long shoppingCardId;

}
