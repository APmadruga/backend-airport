package com.example.backendairport.service;
import com.example.backendairport.model.Airplane;
import com.example.backendairport.repository.AirplaneRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public <S extends Airplane> S save(S entity) {
        return airplaneRepository.save(entity);
    }

    public Optional<Airplane> findById(Long aLong) {
        return airplaneRepository.findById(aLong);
    }

    public Airplane getById(Long aLong) {
        return airplaneRepository.getById(aLong);
    }
}
