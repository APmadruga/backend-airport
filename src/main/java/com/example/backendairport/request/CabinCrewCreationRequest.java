package com.example.backendairport.request;

import com.example.backendairport.model.Airplane;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CabinCrewCreationRequest {

    private String name;
    private int crewMembers;
    private int pilots;
    private Long airplaneId;
}
