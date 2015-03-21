package me.doapps.todoapps.models;

/**
 * Created by jonathan on 21/03/2015.
 */
public class Verb_DTO {
    private int verbId;
    private String verbName;
    private int verbRate;
    private String verbCreatedAt;
    private String verbUpdatedAr;
    private int verbState;

    public Verb_DTO(){}

    public Verb_DTO(int verbId, String verbName, int verbRate, String verbCreatedAt, int verbState, String verbUpdatedAr) {
        this.verbId = verbId;
        this.verbName = verbName;
        this.verbRate = verbRate;
        this.verbCreatedAt = verbCreatedAt;
        this.verbState = verbState;
        this.verbUpdatedAr = verbUpdatedAr;
    }

    public int getVerbId() {
        return verbId;
    }

    public void setVerbId(int verbId) {
        this.verbId = verbId;
    }

    public String getVerbName() {
        return verbName;
    }

    public void setVerbName(String verbName) {
        this.verbName = verbName;
    }

    public int getVerbRate() {
        return verbRate;
    }

    public void setVerbRate(int verbRate) {
        this.verbRate = verbRate;
    }

    public String getVerbCreatedAt() {
        return verbCreatedAt;
    }

    public void setVerbCreatedAt(String verbCreatedAt) {
        this.verbCreatedAt = verbCreatedAt;
    }

    public String getVerbUpdatedAr() {
        return verbUpdatedAr;
    }

    public void setVerbUpdatedAr(String verbUpdatedAr) {
        this.verbUpdatedAr = verbUpdatedAr;
    }

    public int getVerbState() {
        return verbState;
    }

    public void setVerbState(int verbState) {
        this.verbState = verbState;
    }
}
