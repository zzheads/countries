package com.zzheads.countries.model;

import java.util.ArrayList;

public class Country {
    // Gather current, accurate information on the five countries you’ll be including in your application. The information must include the following:
    //  Country name
    //  Population
    //  Capital city
    //  Official language(s)
    //  Image of flag

    private String name;
    private long population;
    private String capital;
    private String language;
    private String flag;
    private String page;
    private String populationString;

    public Country(String name, long population, String capital, String language, String flag) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.language = language;
        this.flag = flag;
        page = name.toLowerCase().replaceAll(" ", "_");

        populationString = Long.toString(population);
        int len = populationString.length();
        int commas = len / 3;
        int startPos = len - commas * 3;
        if (startPos == 0) startPos = 3;
        char[] charArray = populationString.toCharArray();
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (startPos == i) {
                result.add(',');
                startPos += 3;
            }
            result.add(charArray[i]);
        }
        StringBuilder builder = new StringBuilder(result.size());
        for (Character ch : result) {
            builder.append(ch);
        }
        populationString = builder.toString();
    }

    public String getPopulationString() {
        return populationString;
    }

    public void setPopulationString(String populationString) {
        this.populationString = populationString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
