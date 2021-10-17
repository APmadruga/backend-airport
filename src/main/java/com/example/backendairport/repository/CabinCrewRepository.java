package com.example.backendairport.repository;
import com.example.backendairport.model.CabinCrew;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface CabinCrewRepository extends JpaRepository<CabinCrew, Long> {
}
