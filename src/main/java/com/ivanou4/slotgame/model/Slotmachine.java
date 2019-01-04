package com.ivanou4.slotgame.model;

import java.util.Objects;

public class Slotmachine extends AbstractBaseEntity {
    private String model;

    private String version;

    private String factoryNumber;

    private Boolean techService;

    private int skksNumber;

    private String slotroomId;

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public Boolean getTechService() {
        return techService;
    }

    public void setTechService(Boolean techService) {
        this.techService = techService;
    }

    public String getSlotroomId() {
        return slotroomId;
    }

    public void setSlotroomId(String slotroomId) {
        this.slotroomId = slotroomId;
    }

    public int getSkksNumber() {
        return skksNumber;
    }

    public void setSkksNumber(int skksNumber) {
        this.skksNumber = skksNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Slotmachine that = (Slotmachine) o;
        return skksNumber == that.skksNumber &&
                Objects.equals(model, that.model) &&
                Objects.equals(version, that.version) &&
                Objects.equals(factoryNumber, that.factoryNumber) &&
                Objects.equals(techService, that.techService) &&
                Objects.equals(slotroomId, that.slotroomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, version, factoryNumber, techService, skksNumber, slotroomId);
    }

    @Override
    public String toString() {
        return "Slotmachine{" +
                "model='" + model + '\'' +
                ", version='" + version + '\'' +
                ", factoryNumber='" + factoryNumber + '\'' +
                ", techService=" + techService +
                ", skksNumber=" + skksNumber +
                ", slotroomId='" + slotroomId + '\'' +
                '}';
    }
}
