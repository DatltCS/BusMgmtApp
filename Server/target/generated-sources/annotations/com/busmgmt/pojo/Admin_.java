package com.busmgmt.pojo;

import com.busmgmt.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-25T21:34:31")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-22T13:40:26")
>>>>>>> be3458d405526b82a5d82d467d61aa24bfa672a3
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