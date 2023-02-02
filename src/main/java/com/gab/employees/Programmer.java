package com.gab.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee implements IEmployee, Chef{
    private int locpd = 0;
    private int yoe = 0;
    private int iq = 0;

    DateTimeFormatter dobFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final String progregex = "\\w+=(?<locpd>\\w+)\\,\\w+=(?<yoe>\\w+)\\,\\w+=(?<iq>\\w+)";

    private final Pattern progPat = Pattern.compile(progregex);
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    public Programmer(String people) {
        super(people);
        Matcher progMatcher = progPat.matcher(peopleMat.group("details"));
        if (progMatcher.find()) {
            this.locpd = Integer.parseInt(progMatcher.group("locpd"));
            this.yoe = Integer.parseInt(progMatcher.group("yoe"));
            this.iq = Integer.parseInt(progMatcher.group("iq"));
        }

    }

    public int getLocpd() {
        return locpd;
    }

    public void setLocpd(int locpd) {
        this.locpd = locpd;
    }

    public int getYoe() {
        return yoe;
    }

    public void setYoe(int yoe) {
        this.yoe = yoe;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public int getSalary() {
        return 3000 + locpd * yoe * iq;
    }

}
