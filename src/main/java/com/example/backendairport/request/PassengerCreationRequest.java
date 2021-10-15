package com.example.backendairport.request;

import com.example.backendairport.model.Airplane;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//POJO
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PassengerCreationRequest {

    @NotBlank(message = "Name is a mandatory field.")
    private String name;
    private int passportNumber;
    private int ticketNumber;
    private int ticketPrice;
    private Long airplaneId;


}
