package com.busmgmt.pojo;

import com.busmgmt.pojo.Deliveries;
import com.busmgmt.pojo.Reviews;
import com.busmgmt.pojo.Tickets;
import com.busmgmt.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-25T21:34:31")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-22T13:40:26")
>>>>>>> be3458d405526b82a5d82d467d61aa24bfa672a3
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> firstName;
    public static volatile SingularAttribute<Customers, String> lastName;
    public static volatile SetAttribute<Customers, Tickets> ticketsSet;
    public static volatile SingularAttribute<Customers, String> address;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, Integer> customerId;
    public static volatile SetAttribute<Customers, Deliveries> deliveriesSet;
    public static volatile SingularAttribute<Customers, String> avatar;
    public static volatile SingularAttribute<Customers, Users> userId;
    public static volatile SingularAttribute<Customers, String> email;
    public static volatile SetAttribute<Customers, Reviews> reviewsSet;

}