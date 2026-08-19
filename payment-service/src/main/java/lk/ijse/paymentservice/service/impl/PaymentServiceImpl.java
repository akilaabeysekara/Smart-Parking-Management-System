package lk.ijse.paymentservice.service.impl;

import lk.ijse.paymentservice.entity.Payment;
import lk.ijse.paymentservice.exception.CustomException;
import lk.ijse.paymentservice.repo.PaymentRepository;
import lk.ijse.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment processPayment(Payment payment) {

        // Validate amount
        if (payment.getAmount() == null || payment.getAmount() <= 0) {
            throw new CustomException(
                    "Payment amount must be greater than 0"
            );
        }

        // Validate card number
        if (payment.getCardNumber() == null ||
                !payment.getCardNumber().matches("\\d{16}")) {

            throw new CustomException(
                    "Invalid card number"
            );
        }

        // Validate card holder name
        if (payment.getCardHolderName() == null ||
                payment.getCardHolderName().trim().isEmpty()) {

            throw new CustomException(
                    "Card holder name is required"
            );
        }

        // Validate payment method
        if (payment.getPaymentMethod() == null ||
                payment.getPaymentMethod().trim().isEmpty()) {

            throw new CustomException(
                    "Payment method is required"
            );
        }

        // Simulate transaction
        payment.setTransactionStatus("SUCCESS");

        // Set transaction date
        payment.setTransactionDate(LocalDateTime.now());

        // Generate receipt number
        payment.setReceiptNumber(
                "REC-" + UUID.randomUUID()
                        .toString()
                        .substring(0, 8)
                        .toUpperCase()
        );

        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {

        return paymentRepository.findById(paymentId)
                .orElseThrow(() ->
                        new CustomException(
                                "Payment not found with id: " + paymentId
                        )
                );
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}