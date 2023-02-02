package com.gab.employees;

import jdk.jfr.Percentage;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
        public static void main(String[] args) {
            String people = """
                    Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                    Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
                    Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
                    Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
                    Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
                    Rubble, Barney, 2/2/1905, Manager, {orgsize=300,dr=10}
                    Rubble2, Barney2, 2/2/1905, Manager, {orgsize=100,dr=4}
                    Rubble3, Barney3, 2/2/1905, Manager, {orgsize=200,dr=2}
                    Rubble4, Barney4, 2/2/1905, Manager, {orgsize=500,dr=8}
                    Rubble5, Barney5, 2/2/1905, Manager, {orgsize=175,dr=20}
                    Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
                    Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
                    Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
                    Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
                    Rubble, Betty1, 4/4/1915, CEO, {avgStockPrize=300}
                    """;

            Flyer flyer = new CEO("");
            Programmer coder = new Programmer("");
            coder.cook("hamburg");

            Matcher peopleMat = Employee.peoplePat.matcher(people);
            int totalSalaries = 0;
            Employee employee = null;
            while (peopleMat.find()) {
                if (employee instanceof Programmer prog) {
                    System.out.println(prog.getIq());
                } else if (employee instanceof Manager man) {
                    System.out.println(man.toString());
                } else if (employee instanceof Analyst ana){
                    System.out.println(ana.toString());
                } else if (employee instanceof CEO ceo) {
                    System.out.println(ceo.toString());
                } else {
                    System.out.println(employee.defaultOutput());
                }
                employee = Employee.createEmployee(peopleMat.group());
                System.out.println(employee.toString());
                totalSalaries += employee.getSalary();
            }
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.printf("the total payout should be %s%n", currencyInstance.format(totalSalaries));
        }

    }

