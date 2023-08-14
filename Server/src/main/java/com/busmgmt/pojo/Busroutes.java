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
    @NamedQuery(name = "Busroutes.findByPalaceStart", query = "SELECT b FROM Busroutes b WHERE b.palaceStart = :palaceStart"),
    @NamedQuery(name = "Busroutes.findByPalaceStop", query = "SELECT b FROM Busroutes b WHERE b.palaceStop = :palaceStop")})
public class Busroutes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "palaceStart")
    private String palaceStart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "palaceStop")
    private String palaceStop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Set<Routestatistics> routestatisticsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Set<Bustrips> bustripsSet;

    public Busroutes() {
    }

    public Busroutes(Integer routeId) {
        this.routeId = routeId;
    }

    public Busroutes(Integer routeId, String routeName, String palaceStart, String palaceStop) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.palaceStart = palaceStart;
        this.palaceStop = palaceStop;
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

    public String getPalaceStart() {
        return palaceStart;
    }

    public void setPalaceStart(String palaceStart) {
        this.palaceStart = palaceStart;
    }

    public String getPalaceStop() {
        return palaceStop;
    }

    public void setPalaceStop(String palaceStop) {
        this.palaceStop = palaceStop;
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
