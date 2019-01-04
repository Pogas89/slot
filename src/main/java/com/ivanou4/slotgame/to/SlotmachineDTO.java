package com.ivanou4.slotgame.to;

import java.util.Objects;

public class SlotmachineDTO {
    private String id;
    private String model;
    private String version;
    private String factoryNumber;
    private Boolean techService;
    private int skksNumber;
    private String slotroomId;
    private String slotroomAddres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public int getSkksNumber() {
        return skksNumber;
    }

    public void setSkksNumber(int skksNumber) {
        this.skksNumber = skksNumber;
    }

    public String getSlotroomId() {
        return slotroomId;
    }

    public void setSlotroomId(String slotroomId) {
        this.slotroomId = slotroomId;
    }

    public String getSlotroomAddres() {
        return slotroomAddres;
    }

    public void setSlotroomAddres(String slotroomAddres) {
        this.slotroomAddres = slotroomAddres;
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
        SlotmachineDTO that = (SlotmachineDTO) o;
        return skksNumber == that.skksNumber &&
                Objects.equals(id, that.id) &&
                Objects.equals(model, that.model) &&
                Objects.equals(version, that.version) &&
                Objects.equals(factoryNumber, that.factoryNumber) &&
                Objects.equals(techService, that.techService) &&
                Objects.equals(slotroomId, that.slotroomId) &&
                Objects.equals(slotroomAddres, that.slotroomAddres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, version, factoryNumber, techService, skksNumber, slotroomId, slotroomAddres);
    }

    @Override
    public String toString() {
        return "SlotmachineDTO{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", version='" + version + '\'' +
                ", factoryNumber='" + factoryNumber + '\'' +
                ", techService=" + techService +
                ", skksNumber=" + skksNumber +
                ", slotroomId='" + slotroomId + '\'' +
                ", slotroomAddres='" + slotroomAddres + '\'' +
                '}';
    }
}
