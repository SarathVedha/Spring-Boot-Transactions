package com.vedha.service.impl;

import com.vedha.entity.PaymentEntity;
import com.vedha.repository.PaymentRepository;
import com.vedha.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public PaymentEntity bookPayment(PaymentEntity paymentEntity) {

        return paymentRepository.save(paymentEntity);
    }
}
