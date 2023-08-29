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
@Table(name = "routestatistics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Routestatistics.findAll", query = "SELECT r FROM Routestatistics r"),
    @NamedQuery(name = "Routestatistics.findByRouteStatisticsId", query = "SELECT r FROM Routestatistics r WHERE r.routeStatisticsId = :routeStatisticsId"),
    @NamedQuery(name = "Routestatistics.findByMonth", query = "SELECT r FROM Routestatistics r WHERE r.month = :month"),
    @NamedQuery(name = "Routestatistics.findByQuarter", query = "SELECT r FROM Routestatistics r WHERE r.quarter = :quarter"),
    @NamedQuery(name = "Routestatistics.findByYear", query = "SELECT r FROM Routestatistics r WHERE r.year = :year"),
    @NamedQuery(name = "Routestatistics.findByFrequency", query = "SELECT r FROM Routestatistics r WHERE r.frequency = :frequency")})
public class Routestatistics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "routeStatisticsId")
    private Integer routeStatisticsId;
    @Column(name = "month")
    @Temporal(TemporalType.DATE)
    private Date month;
    @Column(name = "quarter")
    private Integer quarter;
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Column(name = "frequency")
    private Integer frequency;
    @JoinColumn(name = "routeId", referencedColumnName = "routeId")
    @ManyToOne(optional = false)
    private Busroutes routeId;

    public Routestatistics() {
    }

    public Routestatistics(Integer routeStatisticsId) {
        this.routeStatisticsId = routeStatisticsId;
    }

    public Integer getRouteStatisticsId() {
        return routeStatisticsId;
    }

    public void setRouteStatisticsId(Integer routeStatisticsId) {
        this.routeStatisticsId = routeStatisticsId;
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

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Busroutes getRouteId() {
        return routeId;
    }

    public void setRouteId(Busroutes routeId) {
        this.routeId = routeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeStatisticsId != null ? routeStatisticsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Routestatistics)) {
            return false;
        }
        Routestatistics other = (Routestatistics) object;
        if ((this.routeStatisticsId == null && other.routeStatisticsId != null) || (this.routeStatisticsId != null && !this.routeStatisticsId.equals(other.routeStatisticsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmgmt.pojo.Routestatistics[ routeStatisticsId=" + routeStatisticsId + " ]";
    }
    
}