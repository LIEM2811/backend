package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Country;
import com.lengocsiliem.exercise203.repository.CountryRepository;
import com.lengocsiliem.exercise203.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Integer id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Integer id, Country countryDetails) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        country.setIso(countryDetails.getIso());
        country.setName(countryDetails.getName());
        country.setUpperName(countryDetails.getUpperName());
        country.setIso3(countryDetails.getIso3());
        country.setNumCode(countryDetails.getNumCode());
        country.setPhoneCode(countryDetails.getPhoneCode());
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Integer id) {
        countryRepository.deleteById(id);
    }
}
