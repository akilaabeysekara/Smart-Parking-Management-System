package lk.ijse.paymentservice.service;

import lk.ijse.paymentservice.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment processPayment(Payment payment);

    Payment getPaymentById(Long paymentId);

    List<Payment> getAllPayments();
}