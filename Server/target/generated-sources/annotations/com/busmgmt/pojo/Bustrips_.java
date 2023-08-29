package com.busmgmt.pojo;

import com.busmgmt.pojo.Bus;
import com.busmgmt.pojo.Busroutes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-25T21:34:31")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-22T13:40:26")
>>>>>>> be3458d405526b82a5d82d467d61aa24bfa672a3
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