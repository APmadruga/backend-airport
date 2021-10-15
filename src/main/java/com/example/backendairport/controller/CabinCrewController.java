package com.example.backendairport.controller;

import com.example.backendairport.model.CabinCrew;
import com.example.backendairport.controller.request.CabinCrewCreationRequest;
import com.example.backendairport.service.CabinCrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@Validated
public class CabinCrewController {

    @Autowired
    CabinCrewService cabinCrewService;

    //Create
    @PostMapping(value ="create-cabinCrew", consumes = "application/json", produces = "application/json")
    public CabinCrew createCabinCrew(@RequestBody CabinCrewCreationRequest cabinCrewCreationRequest){
        CabinCrew newCabinCrew = CabinCrew
                .builder()
                .name(cabinCrewCreationRequest.getName())
                .pilots(cabinCrewCreationRequest.getPilots())
                .crewMembers(cabinCrewCreationRequest.getCrewMembers())
                .build();

        return cabinCrewService.save(newCabinCrew, cabinCrewCreationRequest.getAirplaneId());
    }

    //Read All
    @GetMapping("/cabinCrew-list")
    public List<CabinCrew> cabinCrewList(){
        return cabinCrewService.findAll();
    }

    //Read by Id
    @GetMapping("/cabinCrew/{id}")
    public CabinCrew cabinCrewById(@PathVariable(value = "id") Long cabinCrewId) {
        return cabinCrewService.findById(cabinCrewId).get();
    }

    //Update
    @PutMapping(value ="upadate-cabinCrew/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CabinCrew> updateCabinCrew(@PathVariable(value = "id") Long cabinCrewId, @RequestBody CabinCrew cabinCrewDetails){
        CabinCrew cabinCrew = cabinCrewService.findById(cabinCrewId).get();

        cabinCrew.setName(cabinCrewDetails.getName());
        cabinCrew.setAirplane(cabinCrewDetails.getAirplane());
        cabinCrew.setCrewMembers(cabinCrewDetails.getCrewMembers());
        cabinCrew.setPilots(cabinCrewDetails.getPilots());

        final CabinCrew updatedCabinCrew = cabinCrewService.save(cabinCrew);
        return ResponseEntity.ok(updatedCabinCrew);
    }

    //Delete
    @DeleteMapping(path = "delete-cabinCrew/{id}")
    public void deleteCabinCrew(@PathVariable(value = "id") Long cabinCrewId) {
        cabinCrewService.deleteById(cabinCrewId);
    }

}
