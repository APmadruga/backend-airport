package com.example.backendairport.service;
import com.example.backendairport.exception.ResourceNotFound;
import com.example.backendairport.model.Airplane;
import com.example.backendairport.model.Passenger;
import com.example.backendairport.repository.AirplaneRepository;
import com.example.backendairport.repository.PassengerRepository;
import com.example.backendairport.controller.request.PassengerCreationRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PassengerService{

    PassengerRepository passengerRepository;

    AirplaneRepository airplaneRepository;

    public PassengerService(PassengerRepository passengerRepository, AirplaneRepository airplaneRepository) {
        this.passengerRepository = passengerRepository;
        this.airplaneRepository = airplaneRepository;
    }


    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public Passenger findById(Long aLong) {
        return passengerRepository.findById(aLong).orElseThrow(() -> new ResourceNotFound("Passenger doesn't exist"));
    }

    public void deleteById(Long aLong) {
        if (!passengerRepository.existsById(aLong)){
            throw new ResourceNotFound("Passenger doesn't exist");
        }
        passengerRepository.deleteById(aLong);
    }

    public Passenger updatePassengerDetails(Long passengerId, PassengerCreationRequest passengerCreationRequest) {
        if (!passengerRepository.existsById(passengerId)){
            throw new ResourceNotFound("Passenger doesn't exist");
        }
        if (!airplaneRepository.existsById(passengerCreationRequest.getAirplaneId())){
            throw new ResourceNotFound("You need to add an Existing Plane");
        }
        Passenger passengerToBeUpdated = passengerRepository.findById(passengerId).get();
        Airplane airplaneToBeAdded = airplaneRepository.findById(passengerCreationRequest.getAirplaneId()).get();
        passengerToBeUpdated.setName(passengerCreationRequest.getName());
        passengerToBeUpdated.setPassportNumber(passengerCreationRequest.getPassportNumber());
        passengerToBeUpdated.setTicketNumber(passengerCreationRequest.getTicketNumber());
        passengerToBeUpdated.setTicketPrice(passengerCreationRequest.getTicketPrice());
        passengerToBeUpdated.setAirplane(airplaneToBeAdded);
        return passengerRepository.save(passengerToBeUpdated);
    }

    public Passenger save(PassengerCreationRequest passengerCreationRequest) {
        Long airplaneId = passengerCreationRequest.getAirplaneId();
        String name = passengerCreationRequest.getName();
        int passportNumber = passengerCreationRequest.getPassportNumber();
        int ticketNumber = passengerCreationRequest.getTicketNumber();
        int ticketPrice = passengerCreationRequest.getTicketPrice();
        if (!airplaneRepository.existsById(airplaneId)){
            throw new ResourceNotFound("You need to add an Existing Plane");
        }
        Airplane airplaneToBeAssociated = airplaneRepository.getById(airplaneId);
        Passenger newPassenger = Passenger
                .builder()
                .name(name)
                .passportNumber(passportNumber)
                .ticketNumber(ticketNumber)
                .ticketPrice(ticketPrice)
                .airplane(airplaneToBeAssociated)
                .build();
         return passengerRepository.save(newPassenger);
    }
}
