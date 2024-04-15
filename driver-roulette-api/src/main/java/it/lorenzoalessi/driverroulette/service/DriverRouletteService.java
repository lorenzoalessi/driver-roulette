package it.lorenzoalessi.driverroulette.service;

import it.lorenzoalessi.driverroulette.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Service
public class DriverRouletteService implements IDriverRouletteService {

    private final ApplicationProperties applicationProperties;

    @Autowired
    public DriverRouletteService(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public String getRandomDriver(List<String> inputNames) {
        List<String> allNames = applicationProperties.getNames();

        if (!new HashSet<>(allNames).containsAll(inputNames))
            throw new IllegalArgumentException("Invalid names provided");

        Random random = new Random();

        return inputNames.get(random.nextInt(inputNames.size()));
    }
}
