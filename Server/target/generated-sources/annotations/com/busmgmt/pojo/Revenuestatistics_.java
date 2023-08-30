package com.busmgmt.pojo;

import com.busmgmt.pojo.Buscompanies;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-30T13:32:14")
@StaticMetamodel(Revenuestatistics.class)
public class Revenuestatistics_ { 

    public static volatile SingularAttribute<Revenuestatistics, Long> revenue;
    public static volatile SingularAttribute<Revenuestatistics, Buscompanies> companyId;
    public static volatile SingularAttribute<Revenuestatistics, Date> month;
    public static volatile SingularAttribute<Revenuestatistics, Date> year;
    public static volatile SingularAttribute<Revenuestatistics, Integer> revenueStatisticId;
    public static volatile SingularAttribute<Revenuestatistics, Integer> quarter;

}