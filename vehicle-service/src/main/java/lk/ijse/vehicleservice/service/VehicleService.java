package lk.ijse.vehicleservice.service;

import lk.ijse.vehicleservice.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle saveVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Long vehicleId, Vehicle vehicle);

    Vehicle getVehicle(Long vehicleId);

    List<Vehicle> getAllVehicles();

    void deleteVehicle(Long vehicleId);

    Vehicle vehicleEntry(Long vehicleId);

    Vehicle vehicleExit(Long vehicleId);
}