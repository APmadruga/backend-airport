package com.example.backendairport.service;

import com.example.backendairport.model.Airplane;
import com.example.backendairport.model.CabinCrew;
import com.example.backendairport.repository.AirplaneRepository;
import com.example.backendairport.repository.CabinCrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinCrewService implements CabinCrewRepository {

    @Autowired
    CabinCrewRepository cabinCrewRepository;

    @Autowired
    AirplaneRepository airplaneRepository;

    @Override
    public List<CabinCrew> findAll() {
        return cabinCrewRepository.findAll();
    }

    @Override
    public List<CabinCrew> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CabinCrew> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CabinCrew> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        cabinCrewRepository.deleteById(aLong);
    }

    @Override
    public void delete(CabinCrew entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends CabinCrew> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends CabinCrew> S save(S entity) {
        return cabinCrewRepository.save(entity);
    }

    @Override
    public <S extends CabinCrew> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CabinCrew> findById(Long aLong) {
        return cabinCrewRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends CabinCrew> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends CabinCrew> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<CabinCrew> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CabinCrew getOne(Long aLong) {
        return null;
    }

    @Override
    public CabinCrew getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends CabinCrew> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CabinCrew> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CabinCrew> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CabinCrew> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CabinCrew> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CabinCrew> boolean exists(Example<S> example) {
        return false;
    }

    public CabinCrew save(CabinCrew newCabinCrew, Long airplaneId) {
        Airplane airplane = airplaneRepository.getById(airplaneId);
        newCabinCrew.setAirplane(airplane);
        return cabinCrewRepository.save(newCabinCrew);
    }
}
