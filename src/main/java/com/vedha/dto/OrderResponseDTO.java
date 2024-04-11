package com.vedha.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "OrderResponseDTO", description = "Response object for order")
public class OrderResponseDTO {

    private String orderTrackingNumber;

    private String status;

    private String message;
}
