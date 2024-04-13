package com.vedha.service.impl;

import com.vedha.dto.OrderRequestDTO;
import com.vedha.dto.OrderResponseDTO;
import com.vedha.entity.OrderEntity;
import com.vedha.entity.PaymentEntity;
import com.vedha.exception.PaymentException;
import com.vedha.repository.OrderRepository;
import com.vedha.service.OrderService;
import com.vedha.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final PaymentService paymentService;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentService paymentService) {
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
    }

    @Override
    @Transactional(rollbackFor = {PaymentException.class}, noRollbackFor = {RuntimeException.class},
            propagation = Propagation.REQUIRED) // This annotation is used to make sure that both the operations are done in a single transaction and if any of the operation fails, the transaction will be rolled back.
    // This is used to make sure that the data is consistent in the database.
    // If the transaction is successful, the data will be committed to the database.
    // If the transaction fails, the data will be rolled back to the previous state.
    // Only rollback if there is an exception. If there is no exception, the data will be committed to the database.
    // method should throw an exception if the transaction fails.
    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO) {

//        try {

            OrderEntity orderEntity = orderRequestDTO.getOrder();
            orderEntity.setStatus("IN-PROGRESS");
            orderEntity.setOrderTrackingNumber(UUID.randomUUID().toString());
            OrderEntity order = orderRepository.save(orderEntity);

            PaymentEntity paymentEntity = orderRequestDTO.getPayment();
            paymentEntity.setPaymentType("DEBIT");

            if (!paymentEntity.getCardType().equalsIgnoreCase("VISA")) {

                throw new PaymentException("Only VISA card is accepted!!");
            }

            paymentEntity.setOrderId(order.getId());
            paymentService.bookPayment(paymentEntity);

            OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
            orderResponseDTO.setOrderTrackingNumber(order.getOrderTrackingNumber());
            orderResponseDTO.setStatus(order.getStatus());
            orderResponseDTO.setMessage("Order SuccessFully Placed!!");

            return orderResponseDTO;

//        }catch (Exception e){
//            log.error("Error while placing order: {}", e.getMessage());
//            throw new PaymentException("Payment Failed!!");
//        }

    }

    @Override
    public List<OrderEntity> getAllOrders() {

        List<OrderEntity> all = orderRepository.findAll();
        if(all.isEmpty()) throw new RuntimeException("No Orders Found!!");
        return all;
    }
}
