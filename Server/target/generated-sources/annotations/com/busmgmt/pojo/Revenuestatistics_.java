package com.busmgmt.pojo;

import com.busmgmt.pojo.Buscompanies;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-25T21:34:31")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-22T13:40:26")
>>>>>>> be3458d405526b82a5d82d467d61aa24bfa672a3
@StaticMetamodel(Revenuestatistics.class)
public class Revenuestatistics_ { 

    public static volatile SingularAttribute<Revenuestatistics, Long> revenue;
    public static volatile SingularAttribute<Revenuestatistics, Buscompanies> companyId;
    public static volatile SingularAttribute<Revenuestatistics, Date> month;
    public static volatile SingularAttribute<Revenuestatistics, Date> year;
    public static volatile SingularAttribute<Revenuestatistics, Integer> revenueStatisticId;
    public static volatile SingularAttribute<Revenuestatistics, Integer> quarter;

}