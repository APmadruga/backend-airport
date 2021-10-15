package com.example.backendairport.service;

import com.example.backendairport.exception.PassengerException;
import com.example.backendairport.model.Airplane;
import com.example.backendairport.model.Passenger;
import com.example.backendairport.repository.AirplaneRepository;
import com.example.backendairport.repository.PassengerRepository;
import com.example.backendairport.request.PassengerCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService{

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    AirplaneRepository airplaneRepository;


    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public List<Passenger> findAll(Sort sort) {
        return null;
    }

    public Page<Passenger> findAll(Pageable pageable) {
        return null;
    }

    public List<Passenger> findAllById(Iterable<Long> longs) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Long aLong) {
        passengerRepository.deleteById(aLong);
    }

    public void delete(Passenger entity) {

    }

    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    public void deleteAll(Iterable<? extends Passenger> entities) {

    }

    public void deleteAll() {

    }
/*
    public <S extends Passenger> S save(S entity) throws PassengerException {
        if(this.checkIfPassengerExists(entity)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Passenger is already in database.");
        }
        return this.passengerRepository.save(entity);
    }*/

    public Passenger save(Passenger newPassenger)  {
        return passengerRepository.save(newPassenger);
    }

    public Passenger updatePassengerDetails(Long passengerId, PassengerCreationRequest passengerCreationRequest) {
        Passenger passengerToBeUpdated = passengerRepository.findById(passengerId).get();
        Airplane airplanetobeAdded = airplaneRepository.findById(passengerCreationRequest.getAirplaneId()).get();

        passengerToBeUpdated.setName(passengerCreationRequest.getName());
        passengerToBeUpdated.setPassportNumber(passengerCreationRequest.getPassportNumber());
        passengerToBeUpdated.setTicketNumber(passengerCreationRequest.getTicketNumber());
        passengerToBeUpdated.setTicketPrice(passengerCreationRequest.getTicketPrice());
        passengerToBeUpdated.setAirplane(airplanetobeAdded);

        return passengerRepository.save(passengerToBeUpdated);
    }
   /* public boolean checkIfPassengerExists(Passenger passenger){
        if(passenger.getId() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found in DataBase");
        }
        return this.passengerRepository.existsById(passenger.getId());
    }*/

    public <S extends Passenger> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    public Passenger findById(Long aLong) {
        return passengerRepository.findById(aLong).get();
    }

    public boolean existsById(Long aLong) {
        return false;
    }

    public void flush() {

    }

    public <S extends Passenger> S saveAndFlush(S entity) {
        return null;
    }

    public <S extends Passenger> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    public void deleteAllInBatch(Iterable<Passenger> entities) {

    }

    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    public void deleteAllInBatch() {

    }

    public Passenger getOne(Long aLong) {
        return null;
    }

    public Passenger getById(Long aLong) {
        return null;
    }

    public <S extends Passenger> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    public <S extends Passenger> List<S> findAll(Example<S> example) {
        return null;
    }

    public <S extends Passenger> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    public <S extends Passenger> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    public <S extends Passenger> long count(Example<S> example) {
        return 0;
    }

    public <S extends Passenger> boolean exists(Example<S> example) {
        return false;
    }



}
