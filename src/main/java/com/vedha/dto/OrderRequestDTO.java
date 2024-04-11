package com.vedha.dto;

import com.vedha.entity.OrderEntity;
import com.vedha.entity.PaymentEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "OrderRequestDTO", description = "Request object for order")
public class OrderRequestDTO {

    private OrderEntity order;

    private PaymentEntity payment;
}
