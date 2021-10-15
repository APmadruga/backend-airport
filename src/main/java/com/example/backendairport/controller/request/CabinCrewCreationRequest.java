package com.example.backendairport.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
