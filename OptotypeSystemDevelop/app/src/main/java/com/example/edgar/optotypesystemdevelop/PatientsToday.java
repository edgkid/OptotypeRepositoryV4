package com.example.edgar.optotypesystemdevelop;

/**
 * Created by Edgar on 07/10/2017.
 */

public class PatientsToday {

    private int idPatient;
    private String name;
    private String yearsOld;
    private int photo;

    public PatientsToday() {
        super();
    }

    public PatientsToday(String name, String yearsOld, int photo) {
        super();
        this.name = name;
        this.yearsOld = yearsOld;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(String yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
}
