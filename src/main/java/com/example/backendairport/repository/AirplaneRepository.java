package com.example.backendairport.repository;
import com.example.backendairport.model.Airplane;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
