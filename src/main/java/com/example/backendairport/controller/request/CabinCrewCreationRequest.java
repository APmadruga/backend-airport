package com.example.backendairport.controller.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CabinCrewCreationRequest {
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @Min(value = 2)
    private int crewMembers;
    @Min(value = 2)
    private int pilots;
    private Long airplaneId;
}
