package com.shop.peristence.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "sales")
public class SalesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_sales")
    private int idSales;
    @Basic
    @Column(name = "id_garment")
    private Integer idGarment;
    @Basic
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Basic
    @Column(name = "id_staff")
    private Integer idStaff;
    @Basic
    @Column(name = "id_branch")
    private Integer idBranch;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "creation_date")
    private Timestamp creationDate;
    @Basic
    @Column(name = "modification_date")
    private Timestamp modificationDate;

    public int getIdSales() {
        return idSales;
    }

    public void setIdSales(int idSales) {
        this.idSales = idSales;
    }

    public Integer getIdGarment() {
        return idGarment;
    }

    public void setIdGarment(Integer idGarment) {
        this.idGarment = idGarment;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesEntity that = (SalesEntity) o;
        return idSales == that.idSales && Objects.equals(idGarment, that.idGarment) && Objects.equals(idCustomer, that.idCustomer) && Objects.equals(idStaff, that.idStaff) && Objects.equals(idBranch, that.idBranch) && Objects.equals(state, that.state) && Objects.equals(creationDate, that.creationDate) && Objects.equals(modificationDate, that.modificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSales, idGarment, idCustomer, idStaff, idBranch, state, creationDate, modificationDate);
    }
}
