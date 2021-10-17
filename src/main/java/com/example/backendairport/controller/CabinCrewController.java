package com.example.backendairport.controller;
import com.example.backendairport.model.CabinCrew;
import com.example.backendairport.controller.request.CabinCrewCreationRequest;
import com.example.backendairport.service.CabinCrewService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class CabinCrewController {

    CabinCrewService cabinCrewService;

    public CabinCrewController(CabinCrewService cabinCrewService) {
        this.cabinCrewService = cabinCrewService;
    }


    @PostMapping(value ="/cabinCrew", consumes = "application/json", produces = "application/json")
    public ResponseEntity createCabinCrew(@RequestBody CabinCrewCreationRequest cabinCrewCreationRequest){
        Long cabinCrewId = cabinCrewService.createCabinCrew(cabinCrewCreationRequest).getId();
        return ResponseEntity.created(URI.create("/cabinCrew/" + cabinCrewId)).body("Operation run smoothly");
    }

    @GetMapping("/cabinCrews")
    public List<CabinCrew> cabinCrewList(){
        return cabinCrewService.findAll();
    }

    @GetMapping("/cabinCrew/{id}")
    public CabinCrew cabinCrewById(@PathVariable(value = "id") Long cabinCrewId) {
        return cabinCrewService.findById(cabinCrewId);
    }

    @PutMapping(value ="cabinCrew/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateCabinCrew(@PathVariable(value = "id") Long cabinCrewId, @RequestBody CabinCrewCreationRequest cabinCrewCreationRequest){
        cabinCrewService.updateCabinCrew(cabinCrewId, cabinCrewCreationRequest);
        return ResponseEntity.created(URI.create("/cabinCrew/" + cabinCrewId)).body("Operation run smoothly");
    }

    @DeleteMapping(path ="cabinCrew/{id}")
    public ResponseEntity deleteCabinCrew(@PathVariable(value = "id") Long cabinCrewId) {
        cabinCrewService.deleteById(cabinCrewId);
        return ResponseEntity.created(URI.create("/cabinCrew/")).body("Operation run smoothly");
    }
}
