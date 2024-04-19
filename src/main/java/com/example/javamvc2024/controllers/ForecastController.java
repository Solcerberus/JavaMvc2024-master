package com.example.javamvc2024.controllers;

import com.example.javamvc2024.models.ForecastModel;
import com.example.javamvc2024.models.IndexModel;
import com.example.javamvc2024.models.Root;
import com.example.javamvc2024.services.MeteoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class ForecastController {

    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false) String city) throws IOException {
        ModelAndView modelAndView = new ModelAndView("index");

        var indexModel = new IndexModel();
        indexModel.city = city;

        var forecasts = MeteoService.getForecasts(city);
        indexModel.forecasts = forecasts;

        modelAndView.addObject("indexModel", indexModel);

        return modelAndView;
    }
}
