package lk.ijse.parkingspaceservice.service;

import lk.ijse.parkingspaceservice.Entity.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {

    ParkingSpace saveParkingSpace(ParkingSpace parkingSpace);

    ParkingSpace getParkingSpaceById(Long id);

    List<ParkingSpace> getAllParkingSpaces();

    ParkingSpace updateParkingSpace(Long id, ParkingSpace parkingSpace);

    void deleteParkingSpace(Long id);
}