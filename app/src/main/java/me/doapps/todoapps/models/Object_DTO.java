package me.doapps.todoapps.models;

/**
 * Created by jonathan on 21/03/2015.
 */
public class Object_DTO {
    private int objectId;
    private String objectName;
    private int objectRate;
    private String objectCreatedAt;
    private String objectUpdatedAr;
    private int objectState;

    public Object_DTO(){}

    public Object_DTO(int objectId, String objectName, int objectRate, String objectCreatedAt, String objectUpdatedAr, int objectState) {
        this.objectId = objectId;
        this.objectName = objectName;
        this.objectRate = objectRate;
        this.objectCreatedAt = objectCreatedAt;
        this.objectUpdatedAr = objectUpdatedAr;
        this.objectState = objectState;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public int getObjectRate() {
        return objectRate;
    }

    public void setObjectRate(int objectRate) {
        this.objectRate = objectRate;
    }

    public String getObjectCreatedAt() {
        return objectCreatedAt;
    }

    public void setObjectCreatedAt(String objectCreatedAt) {
        this.objectCreatedAt = objectCreatedAt;
    }

    public String getObjectUpdatedAr() {
        return objectUpdatedAr;
    }

    public void setObjectUpdatedAr(String objectUpdatedAr) {
        this.objectUpdatedAr = objectUpdatedAr;
    }

    public int getObjectState() {
        return objectState;
    }

    public void setObjectState(int objectState) {
        this.objectState = objectState;
    }
}
