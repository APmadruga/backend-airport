package com.example.backendairport.controller;
import com.example.backendairport.model.Passenger;
import com.example.backendairport.controller.request.PassengerCreationRequest;
import com.example.backendairport.service.AirplaneService;
import com.example.backendairport.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class PassengerController {
    PassengerService passengerService;
    AirplaneService airplaneService;

    public PassengerController(PassengerService passengerService, AirplaneService airplaneService) {
        this.passengerService = passengerService;
        this.airplaneService = airplaneService;
    }


    @PostMapping(value ="/passenger", consumes = "application/json", produces = "application/json")
    public ResponseEntity createPassenger(@RequestBody @Valid PassengerCreationRequest passengerCreationRequest)  {
        Long passengerId = passengerService.save(passengerCreationRequest).getId();
        return ResponseEntity.created(URI.create("/passenger/" + passengerId)).body("Operation run smoothly");
    }

    @GetMapping("/passengers")
    public List<Passenger> passengerList(){
        return passengerService.findAll();
    }

    @GetMapping("/passenger/{id}")
    public Passenger passengerById(@PathVariable(value = "id") Long passengerId){
        return passengerService.findById(passengerId);
    }

    @PutMapping(value ="passenger/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updatePassenger(@PathVariable(value = "id") Long passengerId,@RequestBody @Valid PassengerCreationRequest passengerCreationRequest)  {
        passengerService.updatePassengerDetails(passengerId, passengerCreationRequest);
        return ResponseEntity.created(URI.create("/passenger/" + passengerId)).body("Operation run smoothly");
    }

    @DeleteMapping(path = "passenger/{id}")
    public ResponseEntity deletePassenger(@PathVariable(value = "id") Long passengerId) {
        passengerService.deleteById(passengerId);
        return ResponseEntity.created(URI.create("/passenger" + passengerId)).body("Operation run smoothly");
    }
}
