package com.busmgmt.pojo;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Routestatistics;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-07T18:15:11")
@StaticMetamodel(Busroutes.class)
public class Busroutes_ { 

    public static volatile SetAttribute<Busroutes, Bustrips> bustripsSet;
    public static volatile SingularAttribute<Busroutes, Integer> routeId;
    public static volatile SingularAttribute<Busroutes, String> placeStart;
    public static volatile SetAttribute<Busroutes, Routestatistics> routestatisticsSet;
    public static volatile SingularAttribute<Busroutes, String> placeStop;
    public static volatile SingularAttribute<Busroutes, String> routeName;

}