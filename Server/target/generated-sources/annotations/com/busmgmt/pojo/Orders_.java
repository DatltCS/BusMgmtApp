package com.busmgmt.pojo;

import com.busmgmt.pojo.Customers;
import com.busmgmt.pojo.Deliveries;
import com.busmgmt.pojo.Tickets;
import com.busmgmt.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-10T03:12:12")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Long> amount;
    public static volatile SetAttribute<Orders, Tickets> ticketsSet;
    public static volatile SingularAttribute<Orders, Integer> orderId;
    public static volatile SingularAttribute<Orders, Customers> customerId;
    public static volatile SetAttribute<Orders, Deliveries> deliveriesSet;
    public static volatile SingularAttribute<Orders, Users> userId;
    public static volatile SingularAttribute<Orders, Date> createDate;

}