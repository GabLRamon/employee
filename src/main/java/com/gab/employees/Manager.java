package com.gab.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee{
    private int orgsize = 0;
    private int dr = 0;

    private final String managerRegex = "\\w+=(?<orgsize>\\w+)\\,\\w+=(?<dr>\\w+)";
    private final Pattern managerPat = Pattern.compile(managerRegex);
    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    private final Pattern peoplePat = Pattern.compile(peopleRegex);
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();


    public Manager(String people) {
        super(people);
        Matcher managerMat = managerPat.matcher(peopleMat.group("details"));
        if (managerMat.find()) {
            this.orgsize = Integer.parseInt(managerMat.group("orgsize"));
            this.dr = Integer.parseInt(managerMat.group("dr"));
        }
    }

    @Override
    public int getSalary() {
        return 4000 + orgsize * dr;
    }




}
