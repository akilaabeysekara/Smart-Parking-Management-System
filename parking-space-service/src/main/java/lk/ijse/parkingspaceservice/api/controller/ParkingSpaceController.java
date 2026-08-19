package lk.ijse.parkingspaceservice.api.controller;

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

    // Create parking space
    @PostMapping
    public ResponseEntity<ParkingSpace> saveParkingSpace(
            @RequestBody ParkingSpace parkingSpace) {

        return new ResponseEntity<>(
                parkingSpaceService.saveParkingSpace(parkingSpace),
                HttpStatus.CREATED
        );
    }

    // Get all parking spaces
    @GetMapping
    public ResponseEntity<List<ParkingSpace>> getAllParkingSpaces() {

        return ResponseEntity.ok(
                parkingSpaceService.getAllParkingSpaces()
        );
    }

    // Get parking space by ID
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpace> getParkingSpaceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                parkingSpaceService.getParkingSpaceById(id)
        );
    }

    // Update parking space
    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpace> updateParkingSpace(
            @PathVariable Long id,
            @RequestBody ParkingSpace parkingSpace) {

        return ResponseEntity.ok(
                parkingSpaceService.updateParkingSpace(id, parkingSpace)
        );
    }

    // Delete parking space
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpace(
            @PathVariable Long id) {

        parkingSpaceService.deleteParkingSpace(id);

        return ResponseEntity.noContent().build();
    }

    // Get available parking spaces
    @GetMapping("/available")
    public ResponseEntity<List<ParkingSpace>> getAvailableParkingSpaces() {

        return ResponseEntity.ok(
                parkingSpaceService.getAvailableParkingSpaces()
        );
    }

    // Get parking spaces by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<ParkingSpace>> getParkingSpacesByLocation(
            @PathVariable String location) {

        return ResponseEntity.ok(
                parkingSpaceService.getParkingSpacesByLocation(location)
        );
    }

    // Get parking spaces by location and status
    @GetMapping("/search")
    public ResponseEntity<List<ParkingSpace>>
    getParkingSpacesByLocationAndStatus(
            @RequestParam String location,
            @RequestParam String status) {

        return ResponseEntity.ok(
                parkingSpaceService
                        .getParkingSpacesByLocationAndStatus(location, status)
        );
    }

    // Reserve parking space
    @PatchMapping("/{id}/reserve")
    public ResponseEntity<ParkingSpace> reserveParkingSpace(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                parkingSpaceService.reserveParkingSpace(id)
        );
    }

    // Release parking space
    @PatchMapping("/{id}/release")
    public ResponseEntity<ParkingSpace> releaseParkingSpace(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                parkingSpaceService.releaseParkingSpace(id)
        );
    }

    // Update parking space status
    @PatchMapping("/{id}/status")
    public ResponseEntity<ParkingSpace> updateParkingSpaceStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                parkingSpaceService.updateParkingSpaceStatus(id, status)
        );
    }
}