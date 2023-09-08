package com.busmgmt.pojo;

import com.busmgmt.pojo.Orders;
import com.busmgmt.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-09T02:19:45")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> firstName;
    public static volatile SingularAttribute<Customers, String> lastName;
    public static volatile SingularAttribute<Customers, String> address;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, Integer> customerId;
    public static volatile SingularAttribute<Customers, String> avatar;
    public static volatile SetAttribute<Customers, Orders> ordersSet;
    public static volatile SingularAttribute<Customers, Users> userId;
    public static volatile SingularAttribute<Customers, String> email;

}