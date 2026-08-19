package lk.ijse.parkingspaceservice.repo;

import lk.ijse.parkingspaceservice.Entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
}