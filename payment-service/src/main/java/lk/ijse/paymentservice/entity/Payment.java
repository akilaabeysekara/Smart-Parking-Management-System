package lk.ijse.paymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long userId;

    private Long vehicleId;

    private Long parkingSpaceId;

    private Double amount;

    private String cardNumber;

    private String cardHolderName;

    private String paymentMethod;

    private String transactionStatus;

    private LocalDateTime transactionDate;

    private String receiptNumber;
}