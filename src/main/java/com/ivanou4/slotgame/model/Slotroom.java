package com.ivanou4.slotgame.model;

import java.util.Objects;

public class Slotroom extends AbstractBaseEntity {
    private String name;

    private String addres;

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
        if (!super.equals(o)) return false;
        Slotroom slotroom = (Slotroom) o;
        return Objects.equals(name, slotroom.name) &&
                Objects.equals(addres, slotroom.addres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, addres);
    }

    @Override
    public String toString() {
        return "Slotroom{" +
                "name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                '}';
    }
}
