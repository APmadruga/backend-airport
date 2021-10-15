package com.example.backendairport.controller.request;
import lombok.*;
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
