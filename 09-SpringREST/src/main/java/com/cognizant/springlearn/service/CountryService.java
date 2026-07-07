package com.cognizant.springlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        // The PDF requests a case-insensitive search (e.g., "in" or "IN" should work)
        Optional<Country> country = countryRepository.findById(code.toUpperCase());
        
        if (!country.isPresent()) {
            throw new CountryNotFoundException();
        }
        return country.get();
    }
}