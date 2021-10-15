package com.example.backendairport.model;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="Airplane")
@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    private AirplaneType airplaneType;
    private String name;
    private int passengersCapacity;
    private int cargoCapacity;
}
