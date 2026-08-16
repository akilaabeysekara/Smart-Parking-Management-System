package lk.ijse.parkingspaceservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/parking")
public class ParkingSpaceController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/parking")
    public ResponseEntity<String> callOrderService() {
        String allParkingURL = "http://PARKING-SPACE-SERVICE/parking-space-service/api/v1/parking/all";
        String res = restTemplate.getForObject(allParkingURL, String.class);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllParkingSpaces() {
        return new ResponseEntity<>(
                "Parking Space Service Java is up and running",
                HttpStatus.OK
        );
    }
}