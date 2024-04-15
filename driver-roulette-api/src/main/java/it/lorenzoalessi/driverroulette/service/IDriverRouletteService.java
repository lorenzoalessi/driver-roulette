package it.lorenzoalessi.driverroulette.service;

import java.util.List;

public interface IDriverRouletteService {

    String getRandomDriver(List<String> inputNames);
}
