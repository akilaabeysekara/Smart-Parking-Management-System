package lk.ijse.parkingspaceservice.api.controller;

import lk.ijse.parkingspaceservice.Entity.ParkingSpace;
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
    public ResponseEntity<ParkingSpace> saveParkingSpace(
            @RequestBody ParkingSpace parkingSpace) {

        return new ResponseEntity<>(
                parkingSpaceService.saveParkingSpace(parkingSpace),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpace> getParkingSpace(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                parkingSpaceService.getParkingSpaceById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpace>> getAllParkingSpaces() {

        return ResponseEntity.ok(
                parkingSpaceService.getAllParkingSpaces()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpace> updateParkingSpace(
            @PathVariable Long id,
            @RequestBody ParkingSpace parkingSpace) {

        return ResponseEntity.ok(
                parkingSpaceService.updateParkingSpace(id, parkingSpace)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpace(
            @PathVariable Long id) {

        parkingSpaceService.deleteParkingSpace(id);

        return ResponseEntity.noContent().build();
    }
}