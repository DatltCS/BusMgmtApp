package com.busmgmt.pojo;

import com.busmgmt.pojo.Bus;
import com.busmgmt.pojo.Busroutes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-27T18:51:30")
@StaticMetamodel(Bustrips.class)
public class Bustrips_ { 

    public static volatile SingularAttribute<Bustrips, Date> timeStop;
    public static volatile SingularAttribute<Bustrips, Date> timeStart;
    public static volatile SingularAttribute<Bustrips, Busroutes> routeId;
    public static volatile SingularAttribute<Bustrips, Long> price;
    public static volatile SingularAttribute<Bustrips, Integer> tripId;
    public static volatile SingularAttribute<Bustrips, String> tripName;
    public static volatile SingularAttribute<Bustrips, Bus> licensePlateId;

}