package com.busmgmt.pojo;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Orders;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-08T14:25:08")
@StaticMetamodel(Tickets.class)
public class Tickets_ { 

    public static volatile SingularAttribute<Tickets, String> numSeat;
    public static volatile SingularAttribute<Tickets, Orders> orderId;
    public static volatile SingularAttribute<Tickets, Long> price;
    public static volatile SingularAttribute<Tickets, String> paymentMethod;
    public static volatile SingularAttribute<Tickets, Bustrips> tripId;
    public static volatile SingularAttribute<Tickets, Integer> ticketId;
    public static volatile SingularAttribute<Tickets, String> status;
    public static volatile SingularAttribute<Tickets, Date> createDate;

}