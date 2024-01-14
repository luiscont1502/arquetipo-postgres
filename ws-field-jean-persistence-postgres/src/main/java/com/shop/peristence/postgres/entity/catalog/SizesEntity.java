package com.shop.peristence.postgres.entity.catalog;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "sizes", schema = "public", catalog = "store_jean")
public class SizesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_sizes")
    private int idSizes;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "name")
    private String name;

    public int getIdSizes() {
        return idSizes;
    }

    public void setIdSizes(int idSizes) {
        this.idSizes = idSizes;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizesEntity that = (SizesEntity) o;
        return idSizes == that.idSizes && Objects.equals(state, that.state) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSizes, state, name);
    }
}
