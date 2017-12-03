package com.example.edgar.optotypesystemdevelop;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Edgar on 07/10/2017.
 */

public class PatientsToday {

    private int idPatient;
    private String name;
    private String yearsOld;
    //private int photo;
    private Bitmap photo;
    //private ImageView photo;

    public PatientsToday() {
        super();
    }

    public PatientsToday(String name, String yearsOld, Bitmap photo) {
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

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
}
