package com.busmgmt.pojo;

import com.busmgmt.pojo.Customers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-22T02:57:07")
@StaticMetamodel(Deliveries.class)
public class Deliveries_ { 

    public static volatile SingularAttribute<Deliveries, String> receiverName;
    public static volatile SingularAttribute<Deliveries, String> description;
    public static volatile SingularAttribute<Deliveries, Date> sendTime;
    public static volatile SingularAttribute<Deliveries, String> senderPhone;
    public static volatile SingularAttribute<Deliveries, Date> receiveTime;
    public static volatile SingularAttribute<Deliveries, Integer> deliveryId;
    public static volatile SingularAttribute<Deliveries, String> senderName;
    public static volatile SingularAttribute<Deliveries, String> receiverPhone;
    public static volatile SingularAttribute<Deliveries, Long> price;
    public static volatile SingularAttribute<Deliveries, String> senderEmail;
    public static volatile SingularAttribute<Deliveries, Customers> customerId;
    public static volatile SingularAttribute<Deliveries, String> paymentMethod;
    public static volatile SingularAttribute<Deliveries, String> receiverEmail;
    public static volatile SingularAttribute<Deliveries, Date> createDate;
    public static volatile SingularAttribute<Deliveries, String> status;

}