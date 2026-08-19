package lk.ijse.paymentservice.api.controller;

import lk.ijse.paymentservice.api.response.ApiResponse;
import lk.ijse.paymentservice.entity.Payment;
import lk.ijse.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Payment>> processPayment(
            @RequestBody Payment payment) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        201,
                        "Payment processed successfully",
                        paymentService.processPayment(payment)
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<ApiResponse<Payment>> getPaymentById(
            @PathVariable Long paymentId) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        200,
                        "Payment retrieved successfully",
                        paymentService.getPaymentById(paymentId)
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Payment>>> getAllPayments() {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        200,
                        "Payments retrieved successfully",
                        paymentService.getAllPayments()
                ),
                HttpStatus.OK
        );
    }
}