package com.example.edgar.optotypesystemdevelop;

/**
 * Created by Edgar on 25/10/2017.
 */

public class OptotypeTool {

    private String testCode;
    private String description;
    private String biometric;

    public OptotypeTool() {
    }

    public OptotypeTool(String testCode, String description, String biometric) {
        this.testCode = testCode;
        this.description = description;
        this.biometric = biometric;
    }

    public String getTestCode() {
        return testCode;
    }

    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBiometric() {
        return biometric;
    }

    public void setBiometric(String biometric) {
        this.biometric = biometric;
    }

}
