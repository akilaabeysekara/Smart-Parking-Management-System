package lk.ijse.parkingspaceservice.repo;

import lk.ijse.parkingspaceservice.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {

    List<ParkingSpace> findByStatus(String status);

    List<ParkingSpace> findByLocation(String location);

    List<ParkingSpace> findByLocationAndStatus(String location, String status);
}