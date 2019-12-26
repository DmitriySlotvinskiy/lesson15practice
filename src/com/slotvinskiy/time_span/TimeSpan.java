package com.slotvinskiy.time_span;

public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (minutes > 60) {
            throw new IllegalArgumentException("minutes must be less 60");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void add(TimeSpan x) {
        int timeInMinutes = this.minutes + this.hours * 60 + (x.getMinutes() + x.getHours() * 60);
        setHoursAndMinutes(timeInMinutes);
    }


    public void sub(TimeSpan x) {
        int timeInMinutes = this.minutes + this.hours * 60 - (x.getMinutes() + x.getHours() * 60);
        if (timeInMinutes < 0) {
            throw new IllegalArgumentException("Error. Negative time value!");
        } else {
            setHoursAndMinutes(timeInMinutes);
        }
    }

    public void mult(double x) {
        int timeInMinutes = (int) ((this.minutes + this.hours * 60) * x);
        setHoursAndMinutes(timeInMinutes);
    }

    private void setHoursAndMinutes(int timeInMinutes) {
        this.setMinutes(timeInMinutes % 60);
        this.setHours(timeInMinutes / 60);
    }

    @Override
    public String toString() {
        return "TimeSpan{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}