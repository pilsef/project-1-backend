package com.willjager.payment_service.repository;

import com.willjager.payment_service.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<TransactionDetail, Long> {
}
