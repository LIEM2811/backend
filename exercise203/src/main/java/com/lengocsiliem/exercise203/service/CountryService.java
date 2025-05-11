package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;

import com.lengocsiliem.exercise203.entity.Country;

public interface CountryService {
    List<Country> getAllCountries();

    Optional<Country> getCountryById(Integer id);

    Country createCountry(Country country);

    Country updateCountry(Integer id, Country countryDetails);

    void deleteCountry(Integer id);
}
