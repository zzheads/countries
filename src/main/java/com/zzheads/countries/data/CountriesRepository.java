package com.zzheads.countries.data;

import com.zzheads.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CountriesRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
    new Country("People's Republic of China",1378402000, "Pekin", "China", "china.png"),
    new Country("India", 1292667000, "Dehli", "Hindi, English", "india.png"),
    new Country("United States of America", 323906000, "Washington", "English", "usa.png"),
    new Country("Indonesia", 260581100, "Jakarta", "Indonesian", "indonesia.png"),
    new Country("Brazil", 205738180, "Brasilia", "Portugal", "brazil.png"),
    new Country("Pakistan", 194235630,"Islamabad", "Urdu, English", "pakistan.png"),
    new Country("Nigeria", 186987563,"Abudja", "English", "nigeria.png"),
    new Country("Bangladesh", 160991563, "Dakka", "Bengal", "bangladesh.png"),
    new Country("Russian Federation", 146544710, "Moscow", "Russian", "russia.png"),
    new Country("Japan",126960000, "Tokio", "Japan", "japan.png"),
    new Country("Mexico", 121005815, "Mexico", "Spain","mexico.png"),
    new Country("Philippines", 102921200, "Manila", "Pilipi, English", "philippines.png"),
    new Country("Vietnam", 91583000, "Hanoi", "Vietnam", "vietnam.png"),
    new Country("Egypt", 91359000, "Cairo", "Arabian", "egypt.png"),
    new Country("Ethiopia", 90076012	, "Addis-Abbeba", "Amhar", "ethiopia.png"),
    new Country("Germany", 82162000, "Berlin", "German", "germany.png"),
    new Country("Democratic Republic of the Congo", 79722624, "Kinshasa", "French","congo.png"),
    new Country("Iran", 79003827, "Tegeran", "Persian", "iran.png"),
    new Country("Turkey", 78741053, "Ankara", "Turkish", "turkey.png"),
    new Country("United Kingdom", 65341183, "London", "English", "uk.png"));

    public List<Country> getAllCountries () {
        return ALL_COUNTRIES;
    }

    public List<Country> getAllSortedByName () {
        ALL_COUNTRIES.sort(new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        });
        return ALL_COUNTRIES;
    }

    public List<Country> getAllSortedByPopulation () {
        ALL_COUNTRIES.sort(new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.getPopulation()>o2.getPopulation()) return -1;
                if (o1.getPopulation()<o2.getPopulation()) return 1;
                return 0;
            }
        });
        return ALL_COUNTRIES;
    }

    public Country getByName (String name) {
        return ALL_COUNTRIES.stream().filter(country -> country.getName().equals(name)).findFirst().get();
//        for (int i=0;i<ALL_COUNTRIES.size();i++) {
//            if (ALL_COUNTRIES.get(i).getName().equals(name)) return ALL_COUNTRIES.get(i);
//        }
//        return null;
    }

    public Country[] getByLanguage (String lang) {
        return (Country[]) ALL_COUNTRIES.stream().filter(country -> country.getLanguage().contains(lang)).toArray();
//        ArrayList<Country> result = new ArrayList<>();
//        for (int i=0;i<ALL_COUNTRIES.size();i++) {
//            if (ALL_COUNTRIES.get(i).getLanguage().contains(lang)) result.add(ALL_COUNTRIES.get(i));
//        }
//        return result;
    }

    public String[] getOfficialLanguages(String name) {
        String languages = getByName(name).getLanguage();
        return languages.split(",");
    }

    public Country getByPage(String page) {
        return ALL_COUNTRIES.stream().filter(country -> country.getPage().equals(page)).findFirst().get();
//
//        for (int i=0;i<ALL_COUNTRIES.size();i++) {
//            if (ALL_COUNTRIES.get(i).getPage().equals(page)) return ALL_COUNTRIES.get(i);
//        }
//        return null;
    }
}

