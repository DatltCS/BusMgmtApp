package com.busmgmt.pojo;

import com.busmgmt.pojo.Customers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-25T21:34:31")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-22T13:40:26")
>>>>>>> be3458d405526b82a5d82d467d61aa24bfa672a3
@StaticMetamodel(Reviews.class)
public class Reviews_ { 

    public static volatile SingularAttribute<Reviews, Integer> rating;
    public static volatile SingularAttribute<Reviews, Customers> customerId;
    public static volatile SingularAttribute<Reviews, String> comment;
    public static volatile SingularAttribute<Reviews, Integer> reviewId;

}