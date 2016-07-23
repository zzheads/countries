package com.zzheads.countries.controller;

import com.zzheads.countries.data.CountriesRepository;
import com.zzheads.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CountriesController {
    @Autowired
    private CountriesRepository countriesRepository;

    @RequestMapping({"/","/sorted_name"})
    public String homeSortedByName (ModelMap modelMap) {
        List<Country> allCountries = countriesRepository.getAllSortedByName();
        modelMap.put("countries", allCountries);
        modelMap.put("sorted", "name");
        return "index";
    }

    @RequestMapping("/sorted_pop")
    public String homeSortedByPopulation (ModelMap modelMap) {
        List<Country> allCountries = countriesRepository.getAllSortedByPopulation();
        modelMap.put("countries", allCountries);
        modelMap.put("sorted", "population");
        return "index";
    }

    @RequestMapping ("/{page}")
    public String countryDetails (@PathVariable String page, ModelMap modelMap) {
        Country country = countriesRepository.getByPage(page);
        String[] languages = countriesRepository.getOfficialLanguages(country.getName());
        modelMap.put("country", country);
        modelMap.put("languages", languages);
        return "country";
    }

}
