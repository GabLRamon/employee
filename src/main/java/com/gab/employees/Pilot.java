package com.gab.employees;

public class Pilot implements Flyer {

    public int hoursFlown = 0;
    public boolean ifr = false;

    public Pilot(int hoursFlown, boolean ifr) {
        this.hoursFlown = hoursFlown;
        this.ifr = ifr;
    }

    @Override
    public void fly() {
        System.out.println("Prepare to take off!");
    }

    @Override
    public int getHoursFlown() {
        return hoursFlown;
    }

    @Override
    public void setHoursFlown(int hoursFlown) {
        this.hoursFlown = hoursFlown;
    }

    @Override
    public boolean isIfr() {
        return ifr;
    }

    @Override
    public void setIfr(boolean ifr) {
        this.ifr = ifr;
    }
}
