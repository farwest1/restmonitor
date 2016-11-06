package com.moeller.rest.integration;

import com.moeller.business.dao.FacilityDao;
import org.apache.camel.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Provides the dynamic endpoint to the route based on the header
 */
@ApplicationScoped
public class DynamicRoutes {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicRoutes.class);

    @Inject
    FacilityDao facilityDao;

    public String getPort(Message message){

        String facilityId = (String)message.getHeader("X-FAC");

        LOGGER.info("Get Port dynamically for " + facilityId);

        String url = facilityDao.findFacilityByFacilityId(Long.parseLong(facilityId,10)).getFullURL();

        return url + "?bridgeEndpoint=true";

    }
}
