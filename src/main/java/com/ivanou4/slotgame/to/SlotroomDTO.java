package com.ivanou4.slotgame.to;

import java.util.Objects;

public class SlotroomDTO {
    private String id;
    private String name;
    private String addres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotroomDTO that = (SlotroomDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(addres, that.addres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addres);
    }

    @Override
    public String toString() {
        return "SlotroomDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                '}';
    }
}
