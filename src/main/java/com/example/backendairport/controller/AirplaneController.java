package com.example.backendairport.controller;
import com.example.backendairport.controller.request.AirplaneCreationRequest;
import com.example.backendairport.model.Airplane;
import com.example.backendairport.service.AirplaneService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class AirplaneController {

    AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }


    @PostMapping(value ="airplane", consumes = "application/json", produces = "application/json")
    public ResponseEntity createAirplane(@RequestBody AirplaneCreationRequest airplaneCreationRequest){
        Long airplaneId = airplaneService.create(airplaneCreationRequest).getId();
        return ResponseEntity.created(URI.create("/airplane" + airplaneId)).body("Operation run smoothly");
    }

    @GetMapping("/airplane-list")
    public List<Airplane> airplaneList(){
        return airplaneService.findAll();
    }

    @GetMapping("/airplane/{id}")
    public Airplane airplaneById(@PathVariable(value = "id") Long airplaneId){
        return airplaneService.findById(airplaneId);
    }

    @PutMapping(value ="upadate-airplane/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateAirplane(@PathVariable(value = "id") Long airplaneId, @RequestBody AirplaneCreationRequest airplaneCreationRequest){
        airplaneService.updateAirplane(airplaneId, airplaneCreationRequest);
        return ResponseEntity.created(URI.create("/airplane" + airplaneId)).body("Operation run smoothly");
    }

    @DeleteMapping(path = "delete-airplane/{id}")
    public ResponseEntity deleteAirplane(@PathVariable(value = "id") Long airplaneId) {
        airplaneService.deleteById(airplaneId);
        return ResponseEntity.created(URI.create("/airplane")).body("Operation run smoothly");
    }
}
