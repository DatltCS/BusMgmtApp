package com.busmgmt.pojo;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Customers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-29T19:48:02")
@StaticMetamodel(Reviews.class)
public class Reviews_ { 

    public static volatile SingularAttribute<Reviews, Date> createdDate;
    public static volatile SingularAttribute<Reviews, Integer> rating;
    public static volatile SingularAttribute<Reviews, Customers> customerId;
    public static volatile SingularAttribute<Reviews, String> comment;
    public static volatile SingularAttribute<Reviews, Bustrips> tripId;
    public static volatile SingularAttribute<Reviews, Integer> reviewId;

}