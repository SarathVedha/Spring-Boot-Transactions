package com.vedha.controller;

import com.vedha.dto.OrderRequestDTO;
import com.vedha.dto.OrderResponseDTO;
import com.vedha.entity.OrderEntity;
import com.vedha.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Orders")
@Tag(name = "Order Controller", description = "Order Controller")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // http://localhost:8080/Orders/placeOrder
    @Operation(summary = "Place Order", description = "Place Order")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @PostMapping(value = "/placeOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {

        OrderResponseDTO orderResponseDTO = orderService.placeOrder(orderRequestDTO);

        return ResponseEntity.ok(orderResponseDTO);
    }

    @Operation(summary = "Get All Orders", description = "Get All Orders")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/getAllOrders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderEntity>> getAllOrders() {

        List<OrderEntity> orderEntities = orderService.getAllOrders();

        return ResponseEntity.ok(orderEntities);
    }


}
