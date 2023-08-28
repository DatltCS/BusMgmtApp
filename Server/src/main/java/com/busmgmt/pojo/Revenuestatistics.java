/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "revenuestatistics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revenuestatistics.findAll", query = "SELECT r FROM Revenuestatistics r"),
    @NamedQuery(name = "Revenuestatistics.findByRevenueStatisticId", query = "SELECT r FROM Revenuestatistics r WHERE r.revenueStatisticId = :revenueStatisticId"),
    @NamedQuery(name = "Revenuestatistics.findByMonth", query = "SELECT r FROM Revenuestatistics r WHERE r.month = :month"),
    @NamedQuery(name = "Revenuestatistics.findByQuarter", query = "SELECT r FROM Revenuestatistics r WHERE r.quarter = :quarter"),
    @NamedQuery(name = "Revenuestatistics.findByYear", query = "SELECT r FROM Revenuestatistics r WHERE r.year = :year"),
    @NamedQuery(name = "Revenuestatistics.findByRevenue", query = "SELECT r FROM Revenuestatistics r WHERE r.revenue = :revenue")})
public class Revenuestatistics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "revenueStatisticId")
    private Integer revenueStatisticId;
    @Column(name = "month")
    @Temporal(TemporalType.DATE)
    private Date month;
    @Column(name = "quarter")
    private Integer quarter;
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Column(name = "revenue")
    private Long revenue;
    @JoinColumn(name = "companyId", referencedColumnName = "companyId")
    @ManyToOne(optional = false)
    private Buscompanies companyId;

    public Revenuestatistics() {
    }

    public Revenuestatistics(Integer revenueStatisticId) {
        this.revenueStatisticId = revenueStatisticId;
    }

    public Integer getRevenueStatisticId() {
        return revenueStatisticId;
    }

    public void setRevenueStatisticId(Integer revenueStatisticId) {
        this.revenueStatisticId = revenueStatisticId;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Buscompanies getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Buscompanies companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (revenueStatisticId != null ? revenueStatisticId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revenuestatistics)) {
            return false;
        }
        Revenuestatistics other = (Revenuestatistics) object;
        if ((this.revenueStatisticId == null && other.revenueStatisticId != null) || (this.revenueStatisticId != null && !this.revenueStatisticId.equals(other.revenueStatisticId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmgmt.pojo.Revenuestatistics[ revenueStatisticId=" + revenueStatisticId + " ]";
    }
    
}
