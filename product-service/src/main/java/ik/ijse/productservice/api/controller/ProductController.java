package ik.ijse.productservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public ResponseEntity<String> callOrderService() {
//        String allOrderURL = "http://localhost:8082/order-service/api/v1/order/all";
        String allOrderURL = "http://ORDER-SERVICE/order-service/api/v1/order/all";
        String res = restTemplate.getForObject(allOrderURL, String.class);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllProducts() {
        return new ResponseEntity<>(
                "Product Service Java is up and running",
                HttpStatus.OK
        );
    }
}