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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "deliveries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliveries.findAll", query = "SELECT d FROM Deliveries d"),
    @NamedQuery(name = "Deliveries.findByDeliveryId", query = "SELECT d FROM Deliveries d WHERE d.deliveryId = :deliveryId"),
    @NamedQuery(name = "Deliveries.findByDescription", query = "SELECT d FROM Deliveries d WHERE d.description = :description"),
    @NamedQuery(name = "Deliveries.findBySenderName", query = "SELECT d FROM Deliveries d WHERE d.senderName = :senderName"),
    @NamedQuery(name = "Deliveries.findBySenderPhone", query = "SELECT d FROM Deliveries d WHERE d.senderPhone = :senderPhone"),
    @NamedQuery(name = "Deliveries.findBySenderEmail", query = "SELECT d FROM Deliveries d WHERE d.senderEmail = :senderEmail"),
    @NamedQuery(name = "Deliveries.findByReceiverName", query = "SELECT d FROM Deliveries d WHERE d.receiverName = :receiverName"),
    @NamedQuery(name = "Deliveries.findByReceiverPhone", query = "SELECT d FROM Deliveries d WHERE d.receiverPhone = :receiverPhone"),
    @NamedQuery(name = "Deliveries.findByReceiverEmail", query = "SELECT d FROM Deliveries d WHERE d.receiverEmail = :receiverEmail"),
    @NamedQuery(name = "Deliveries.findBySendTime", query = "SELECT d FROM Deliveries d WHERE d.sendTime = :sendTime"),
    @NamedQuery(name = "Deliveries.findByReceiveTime", query = "SELECT d FROM Deliveries d WHERE d.receiveTime = :receiveTime"),
    @NamedQuery(name = "Deliveries.findByCreateDate", query = "SELECT d FROM Deliveries d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "Deliveries.findByPaymentMethod", query = "SELECT d FROM Deliveries d WHERE d.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Deliveries.findByStatus", query = "SELECT d FROM Deliveries d WHERE d.status = :status"),
    @NamedQuery(name = "Deliveries.findByPrice", query = "SELECT d FROM Deliveries d WHERE d.price = :price")})
public class Deliveries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "deliveryId")
    private Integer deliveryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "senderName")
    private String senderName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "senderPhone")
    private String senderPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "senderEmail")
    private String senderEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "receiverName")
    private String receiverName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "receiverPhone")
    private String receiverPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "receiverEmail")
    private String receiverEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sendTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;
    @Column(name = "receiveTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "paymentMethod")
    private String paymentMethod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @ManyToOne(optional = false)
    private Customers customerId;

    public Deliveries() {
    }

    public Deliveries(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Deliveries(Integer deliveryId, String description, String senderName, String senderPhone, String senderEmail, String receiverName, String receiverPhone, String receiverEmail, Date sendTime, Date createDate, String paymentMethod, String status, long price) {
        this.deliveryId = deliveryId;
        this.description = description;
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.senderEmail = senderEmail;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverEmail = receiverEmail;
        this.sendTime = sendTime;
        this.createDate = createDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.price = price;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryId != null ? deliveryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deliveries)) {
            return false;
        }
        Deliveries other = (Deliveries) object;
        if ((this.deliveryId == null && other.deliveryId != null) || (this.deliveryId != null && !this.deliveryId.equals(other.deliveryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmgmt.pojo.Deliveries[ deliveryId=" + deliveryId + " ]";
    }
    
}