package com.busmgmt.pojo;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.pojo.Busseat;
import com.busmgmt.pojo.Bustrips;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-10T17:33:13")
@StaticMetamodel(Bus.class)
public class Bus_ { 

    public static volatile SingularAttribute<Bus, String> image;
    public static volatile SingularAttribute<Bus, Buscompanies> companyId;
    public static volatile SetAttribute<Bus, Bustrips> bustripsSet;
    public static volatile SetAttribute<Bus, Busseat> busseatSet;
    public static volatile SingularAttribute<Bus, String> busName;
    public static volatile SingularAttribute<Bus, Integer> licensePlateId;
    public static volatile SingularAttribute<Bus, String> busType;
    public static volatile SingularAttribute<Bus, Integer> totalSeat;

}