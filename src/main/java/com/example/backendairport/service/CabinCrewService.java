package com.example.backendairport.service;
import com.example.backendairport.controller.request.CabinCrewCreationRequest;
import com.example.backendairport.exception.ResourceNotFound;
import com.example.backendairport.model.Airplane;
import com.example.backendairport.model.CabinCrew;
import com.example.backendairport.repository.AirplaneRepository;
import com.example.backendairport.repository.CabinCrewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CabinCrewService {
    CabinCrewRepository cabinCrewRepository;
    AirplaneRepository airplaneRepository;

    public CabinCrewService(CabinCrewRepository cabinCrewRepository, AirplaneRepository airplaneRepository) {
        this.cabinCrewRepository = cabinCrewRepository;
        this.airplaneRepository = airplaneRepository;
    }


    public List<CabinCrew> findAll() {
        return cabinCrewRepository.findAll();
    }

    public void deleteById(Long aLong) {
        if (!cabinCrewRepository.existsById(aLong)){
            throw new ResourceNotFound("CabinCrew doesn't exist");
        }
        cabinCrewRepository.deleteById(aLong);
    }

    public CabinCrew findById(Long aLong) {
        return cabinCrewRepository.findById(aLong).orElseThrow(() -> new ResourceNotFound("CabinCrew doesn't exist"));
    }

    public CabinCrew createCabinCrew(CabinCrewCreationRequest cabinCrewCreationRequest) {
        Long airplaneId = cabinCrewCreationRequest.getAirplaneId();
        String name = cabinCrewCreationRequest.getName();
        int crewMembersNumber = cabinCrewCreationRequest.getCrewMembers();
        int pilotsNumber = cabinCrewCreationRequest.getPilots();
        if (!airplaneRepository.existsById(airplaneId)){
            throw new ResourceNotFound("You need to add an Existing Plane");
        }
        Airplane airplaneTobeAdded = airplaneRepository.getById(airplaneId);
        CabinCrew newCabinCrew = CabinCrew
                .builder()
                .name(name)
                .pilots(pilotsNumber)
                .crewMembers(crewMembersNumber)
                .airplane(airplaneTobeAdded)
                .build();
        return cabinCrewRepository.save(newCabinCrew);
    }

    public CabinCrew updateCabinCrew(Long cabinCrewId, CabinCrewCreationRequest cabinCrewCreationRequest) {
        Long airplaneId = cabinCrewCreationRequest.getAirplaneId();
        String name = cabinCrewCreationRequest.getName();
        int crewMembersNumber = cabinCrewCreationRequest.getCrewMembers();
        int pilotsNumber = cabinCrewCreationRequest.getPilots();
        if (!cabinCrewRepository.existsById(cabinCrewId)){
            throw new ResourceNotFound("CabinCrew doesn't exist");
        }
        if (!airplaneRepository.existsById(airplaneId)){
            throw new ResourceNotFound("You need to add an Existing Plane");
        }
        CabinCrew cabinCrew = cabinCrewRepository.findById(cabinCrewId).get();
        Airplane airplane= airplaneRepository.getById(airplaneId);
        cabinCrew.setName(name);
        cabinCrew.setAirplane(airplane);
        cabinCrew.setCrewMembers(crewMembersNumber);
        cabinCrew.setPilots(pilotsNumber);
        return cabinCrewRepository.save(cabinCrew);
    }
}
