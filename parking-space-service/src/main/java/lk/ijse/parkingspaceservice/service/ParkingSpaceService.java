package lk.ijse.parkingspaceservice.service;

import lk.ijse.parkingspaceservice.entity.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {

    ParkingSpace saveParkingSpace(ParkingSpace parkingSpace);

    ParkingSpace getParkingSpaceById(Long id);

    List<ParkingSpace> getAllParkingSpaces();

    ParkingSpace updateParkingSpace(Long id, ParkingSpace parkingSpace);

    void deleteParkingSpace(Long id);

    List<ParkingSpace> getAvailableParkingSpaces();

    List<ParkingSpace> getParkingSpacesByLocation(String location);

    List<ParkingSpace> getParkingSpacesByLocationAndStatus(
            String location,
            String status
    );

    ParkingSpace reserveParkingSpace(Long id);

    ParkingSpace releaseParkingSpace(Long id);

    ParkingSpace updateParkingSpaceStatus(Long id, String status);
}