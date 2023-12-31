/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b"),
    @NamedQuery(name = "Bus.findByLicensePlateId", query = "SELECT b FROM Bus b WHERE b.licensePlateId = :licensePlateId"),
    @NamedQuery(name = "Bus.findByBusName", query = "SELECT b FROM Bus b WHERE b.busName = :busName"),
    @NamedQuery(name = "Bus.findByTotalSeat", query = "SELECT b FROM Bus b WHERE b.totalSeat = :totalSeat"),
    @NamedQuery(name = "Bus.findByBusType", query = "SELECT b FROM Bus b WHERE b.busType = :busType"),
    @NamedQuery(name = "Bus.findByImage", query = "SELECT b FROM Bus b WHERE b.image = :image")})
public class Bus implements Serializable {

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "licensePlateId")
    private Integer licensePlateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "busName")
    private String busName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalSeat")
    private int totalSeat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "busType")
    private String busType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "companyId", referencedColumnName = "companyId")
    @ManyToOne(optional = false)
    private Buscompanies companyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licensePlateId")
    @JsonIgnore
    private Set<Bustrips> bustripsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licensePlateId")
    @JsonIgnore
    private Set<Busseat> busseatSet;

    @Transient
    @JsonIgnore
    private MultipartFile file;

    public Bus() {
    }

    public Bus(Integer licensePlateId) {
        this.licensePlateId = licensePlateId;
    }

    public Bus(Integer licensePlateId, String busName, int totalSeat, String busType, String image) {
        this.licensePlateId = licensePlateId;
        this.busName = busName;
        this.totalSeat = totalSeat;
        this.busType = busType;
        this.image = image;
    }

    public Integer getLicensePlateId() {
        return licensePlateId;
    }

    public void setLicensePlateId(Integer licensePlateId) {
        this.licensePlateId = licensePlateId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Buscompanies getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Buscompanies companyId) {
        this.companyId = companyId;
    }

    @XmlTransient
    public Set<Bustrips> getBustripsSet() {
        return bustripsSet;
    }

    public void setBustripsSet(Set<Bustrips> bustripsSet) {
        this.bustripsSet = bustripsSet;
    }

    @XmlTransient
    public Set<Busseat> getBusseatSet() {
        return busseatSet;
    }

    public void setBusseatSet(Set<Busseat> busseatSet) {
        this.busseatSet = busseatSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licensePlateId != null ? licensePlateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.licensePlateId == null && other.licensePlateId != null) || (this.licensePlateId != null && !this.licensePlateId.equals(other.licensePlateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmgmt.pojo.Bus[ licensePlateId=" + licensePlateId + " ]";
    }
    
}
