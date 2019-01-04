package com.ivanou4.slotgame.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractBaseEntity implements Serializable {
    @Id
    private String id;

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractBaseEntity)) {
            return false;
        }
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
