package lk.ijse.parkingspaceservice.service.impl;

import lk.ijse.parkingspaceservice.Entity.ParkingSpace;
import lk.ijse.parkingspaceservice.repo.ParkingSpaceRepository;
import lk.ijse.parkingspaceservice.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public ParkingSpace saveParkingSpace(ParkingSpace parkingSpace) {
        return parkingSpaceRepository.save(parkingSpace);
    }

    @Override
    public ParkingSpace getParkingSpaceById(Long id) {
        return parkingSpaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking space not found: " + id));
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceRepository.findAll();
    }

    @Override
    public ParkingSpace updateParkingSpace(Long id, ParkingSpace parkingSpace) {

        ParkingSpace existing = getParkingSpaceById(id);

        existing.setSpaceNumber(parkingSpace.getSpaceNumber());
        existing.setLocation(parkingSpace.getLocation());
        existing.setZone(parkingSpace.getZone());
        existing.setVehicleType(parkingSpace.getVehicleType());
        existing.setHourlyRate(parkingSpace.getHourlyRate());
        existing.setStatus(parkingSpace.getStatus());
        existing.setOwnerId(parkingSpace.getOwnerId());

        return parkingSpaceRepository.save(existing);
    }

    @Override
    public void deleteParkingSpace(Long id) {
        if (!parkingSpaceRepository.existsById(id)) {
            throw new RuntimeException("Parking space not found: " + id);
        }

        parkingSpaceRepository.deleteById(id);
    }
}