package com.moeller.rest.integration;

import org.apache.camel.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

/**
 * Provides the dynamic endpoint to the route based on the header
 */
@ApplicationScoped
public class DynamicRoutes {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicRoutes.class);

    public String getPort(Message message){

        String facilityId = (String)message.getHeader("X-FAC");

        LOGGER.info("Get Port dynamically for " + facilityId);

        if("2010".equals(facilityId))
            return "http://172.28.128.3:8080/loadb/resources?bridgeEndpoint=true";
        else if ("2011".equals(facilityId))
            return "http://172.28.128.3:8090/loadb/resources?bridgeEndpoint=true";
        else
            return "";
    }
}
