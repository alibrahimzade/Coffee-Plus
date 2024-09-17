package az.atl.coffeshopp.controller;

import az.atl.coffeshopp.model.dto.PartnerDto;
import az.atl.coffeshopp.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/partner")
public class PartnerController {

    private final PartnerService partnerService;

    @GetMapping("/byId/{id}")
    public ResponseEntity<PartnerDto> getPartnerById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(partnerService.findPartnerById(id));
    }

    @GetMapping("/getAllPartners")
    public  ResponseEntity<List<PartnerDto>> getAllPartners(){
        return ResponseEntity.ok(partnerService.findAllPartners());
    }

    @PostMapping("/addPartner")
    public ResponseEntity<?> createPartner(@RequestBody PartnerDto partnerDto){
        partnerService.createPartner(partnerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Partner added successfully");
    }
    @PutMapping("/updatePartner/{id}")
    public ResponseEntity<?> updatePartner(@PathVariable Long id,
                                           @RequestBody PartnerDto partnerDto){
        partnerService.updatePartner(id,partnerDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Partner updated successfully");
    }

    @DeleteMapping("/deletePartnerById/{id}")
    public ResponseEntity<?> deletePartner(@PathVariable Long id){
        partnerService.deletePartnerById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Partner deleted successfully");
    }

    @DeleteMapping("/deleteAllPartners")
    public ResponseEntity<?> deletePartners(){
        partnerService.deleteAllPartners();
        return ResponseEntity.status(HttpStatus.OK).body("All partners deleted successfully");
    }
}
