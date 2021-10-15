package com.example.backendairport.service;
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
        return passengerRepository.findById(aLong).get();
    }

    public void deleteById(Long aLong) {
        passengerRepository.deleteById(aLong);
    }

    public Passenger save(Passenger newPassenger)  {
        return passengerRepository.save(newPassenger);
    }

    public Passenger updatePassengerDetails(Long passengerId, PassengerCreationRequest passengerCreationRequest) {
        Passenger passengerToBeUpdated = passengerRepository.findById(passengerId).get();
        Airplane airplaneToBeAdded = airplaneRepository.findById(passengerCreationRequest.getAirplaneId()).get();
        passengerToBeUpdated.setName(passengerCreationRequest.getName());
        passengerToBeUpdated.setPassportNumber(passengerCreationRequest.getPassportNumber());
        passengerToBeUpdated.setTicketNumber(passengerCreationRequest.getTicketNumber());
        passengerToBeUpdated.setTicketPrice(passengerCreationRequest.getTicketPrice());
        passengerToBeUpdated.setAirplane(airplaneToBeAdded);
        return passengerRepository.save(passengerToBeUpdated);
    }
}
