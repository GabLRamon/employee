package com.gab.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements IEmployee, Flyer {
    private int avgStockPrize = 0;

    Pilot pilot = new Pilot(1000, true);


    DateTimeFormatter dobFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    private final Pattern peoplePat = Pattern.compile(regex);
    private final String ceoRegex = "\\w+=(?<avgStockPrize>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();


    public CEO(String people) {
        super(people);
        Matcher managerMat = ceoPat.matcher(peopleMat.group("details"));
        if (managerMat.find()) {
            this.avgStockPrize = Integer.parseInt(managerMat.group("avgStockPrize"));
        }
    }
    public int getSalary() {
        return 4000 * avgStockPrize;
    }

    public void fly() {
        pilot.fly();
    }

    public int getHoursFlown() {
        return pilot.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        pilot.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return pilot.isIfr();
    }

    public void setIfr(boolean ifr) {
        pilot.setIfr(ifr);
    }
}
