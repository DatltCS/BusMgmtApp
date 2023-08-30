package com.busmgmt.pojo;

import com.busmgmt.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-30T13:32:14")
@StaticMetamodel(Admin.class)
public class Admin_ { 

    public static volatile SingularAttribute<Admin, String> firstName;
    public static volatile SingularAttribute<Admin, String> lastName;
    public static volatile SingularAttribute<Admin, String> address;
    public static volatile SingularAttribute<Admin, String> phone;
    public static volatile SingularAttribute<Admin, Integer> adminId;
    public static volatile SingularAttribute<Admin, String> avatar;
    public static volatile SingularAttribute<Admin, Users> userId;
    public static volatile SingularAttribute<Admin, String> email;

}