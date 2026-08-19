package lk.ijse.parkingspaceservice.api.controller;

import lk.ijse.parkingspaceservice.api.response.ApiResponse;
import lk.ijse.parkingspaceservice.entity.ParkingSpace;
import lk.ijse.parkingspaceservice.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parking-spaces")
@RequiredArgsConstructor
public class ParkingSpaceController {

    private final ParkingSpaceService parkingSpaceService;

    @PostMapping
    public ResponseEntity<ApiResponse<ParkingSpace>> saveParkingSpace(
            @RequestBody ParkingSpace parkingSpace) {

        ParkingSpace savedParkingSpace =
                parkingSpaceService.saveParkingSpace(parkingSpace);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        201,
                        "Parking space created successfully",
                        savedParkingSpace
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ParkingSpace>>>
    getAllParkingSpaces() {

        List<ParkingSpace> parkingSpaces =
                parkingSpaceService.getAllParkingSpaces();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Parking spaces retrieved successfully",
                        parkingSpaces
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ParkingSpace>>
    getParkingSpaceById(@PathVariable Long id) {

        ParkingSpace parkingSpace =
                parkingSpaceService.getParkingSpaceById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Parking space retrieved successfully",
                        parkingSpace
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ParkingSpace>>
    updateParkingSpace(
            @PathVariable Long id,
            @RequestBody ParkingSpace parkingSpace) {

        ParkingSpace updatedParkingSpace =
                parkingSpaceService.updateParkingSpace(id, parkingSpace);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Parking space updated successfully",
                        updatedParkingSpace
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>
    deleteParkingSpace(@PathVariable Long id) {

        parkingSpaceService.deleteParkingSpace(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        204,
                        "Parking space deleted successfully",
                        null
                )
        );
    }

    @GetMapping("/available")
    public ResponseEntity<ApiResponse<List<ParkingSpace>>>
    getAvailableParkingSpaces() {

        List<ParkingSpace> parkingSpaces =
                parkingSpaceService.getAvailableParkingSpaces();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Available parking spaces retrieved successfully",
                        parkingSpaces
                )
        );
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<ApiResponse<List<ParkingSpace>>>
    getParkingSpacesByLocation(
            @PathVariable String location) {

        List<ParkingSpace> parkingSpaces =
                parkingSpaceService.getParkingSpacesByLocation(location);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Parking spaces retrieved successfully for location: "
                                + location,
                        parkingSpaces
                )
        );
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<ParkingSpace>>>
    getParkingSpacesByLocationAndStatus(
            @RequestParam String location,
            @RequestParam String status) {

        List<ParkingSpace> parkingSpaces =
                parkingSpaceService
                        .getParkingSpacesByLocationAndStatus(location, status);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Parking spaces retrieved successfully",
                        parkingSpaces
                )
        );
    }

    @PatchMapping("/{id}/reserve")
    public ResponseEntity<ApiResponse<ParkingSpace>>
    reserveParkingSpace(@PathVariable Long id) {

        ParkingSpace parkingSpace =
                parkingSpaceService.reserveParkingSpace(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Parking space reserved successfully",
                        parkingSpace
                )
        );
    }

    @PatchMapping("/{id}/release")
    public ResponseEntity<ApiResponse<ParkingSpace>>
    releaseParkingSpace(@PathVariable Long id) {

        ParkingSpace parkingSpace =
                parkingSpaceService.releaseParkingSpace(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Parking space released successfully",
                        parkingSpace
                )
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<ParkingSpace>>
    updateParkingSpaceStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        ParkingSpace parkingSpace =
                parkingSpaceService.updateParkingSpaceStatus(id, status);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Parking space status updated successfully",
                        parkingSpace
                )
        );
    }
}