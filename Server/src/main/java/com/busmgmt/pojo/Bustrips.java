/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "bustrips")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bustrips.findAll", query = "SELECT b FROM Bustrips b"),
    @NamedQuery(name = "Bustrips.findByTripId", query = "SELECT b FROM Bustrips b WHERE b.tripId = :tripId"),
    @NamedQuery(name = "Bustrips.findByTripName", query = "SELECT b FROM Bustrips b WHERE b.tripName = :tripName"),
    @NamedQuery(name = "Bustrips.findByPrice", query = "SELECT b FROM Bustrips b WHERE b.price = :price"),
    @NamedQuery(name = "Bustrips.findByTimeStart", query = "SELECT b FROM Bustrips b WHERE b.timeStart = :timeStart"),
    @NamedQuery(name = "Bustrips.findByTimeStop", query = "SELECT b FROM Bustrips b WHERE b.timeStop = :timeStop")})
public class Bustrips implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tripId")
    private Integer tripId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tripName")
    private String tripName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeStart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeStop")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId")
    @JsonIgnore
    private Set<Tickets> ticketsSet;
    @JoinColumn(name = "licensePlateId", referencedColumnName = "licensePlateId")
    @ManyToOne(optional = false)
    private Bus licensePlateId;
    @JoinColumn(name = "routeId", referencedColumnName = "routeId")
    @ManyToOne(optional = false)
    private Busroutes routeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId")
    @JsonIgnore
    private Set<Deliveries> deliveriesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId")
    @JsonIgnore
    private Set<Reviews> reviewsSet;

    public Bustrips() {
    }

    public Bustrips(Integer tripId) {
        this.tripId = tripId;
    }

    public Bustrips(Integer tripId, String tripName, long price, Date timeStart, Date timeStop) {
        this.tripId = tripId;
        this.tripName = tripName;
        this.price = price;
        this.timeStart = timeStart;
        this.timeStop = timeStop;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(Date timeStop) {
        this.timeStop = timeStop;
    }

    @XmlTransient
    public Set<Tickets> getTicketsSet() {
        return ticketsSet;
    }

    public void setTicketsSet(Set<Tickets> ticketsSet) {
        this.ticketsSet = ticketsSet;
    }

    public Bus getLicensePlateId() {
        return licensePlateId;
    }

    public void setLicensePlateId(Bus licensePlateId) {
        this.licensePlateId = licensePlateId;
    }

    public Busroutes getRouteId() {
        return routeId;
    }

    public void setRouteId(Busroutes routeId) {
        this.routeId = routeId;
    }

    @XmlTransient
    public Set<Deliveries> getDeliveriesSet() {
        return deliveriesSet;
    }

    public void setDeliveriesSet(Set<Deliveries> deliveriesSet) {
        this.deliveriesSet = deliveriesSet;
    }

    @XmlTransient
    public Set<Reviews> getReviewsSet() {
        return reviewsSet;
    }

    public void setReviewsSet(Set<Reviews> reviewsSet) {
        this.reviewsSet = reviewsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tripId != null ? tripId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bustrips)) {
            return false;
        }
        Bustrips other = (Bustrips) object;
        if ((this.tripId == null && other.tripId != null) || (this.tripId != null && !this.tripId.equals(other.tripId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmgmt.pojo.Bustrips[ tripId=" + tripId + " ]";
    }
    
}
