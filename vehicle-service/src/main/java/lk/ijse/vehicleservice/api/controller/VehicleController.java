package lk.ijse.vehicleservice.api.controller;

import lk.ijse.vehicleservice.api.response.ApiResponse;
import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<ApiResponse<Vehicle>> saveVehicle(
            @RequestBody Vehicle vehicle) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        201,
                        "Vehicle saved successfully",
                        vehicleService.saveVehicle(vehicle)
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<ApiResponse<Vehicle>> updateVehicle(
            @PathVariable Long vehicleId,
            @RequestBody Vehicle vehicle) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        200,
                        "Vehicle updated successfully",
                        vehicleService.updateVehicle(vehicleId, vehicle)
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<ApiResponse<Vehicle>> getVehicle(
            @PathVariable Long vehicleId) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        200,
                        "Vehicle retrieved successfully",
                        vehicleService.getVehicle(vehicleId)
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Vehicle>>> getAllVehicles() {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        200,
                        "Vehicles retrieved successfully",
                        vehicleService.getAllVehicles()
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<ApiResponse<Void>> deleteVehicle(
            @PathVariable Long vehicleId) {

        vehicleService.deleteVehicle(vehicleId);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        200,
                        "Vehicle deleted successfully",
                        null
                ),
                HttpStatus.NO_CONTENT
        );
    }

    @PostMapping("/{vehicleId}/entry")
    public ResponseEntity<ApiResponse<Vehicle>> vehicleEntry(
            @PathVariable Long vehicleId) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        200,
                        "Vehicle entry recorded successfully",
                        vehicleService.vehicleEntry(vehicleId)
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/{vehicleId}/exit")
    public ResponseEntity<ApiResponse<Vehicle>> vehicleExit(
            @PathVariable Long vehicleId) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        200,
                        "Vehicle exit recorded successfully",
                        vehicleService.vehicleExit(vehicleId)
                ),
                HttpStatus.OK
        );
    }
}