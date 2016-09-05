package com.moeller.business.service;

import com.moeller.business.domain.Facility;
import com.moeller.common.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by Bernd on 05.09.2016.
 */
@Service
public class SampleDataLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleDataLoader.class);

    @Inject
    private FacilityService facilityService;


    public void init(){
        LOGGER.info("Load Sample Data");
        Facility facility = new Facility(
                                    "127.0.0.1",
                                    "1521",
                                    "ProbeService",
                                    "/url");

        facilityService.saveFacility(facility);

    }
}
