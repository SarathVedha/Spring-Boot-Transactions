package com.vedha.repository;

import com.vedha.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>, PagingAndSortingRepository<PaymentEntity, Long> {
}
