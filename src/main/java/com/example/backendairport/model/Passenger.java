package com.example.backendairport.model;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Passenger")
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int passportNumber;
    private int ticketNumber;
    private int ticketPrice;

    @ManyToOne
    @JoinColumn(name= "id_airplane")
    private Airplane airplane;

}
