package com.example.edgar.optotypesystemdevelop;

/**
 * Created by Edgar on 18/10/2017.
 */

public class Optotype {

    private String idOptotype;
    private String optotypeCode;
    private String optotypeName;
    private String idOptotypeServer;

    public Optotype() {
    }

    public Optotype(String idOptotype, String optotypeCode, String optotypeName, String idOptotypeServer) {
        this.idOptotype = idOptotype;
        this.optotypeCode = optotypeCode;
        this.optotypeName = optotypeName;
        this.idOptotypeServer = idOptotypeServer;
    }

    public String getIdOptotype() {
        return idOptotype;
    }

    public void setIdOptotype(String idOptotype) {
        this.idOptotype = idOptotype;
    }

    public String getOptotypeCode() {
        return optotypeCode;
    }

    public void setOptotypeCode(String optotypeCode) {
        this.optotypeCode = optotypeCode;
    }

    public String getOptotypeName() {
        return optotypeName;
    }

    public void setOptotypeName(String optotypeName) {
        this.optotypeName = optotypeName;
    }

    public String getIdOptotypeServer() {
        return idOptotypeServer;
    }

    public void setIdOptotypeServer(String idOptotypeServer) {
        this.idOptotypeServer = idOptotypeServer;
    }
}
