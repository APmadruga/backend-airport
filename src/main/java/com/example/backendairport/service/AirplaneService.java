package com.example.backendairport.service;

import com.example.backendairport.model.Airplane;
import com.example.backendairport.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService implements AirplaneRepository {

    @Autowired
    AirplaneRepository airplaneRepository;

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public List<Airplane> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Airplane> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Airplane> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        airplaneRepository.deleteById(aLong);
    }

    @Override
    public void delete(Airplane entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Airplane> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Airplane> S save(S entity) {
        return airplaneRepository.save(entity);
    }

    @Override
    public <S extends Airplane> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Airplane> findById(Long aLong) {
        return airplaneRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Airplane> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Airplane> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Airplane> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Airplane getOne(Long aLong) {
        return null;
    }

    @Override
    public Airplane getById(Long aLong) {
        return airplaneRepository.getById(aLong);
    }

    @Override
    public <S extends Airplane> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Airplane> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Airplane> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Airplane> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Airplane> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Airplane> boolean exists(Example<S> example) {
        return false;
    }
}
