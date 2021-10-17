package com.example.backendairport.controller.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CabinCrewCreationRequest {
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;
    private int crewMembers;
    private int pilots;
    private Long airplaneId;
}
