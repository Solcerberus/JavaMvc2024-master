package com.example.javamvc2024.controllers;

import com.example.javamvc2024.entities.ForecastEntity;
import com.example.javamvc2024.models.ForecastModel;
import com.example.javamvc2024.models.ForecastSaveModel;
import com.example.javamvc2024.repositories.ForecastRepository;
import com.example.javamvc2024.services.MeteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ForecastRestController {
    @Autowired
    private ForecastRepository forecastRepository;
    @PostMapping("/saveData")
    public void saveData(@RequestBody ForecastSaveModel model) throws IOException {
        var date = model.dateTime;
        var city = model.city;

        var temperature = MeteoService.getTemperature(city, date);

        var forecastEntity = new ForecastEntity(city, date, temperature);
        forecastRepository.save(forecastEntity);
    }
}
