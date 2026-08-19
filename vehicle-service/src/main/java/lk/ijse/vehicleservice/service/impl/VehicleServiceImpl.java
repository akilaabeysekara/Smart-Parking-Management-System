package lk.ijse.vehicleservice.service.impl;

import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.exception.CustomException;
import lk.ijse.vehicleservice.repo.VehicleRepository;
import lk.ijse.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle) {

        Vehicle existingVehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new CustomException(
                                "Vehicle not found with id: " + vehicleId
                        )
                );

        existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
        existingVehicle.setVehicleType(vehicle.getVehicleType());
        existingVehicle.setBrand(vehicle.getBrand());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setColor(vehicle.getColor());
        existingVehicle.setUserId(vehicle.getUserId());

        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public Vehicle getVehicle(Long vehicleId) {

        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new CustomException(
                                "Vehicle not found with id: " + vehicleId
                        )
                );
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public void deleteVehicle(Long vehicleId) {

        if (!vehicleRepository.existsById(vehicleId)) {
            throw new CustomException(
                    "Vehicle not found with id: " + vehicleId
            );
        }

        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    public Vehicle vehicleEntry(Long vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new CustomException(
                                "Vehicle not found with id: " + vehicleId
                        )
                );

        if ("PARKED".equals(vehicle.getStatus())) {
            throw new CustomException(
                    "Vehicle is already parked"
            );
        }

        vehicle.setEntryTime(LocalDateTime.now());
        vehicle.setExitTime(null);
        vehicle.setStatus("PARKED");

        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle vehicleExit(Long vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new CustomException(
                                "Vehicle not found with id: " + vehicleId
                        )
                );

        if (!"PARKED".equals(vehicle.getStatus())) {
            throw new CustomException(
                    "Vehicle is not currently parked"
            );
        }

        vehicle.setExitTime(LocalDateTime.now());
        vehicle.setStatus("EXITED");

        return vehicleRepository.save(vehicle);
    }
}