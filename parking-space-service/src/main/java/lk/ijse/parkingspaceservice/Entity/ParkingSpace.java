package lk.ijse.parkingspaceservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parking_spaces")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String spaceNumber;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String zone;

    @Column(nullable = false)
    private String vehicleType;

    @Column(nullable = false)
    private Double hourlyRate;

    @Column(nullable = false)
    private String status;

    private Long ownerId;
}