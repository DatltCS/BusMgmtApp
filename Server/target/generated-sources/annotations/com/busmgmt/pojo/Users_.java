package com.busmgmt.pojo;

import com.busmgmt.pojo.Admin;
import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.pojo.Customers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-22T02:57:07")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> accountStatus;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> role;
    public static volatile SetAttribute<Users, Customers> customersSet;
    public static volatile SetAttribute<Users, Buscompanies> buscompaniesSet;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile SetAttribute<Users, Admin> adminSet;

}