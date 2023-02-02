package com.gab.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee{
    private int projectCount = 0;


    DateTimeFormatter dobFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    private final Pattern peoplePat = Pattern.compile(regex);
    private final String analystRegex = "\\w+=(?<projectCount>\\w+)";
    private final Pattern analystPat = Pattern.compile(analystRegex);
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();


    public Analyst(String people) {
        super(people);
        Matcher managerMat = analystPat.matcher(peopleMat.group("details"));
        if (managerMat.find()) {
            this.projectCount = Integer.parseInt(managerMat.group("projectCount"));
        }
    }
    public int getSalary() {
        return 4000 * projectCount;
    }


}

