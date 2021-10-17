package com.example.backendairport.repository;
import com.example.backendairport.model.Passenger;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
