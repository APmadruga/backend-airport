package com.example.backendairport.model;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="CabinCrew")
@Entity
public class CabinCrew {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int crewMembers;
    private int pilots;
    @ManyToOne
    @JoinColumn(name= "id_airplane")
    private Airplane airplane;

}
