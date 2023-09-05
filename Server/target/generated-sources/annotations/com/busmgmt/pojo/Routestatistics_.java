package com.busmgmt.pojo;

import com.busmgmt.pojo.Busroutes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-04T21:21:20")
@StaticMetamodel(Routestatistics.class)
public class Routestatistics_ { 

    public static volatile SingularAttribute<Routestatistics, Busroutes> routeId;
    public static volatile SingularAttribute<Routestatistics, Date> month;
    public static volatile SingularAttribute<Routestatistics, Date> year;
    public static volatile SingularAttribute<Routestatistics, Integer> routeStatisticsId;
    public static volatile SingularAttribute<Routestatistics, Integer> quarter;
    public static volatile SingularAttribute<Routestatistics, Integer> frequency;

}