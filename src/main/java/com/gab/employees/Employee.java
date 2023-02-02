package com.gab.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee {


    public static final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    public static final Pattern peoplePat = Pattern.compile(peopleRegex);
    protected final Matcher peopleMat;
    protected String lastName;
    protected String firstName;
    protected LocalDate dob;
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
    DateTimeFormatter dobFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    protected Employee() {
        peopleMat = null;
        lastName = "N/A";
        firstName = "N/A";
        dob = null;
    }

    public abstract int getSalary();

    public double getBonus() {
        return getSalary() * 0.10;
    }
    public Employee(String people) {
        peopleMat = Employee.peoplePat.matcher(people);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dobFormatter.parse(peopleMat.group("dob")));
        }
    }
    public static final Employee createEmployee(String employeeText) {
        Matcher peopleMat = Employee.peoplePat.matcher(employeeText);
        if (peopleMat.find()) {
            return switch (peopleMat.group("role")) {
                case "Programmer" -> new Programmer(employeeText);
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                default -> new DummyEmployee();
            };
        } else {
            return new DummyEmployee();
        }
    }

    public String defaultOutput() {
        return "Default";
    };


    @Override
    public String toString( ) {
        return String.format("%s, %s:, %s - %s", lastName, firstName, moneyFormat.format(getSalary()), moneyFormat.format(getBonus()));
    }
    private static final class DummyEmployee extends Employee implements IEmployee{

        @Override
         public int getSalary() {
             return 0;
         }
    }

}


