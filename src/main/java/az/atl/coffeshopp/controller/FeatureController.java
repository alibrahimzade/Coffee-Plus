package az.atl.coffeshopp.controller;

import az.atl.coffeshopp.model.dto.FeatureDto;
import az.atl.coffeshopp.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feature")
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping("/byId/{id}")
    public ResponseEntity<FeatureDto> getFeatureById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(featureService.findFeatureById(id));
    }

    @GetMapping("/getAllFeature")
    public ResponseEntity<List<FeatureDto>> getAllFeatures(){
        return ResponseEntity.ok(featureService.findAllFeatures());
    }


    @PutMapping("/updateFeature/{id}")
    public ResponseEntity<?> updateFeature(@PathVariable Long id,
                                            @RequestBody FeatureDto featureDto){
        featureService.updateFeature(id,featureDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Feature updated successfully");
    }

    @PostMapping("/addFeature")
    public ResponseEntity<?> createFeature(@RequestBody FeatureDto featureDto){
        featureService.createFeature(featureDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Feature added successfully");
    }

    @DeleteMapping("/deleteFeatureById/{id}")
    public ResponseEntity<?> deleteFeatureById(@PathVariable Long id){
        featureService.deleteFeatureById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Feature Deleted successfully");
    }

    @DeleteMapping("/deleteAllPartners")
    public ResponseEntity<?> deleteAllFeatures(){
        featureService.deleteAllFeatures();
        return ResponseEntity.status(HttpStatus.OK).body("All features deleted");
    }

}
