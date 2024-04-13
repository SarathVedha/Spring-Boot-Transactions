package com.vedha.service;

import com.vedha.dto.OrderRequestDTO;
import com.vedha.dto.OrderResponseDTO;
import com.vedha.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    OrderResponseDTO placeOrder (OrderRequestDTO orderRequestDTO);

    List<OrderEntity> getAllOrders();
}
