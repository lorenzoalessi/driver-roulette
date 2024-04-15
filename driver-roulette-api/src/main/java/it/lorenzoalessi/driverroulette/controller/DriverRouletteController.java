package it.lorenzoalessi.driverroulette.controller;

import it.lorenzoalessi.driverroulette.properties.ApplicationProperties;
import it.lorenzoalessi.driverroulette.service.IDriverRouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driverroulette")
public class DriverRouletteController {

    private final ApplicationProperties applicationProperties;
    private final IDriverRouletteService iDriverRouletteService;

    @Autowired
    public DriverRouletteController(ApplicationProperties applicationProperties, IDriverRouletteService iDriverRouletteService) {
        this.applicationProperties = applicationProperties;
        this.iDriverRouletteService = iDriverRouletteService;
    }

    @GetMapping("/names")
    public List<String> getNames() {
        return applicationProperties.getNames();
    }

    @GetMapping("/roulette")
    public ResponseEntity<String> getRandomDriver(@RequestBody List<String> inputNames) {
        if (inputNames == null || inputNames.isEmpty())
            return ResponseEntity.badRequest().body("Invalid input names");

        try {
            return ResponseEntity.ok(iDriverRouletteService.getRandomDriver(inputNames));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
