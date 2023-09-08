/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "busseat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Busseat.findAll", query = "SELECT b FROM Busseat b"),
    @NamedQuery(name = "Busseat.findBySeatId", query = "SELECT b FROM Busseat b WHERE b.seatId = :seatId"),
    @NamedQuery(name = "Busseat.findByNumSeat", query = "SELECT b FROM Busseat b WHERE b.numSeat = :numSeat")})
public class Busseat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seatId")
    private Integer seatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "numSeat")
    private String numSeat;
    @JoinColumn(name = "licensePlateId", referencedColumnName = "licensePlateId")
    @ManyToOne(optional = false)
    private Bus licensePlateId;

    public Busseat() {
    }

    public Busseat(Integer seatId) {
        this.seatId = seatId;
    }

    public Busseat(Integer seatId, String numSeat) {
        this.seatId = seatId;
        this.numSeat = numSeat;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(String numSeat) {
        this.numSeat = numSeat;
    }

    public Bus getLicensePlateId() {
        return licensePlateId;
    }

    public void setLicensePlateId(Bus licensePlateId) {
        this.licensePlateId = licensePlateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seatId != null ? seatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Busseat)) {
            return false;
        }
        Busseat other = (Busseat) object;
        if ((this.seatId == null && other.seatId != null) || (this.seatId != null && !this.seatId.equals(other.seatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmgmt.pojo.Busseat[ seatId=" + seatId + " ]";
    }
    
}
