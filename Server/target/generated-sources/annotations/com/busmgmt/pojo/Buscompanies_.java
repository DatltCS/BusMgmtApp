package com.busmgmt.pojo;

import com.busmgmt.pojo.Bus;
import com.busmgmt.pojo.Revenuestatistics;
import com.busmgmt.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-27T14:49:54")
@StaticMetamodel(Buscompanies.class)
public class Buscompanies_ { 

    public static volatile SingularAttribute<Buscompanies, String> nameCompany;
    public static volatile SingularAttribute<Buscompanies, Integer> companyId;
    public static volatile SingularAttribute<Buscompanies, String> address;
    public static volatile SetAttribute<Buscompanies, Bus> busSet;
    public static volatile SingularAttribute<Buscompanies, String> phone;
    public static volatile SingularAttribute<Buscompanies, Short> allowedDelivery;
    public static volatile SingularAttribute<Buscompanies, Integer> totalBus;
    public static volatile SingularAttribute<Buscompanies, String> avatar;
    public static volatile SingularAttribute<Buscompanies, Users> userId;
    public static volatile SetAttribute<Buscompanies, Revenuestatistics> revenuestatisticsSet;
    public static volatile SingularAttribute<Buscompanies, String> email;
    public static volatile SingularAttribute<Buscompanies, String> status;

}