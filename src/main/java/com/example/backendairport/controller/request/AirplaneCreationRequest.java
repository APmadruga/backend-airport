package com.example.backendairport.controller.request;
import com.example.backendairport.model.AirplaneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AirplaneCreationRequest {
    private AirplaneType airplaneType;
    private String name;
    private int passengersCapacity;
    private int cargoCapacity;
}
