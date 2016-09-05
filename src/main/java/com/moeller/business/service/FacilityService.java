package com.moeller.business.service;

import com.moeller.business.dao.FacilityDao;
import com.moeller.business.domain.Facility;
import com.moeller.common.Service;

import javax.inject.Inject;

/**
 * Created by Bernd on 04.09.2016.
 */
@Service
public class FacilityService {

    @Inject
    private FacilityDao facilityDao;

    public void saveFacility(Facility facility){
        facilityDao.saveFacility(facility);
    }

    public Facility readFacilty(long id){
        return facilityDao.findFacilityById(id);
    }
}
