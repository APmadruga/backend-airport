package com.example.backendairport.controller.request;
import com.example.backendairport.model.AirplaneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AirplaneCreationRequest {
    private AirplaneType airplaneType;
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    private int passengersCapacity;
    private int cargoCapacity;
}
