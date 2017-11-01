package com.example.edgar.optotypesystemdevelop;

/**
 * Created by Edgar on 01/11/2017.
 */

public class ListActionOnPatient {

    private int photo;
    private String name;
    private int icon;

    public ListActionOnPatient() {
    }

    public ListActionOnPatient(int photo, String name, int icon) {
        this.photo = photo;
        this.name = name;
        this.icon = icon;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
