package com.example.backendairport.controller;
import com.example.backendairport.model.Airplane;
import com.example.backendairport.model.Passenger;
import com.example.backendairport.controller.request.PassengerCreationRequest;
import com.example.backendairport.service.AirplaneService;
import com.example.backendairport.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class PassengerController {

    @Autowired
    PassengerService passengerService;
    @Autowired
    AirplaneService airplaneService;

    //Create
    @PostMapping(value ="create-passenger", consumes = "application/json", produces = "application/json")
    public Passenger createPassenger(@RequestBody @Valid PassengerCreationRequest passengerCreationRequest)  {
        Airplane airplaneToBeAssociated = airplaneService.getById(passengerCreationRequest.getAirplaneId());
        Passenger newPassenger = Passenger
                .builder()
                .name(passengerCreationRequest.getName())
                .passportNumber(passengerCreationRequest.getPassportNumber())
                .ticketNumber(passengerCreationRequest.getTicketNumber())
                .ticketPrice(passengerCreationRequest.getTicketPrice())
                .build();
        System.out.println("BLA");
        return passengerService.save(newPassenger);
    }

    //Read All
    @GetMapping("/passenger-list")
    public List<Passenger> passengerList(){
        return passengerService.findAll();
    }

    //Read by Id
    @GetMapping("/passenger/{id}")
    public Passenger passengerById(@PathVariable(value = "id") /*@Positive*/  Long passengerId){
        return passengerService.findById(passengerId);
    }

    //Update
    @PutMapping(value ="update-passenger/{id}", consumes = "application/json", produces = "application/json")
    public Passenger updatePassenger(@PathVariable(value = "id") Long passengerId,@RequestBody @Valid PassengerCreationRequest passengerCreationRequest)  {
        return passengerService.updatePassengerDetails(
                passengerId, passengerCreationRequest
                );
        /* Passenger passenger = passengerService.findById(passengerId).get();

        //do logic in services
        passenger.setName(passengerDetails.getName());
        passenger.setAirplane(passengerDetails.getAirplane());
        passenger.setPassportNumber(passengerDetails.getPassportNumber());
        passenger.setTicketNumber(passengerDetails.getTicketNumber());
        passenger.setTicketPrice(passengerDetails.getTicketPrice());

        Passenger updatedPassenger = passengerService.save(passenger);
        return Optional.ofNullable(updatedPassenger);*/
    }

    //Delete
    @DeleteMapping(path = "delete-passenger/{id}")
    public void deletePassenger(@PathVariable(value = "id") Long passengerId) {
        passengerService.deleteById(passengerId);
    }

}
