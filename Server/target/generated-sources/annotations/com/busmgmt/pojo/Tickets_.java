package com.busmgmt.pojo;

import com.busmgmt.pojo.Customers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-30T13:32:14")
@StaticMetamodel(Tickets.class)
public class Tickets_ { 

    public static volatile SingularAttribute<Tickets, String> numSeat;
    public static volatile SingularAttribute<Tickets, Long> price;
    public static volatile SingularAttribute<Tickets, Customers> customerId;
    public static volatile SingularAttribute<Tickets, String> paymentMethod;
    public static volatile SingularAttribute<Tickets, Integer> ticketId;
    public static volatile SingularAttribute<Tickets, String> status;
    public static volatile SingularAttribute<Tickets, Date> createDate;

}