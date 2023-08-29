package com.busmgmt.pojo;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Routestatistics;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-25T21:34:31")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-22T13:40:26")
>>>>>>> be3458d405526b82a5d82d467d61aa24bfa672a3
@StaticMetamodel(Busroutes.class)
public class Busroutes_ { 

    public static volatile SetAttribute<Busroutes, Bustrips> bustripsSet;
    public static volatile SingularAttribute<Busroutes, Integer> routeId;
    public static volatile SingularAttribute<Busroutes, String> placeStart;
    public static volatile SetAttribute<Busroutes, Routestatistics> routestatisticsSet;
    public static volatile SingularAttribute<Busroutes, String> placeStop;
    public static volatile SingularAttribute<Busroutes, String> routeName;

}