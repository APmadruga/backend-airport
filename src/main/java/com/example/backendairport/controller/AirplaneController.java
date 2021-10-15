package com.example.backendairport.controller;
import com.example.backendairport.model.Airplane;
import com.example.backendairport.service.AirplaneService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class AirplaneController {

    AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    //Crud
    @PostMapping(value ="create-airplane", consumes = "application/json", produces = "application/json")
    public Airplane createAirplane(@RequestBody Airplane airplane){
        Airplane newAirplane = Airplane
                .builder()
                .name(airplane.getName())
                .airplaneType(airplane.getAirplaneType())
                .cargoCapacity(airplane.getCargoCapacity())
                .passengersCapacity(airplane.getPassengersCapacity())
                .build();

        return airplaneService.save(newAirplane);
    }

    //Read All
    @GetMapping("/airplane-list")
    public List<Airplane> airplaneList(){
        return airplaneService.findAll();
    }

    //Read by Id
    @GetMapping("/airplane/{id}")
    public Airplane airplaneById(@PathVariable(value = "id") Long airplaneId){
        return airplaneService.findById(airplaneId).get();
    }

    //Update
    @PutMapping(value ="upadate-airplane/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Airplane> updateAirplane(@PathVariable(value = "id") Long airplaneId, @RequestBody Airplane airplaneDetails){
        Airplane airplane = airplaneService.findById(airplaneId).get();

        airplane.setName(airplaneDetails.getName());
        airplane.setAirplaneType(airplaneDetails.getAirplaneType());
        airplane.setCargoCapacity(airplaneDetails.getCargoCapacity());
        airplane.setPassengersCapacity(airplaneDetails.getPassengersCapacity());

        final Airplane updatedAirplane = airplaneService.save(airplane);
        return ResponseEntity.ok(updatedAirplane);
    }

    //Delete
    @DeleteMapping(path = "delete-airplane/{id}")
    public void deleteAirplane(@PathVariable(value = "id") Long airplaneId) {
        airplaneService.deleteById(airplaneId);
    }
}
