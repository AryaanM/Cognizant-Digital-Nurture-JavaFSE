package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");
        
        try {
            testGetAllCountries();
            testAddCountry();
            testUpdateCountry();
            testDeleteCountry();
        } catch (Exception e) {
            LOGGER.error("Error during execution: ", e);
        }
    }

    private static void testGetAllCountries() {
        LOGGER.info("--- Start testGetAllCountries ---");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("Countries: {}", countries);
        LOGGER.info("--- End testGetAllCountries ---");
    }

    private static void testAddCountry() throws Exception {
        LOGGER.info("--- Start testAddCountry ---");
        Country newCountry = new Country("FR", "France");
        countryService.addCountry(newCountry);
        Country country = countryService.findCountryByCode("FR");
        LOGGER.info("Added Country: {}", country);
        LOGGER.info("--- End testAddCountry ---");
    }

    private static void testUpdateCountry() throws Exception {
        LOGGER.info("--- Start testUpdateCountry ---");
        countryService.updateCountry("FR", "French Republic");
        Country updatedCountry = countryService.findCountryByCode("FR");
        LOGGER.info("Updated Country: {}", updatedCountry);
        LOGGER.info("--- End testUpdateCountry ---");
    }

    private static void testDeleteCountry() {
        LOGGER.info("--- Start testDeleteCountry ---");
        countryService.deleteCountry("FR");
        LOGGER.info("Country FR deleted successfully.");
        LOGGER.info("--- End testDeleteCountry ---");
    }
}