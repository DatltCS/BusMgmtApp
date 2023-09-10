package com.busmgmt.pojo;

import com.busmgmt.pojo.Admin;
import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.pojo.Customers;
import com.busmgmt.pojo.Reviews;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-10T17:33:13")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> accountStatus;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SetAttribute<Users, Customers> customersSet;
    public static volatile SingularAttribute<Users, String> avatar;
    public static volatile SingularAttribute<Users, Boolean> isCompany;
    public static volatile SingularAttribute<Users, String> userRole;
    public static volatile SetAttribute<Users, Buscompanies> buscompaniesSet;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile SetAttribute<Users, Reviews> reviewsSet;
    public static volatile SetAttribute<Users, Admin> adminSet;
    public static volatile SingularAttribute<Users, String> username;

}