package com.example.lijinyuan.yunchengcalendar;

/**
 * Created by lijinyuan on 16/5/10.
 */
public class Calendar {
    private String number;
    private String title;
    private String state;
    private String percent;

    public Calendar(String number, String title, String state, String percent) {
        this.number = number;
        this.title = title;
        this.state = state;
        this.percent = percent;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
