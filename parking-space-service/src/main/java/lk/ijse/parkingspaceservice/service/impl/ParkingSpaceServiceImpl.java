package lk.ijse.parkingspaceservice.service.impl;

import lk.ijse.parkingspaceservice.entity.ParkingSpace;
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
                .orElseThrow(() ->
                        new RuntimeException("Parking space not found: " + id));
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceRepository.findAll();
    }

    @Override
    public ParkingSpace updateParkingSpace(
            Long id,
            ParkingSpace parkingSpace) {

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
            throw new RuntimeException(
                    "Parking space not found: " + id);
        }

        parkingSpaceRepository.deleteById(id);
    }

    // Get all available parking spaces
    @Override
    public List<ParkingSpace> getAvailableParkingSpaces() {

        return parkingSpaceRepository.findByStatus("AVAILABLE");
    }

    // Get parking spaces by location
    @Override
    public List<ParkingSpace> getParkingSpacesByLocation(
            String location) {

        return parkingSpaceRepository.findByLocation(location);
    }

    // Get parking spaces by location and status
    @Override
    public List<ParkingSpace> getParkingSpacesByLocationAndStatus(
            String location,
            String status) {

        return parkingSpaceRepository
                .findByLocationAndStatus(location, status);
    }

    // Reserve a parking space
    @Override
    public ParkingSpace reserveParkingSpace(Long id) {

        ParkingSpace parkingSpace = getParkingSpaceById(id);

        if (!"AVAILABLE".equals(parkingSpace.getStatus())) {
            throw new RuntimeException(
                    "Parking space is not available for reservation");
        }

        parkingSpace.setStatus("RESERVED");

        return parkingSpaceRepository.save(parkingSpace);
    }

    // Release a parking space
    @Override
    public ParkingSpace releaseParkingSpace(Long id) {

        ParkingSpace parkingSpace = getParkingSpaceById(id);

        if (!"RESERVED".equals(parkingSpace.getStatus())) {
            throw new RuntimeException(
                    "Parking space is not currently reserved");
        }

        parkingSpace.setStatus("AVAILABLE");

        return parkingSpaceRepository.save(parkingSpace);
    }

    // Update parking space status
    @Override
    public ParkingSpace updateParkingSpaceStatus(
            Long id,
            String status) {

        ParkingSpace parkingSpace = getParkingSpaceById(id);

        parkingSpace.setStatus(status);

        return parkingSpaceRepository.save(parkingSpace);
    }
}