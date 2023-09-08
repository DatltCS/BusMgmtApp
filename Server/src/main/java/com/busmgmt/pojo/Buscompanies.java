/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "buscompanies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buscompanies.findAll", query = "SELECT b FROM Buscompanies b"),
    @NamedQuery(name = "Buscompanies.findByCompanyId", query = "SELECT b FROM Buscompanies b WHERE b.companyId = :companyId"),
    @NamedQuery(name = "Buscompanies.findByNameCompany", query = "SELECT b FROM Buscompanies b WHERE b.nameCompany = :nameCompany"),
    @NamedQuery(name = "Buscompanies.findByTotalBus", query = "SELECT b FROM Buscompanies b WHERE b.totalBus = :totalBus"),
    @NamedQuery(name = "Buscompanies.findByAvatar", query = "SELECT b FROM Buscompanies b WHERE b.avatar = :avatar"),
    @NamedQuery(name = "Buscompanies.findByStatus", query = "SELECT b FROM Buscompanies b WHERE b.status = :status"),
    @NamedQuery(name = "Buscompanies.findByAddress", query = "SELECT b FROM Buscompanies b WHERE b.address = :address"),
    @NamedQuery(name = "Buscompanies.findByPhone", query = "SELECT b FROM Buscompanies b WHERE b.phone = :phone"),
    @NamedQuery(name = "Buscompanies.findByEmail", query = "SELECT b FROM Buscompanies b WHERE b.email = :email"),
    @NamedQuery(name = "Buscompanies.findByAllowedDelivery", query = "SELECT b FROM Buscompanies b WHERE b.allowedDelivery = :allowedDelivery")})
public class Buscompanies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyId")
    private Integer companyId;
    @Size(max = 45)
    @Column(name = "nameCompany")
    private String nameCompany;
    @Column(name = "totalBus")
    private Integer totalBus;
    @Size(max = 256)
    @Column(name = "avatar")
    private String avatar;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    @Size(max = 256)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 11)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "allowedDelivery")
    private Short allowedDelivery;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Set<Bus> busSet;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Users userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Set<Revenuestatistics> revenuestatisticsSet;

    public Buscompanies() {
    }

    public Buscompanies(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Integer getTotalBus() {
        return totalBus;
    }

    public void setTotalBus(Integer totalBus) {
        this.totalBus = totalBus;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getAllowedDelivery() {
        return allowedDelivery;
    }

    public void setAllowedDelivery(Short allowedDelivery) {
        this.allowedDelivery = allowedDelivery;
    }

    @XmlTransient
    public Set<Bus> getBusSet() {
        return busSet;
    }

    public void setBusSet(Set<Bus> busSet) {
        this.busSet = busSet;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Set<Revenuestatistics> getRevenuestatisticsSet() {
        return revenuestatisticsSet;
    }

    public void setRevenuestatisticsSet(Set<Revenuestatistics> revenuestatisticsSet) {
        this.revenuestatisticsSet = revenuestatisticsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buscompanies)) {
            return false;
        }
        Buscompanies other = (Buscompanies) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmgmt.pojo.Buscompanies[ companyId=" + companyId + " ]";
    }
    
}
