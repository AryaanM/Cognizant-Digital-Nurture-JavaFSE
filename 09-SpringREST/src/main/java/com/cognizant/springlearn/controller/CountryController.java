package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // HANDS-ON 1: Hello World RESTful Web Service
    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START: sayHello endpoint hit");
        LOGGER.info("END: sayHello endpoint returning");
        return "Hello World!!";
    }

    // HANDS-ON 2 & 3: REST - Get all countries
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START: getAllCountries endpoint hit");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("END: getAllCountries endpoint returning");
        return countries;
    }

    // HANDS-ON 4 & 5: REST - Get country based on code (with exception handling)
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START: getCountry endpoint hit with code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END: getCountry endpoint returning");
        return country;
    }
}