package com.example.backendairport.service;
import com.example.backendairport.controller.request.AirplaneCreationRequest;
import com.example.backendairport.exception.ResourceNotFound;
import com.example.backendairport.model.Airplane;
import com.example.backendairport.model.AirplaneType;
import com.example.backendairport.repository.AirplaneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirplaneService{
    AirplaneRepository airplaneRepository;

    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }


    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    public void deleteById(Long aLong) {
        airplaneRepository.deleteById(aLong);
    }

    public Airplane findById(Long aLong) {
        return airplaneRepository.findById(aLong).orElseThrow(() -> new ResourceNotFound("Airplane doesn't exist"));
    }

    public Airplane create(AirplaneCreationRequest airplaneCreationRequest) {
        List<String> listTypes = new ArrayList<String>();
        listTypes.add(AirplaneType.AIRBUSA320.toString());
        listTypes.add(AirplaneType.BOEING747.toString());
        listTypes.add(AirplaneType.JETPLANE.toString());
        if (!listTypes.contains(airplaneCreationRequest.getAirplaneType().toString())){
            throw new ResourceNotFound("You can only choose AIRBUSA320 or BOING747 or JETPLANE in AirplaneType");
        }
        AirplaneType airplaneType = airplaneCreationRequest.getAirplaneType();
        String airplaneName = airplaneCreationRequest.getName();
        int passengersCapacity = airplaneCreationRequest.getPassengersCapacity();
        int cargoCapacity = airplaneCreationRequest.getCargoCapacity();
        Airplane newAirplane = Airplane
                .builder()
                .name(airplaneName)
                .airplaneType(airplaneType)
                .cargoCapacity(cargoCapacity)
                .passengersCapacity(cargoCapacity)
                .build();
        return airplaneRepository.save(newAirplane);
    }

    public Airplane updateAirplane(Long airplaneId, AirplaneCreationRequest airplaneCreationRequest) {
        List<String> listTypes = new ArrayList<String>();
        listTypes.add(AirplaneType.AIRBUSA320.toString());
        listTypes.add(AirplaneType.BOEING747.toString());
        listTypes.add(AirplaneType.JETPLANE.toString());
        if (!listTypes.contains(airplaneCreationRequest.getAirplaneType().toString())){
            throw new ResourceNotFound("You can only choose AIRBUSA320 or BOING747 or JETPLANE in AirplaneType");
        }
        AirplaneType airplaneType = airplaneCreationRequest.getAirplaneType();
        String airplaneName = airplaneCreationRequest.getName();
        int passengersCapacity = airplaneCreationRequest.getPassengersCapacity();
        int cargoCapacity = airplaneCreationRequest.getCargoCapacity();
        if(!airplaneRepository.existsById(airplaneId)){
            throw new ResourceNotFound("Airplane doesn't exist");
        }
        Airplane airplaneToBeUpdated = airplaneRepository.getById(airplaneId);
        airplaneToBeUpdated.setAirplaneType(airplaneType);
        airplaneToBeUpdated.setPassengersCapacity(passengersCapacity);
        airplaneToBeUpdated.setCargoCapacity(cargoCapacity);
        airplaneToBeUpdated.setName(airplaneName);
        return airplaneRepository.save(airplaneToBeUpdated);
    }
}
