package com.example.backendairport.service;
import com.example.backendairport.model.Airplane;
import com.example.backendairport.model.CabinCrew;
import com.example.backendairport.repository.AirplaneRepository;
import com.example.backendairport.repository.CabinCrewRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        cabinCrewRepository.deleteById(aLong);
    }

    public <S extends CabinCrew> S save(S entity) {
        return cabinCrewRepository.save(entity);
    }

    public Optional<CabinCrew> findById(Long aLong) {
        return cabinCrewRepository.findById(aLong);
    }

    public CabinCrew save(CabinCrew newCabinCrew, Long airplaneId) {
        Airplane airplane = airplaneRepository.getById(airplaneId);
        newCabinCrew.setAirplane(airplane);
        return cabinCrewRepository.save(newCabinCrew);
    }
}
