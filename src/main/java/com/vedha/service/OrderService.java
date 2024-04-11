package com.vedha.service;

import com.vedha.dto.OrderRequestDTO;
import com.vedha.dto.OrderResponseDTO;

public interface OrderService {

    OrderResponseDTO placeOrder (OrderRequestDTO orderRequestDTO);
}
