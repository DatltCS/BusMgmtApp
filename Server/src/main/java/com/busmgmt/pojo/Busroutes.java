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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "busroutes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Busroutes.findAll", query = "SELECT b FROM Busroutes b"),
    @NamedQuery(name = "Busroutes.findByRouteId", query = "SELECT b FROM Busroutes b WHERE b.routeId = :routeId"),
    @NamedQuery(name = "Busroutes.findByRouteName", query = "SELECT b FROM Busroutes b WHERE b.routeName = :routeName"),
    @NamedQuery(name = "Busroutes.findByPlaceStart", query = "SELECT b FROM Busroutes b WHERE b.placeStart = :placeStart"),
    @NamedQuery(name = "Busroutes.findByPlaceStop", query = "SELECT b FROM Busroutes b WHERE b.placeStop = :placeStop")})
public class Busroutes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "routeId")
    private Integer routeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "routeName")
    private String routeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "placeStart")
    private String placeStart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "placeStop")
    private String placeStop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    @JsonIgnore
    private Set<Routestatistics> routestatisticsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    @JsonIgnore
    private Set<Bustrips> bustripsSet;

    public Busroutes() {
    }

    public Busroutes(Integer routeId) {
        this.routeId = routeId;
    }

    public Busroutes(Integer routeId, String routeName, String placeStart, String placeStop) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.placeStart = placeStart;
        this.placeStop = placeStop;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getPlaceStart() {
        return placeStart;
    }

    public void setPlaceStart(String placeStart) {
        this.placeStart = placeStart;
    }

    public String getPlaceStop() {
        return placeStop;
    }

    public void setPlaceStop(String placeStop) {
        this.placeStop = placeStop;
    }

    @XmlTransient
    public Set<Routestatistics> getRoutestatisticsSet() {
        return routestatisticsSet;
    }

    public void setRoutestatisticsSet(Set<Routestatistics> routestatisticsSet) {
        this.routestatisticsSet = routestatisticsSet;
    }

    @XmlTransient
    public Set<Bustrips> getBustripsSet() {
        return bustripsSet;
    }

    public void setBustripsSet(Set<Bustrips> bustripsSet) {
        this.bustripsSet = bustripsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Busroutes)) {
            return false;
        }
        Busroutes other = (Busroutes) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmgmt.pojo.Busroutes[ routeId=" + routeId + " ]";
    }
    
}
