package com.moeller.business.dao;

import com.moeller.business.domain.Facility;
import com.moeller.test.JpaBaseRolledBackTestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Bernd on 04.09.2016.
 */
public class FacilityDaoTest extends JpaBaseRolledBackTestCase {
    @Test
    public void findFacilityById() throws Exception {
        FacilityDao facilityDao = new FacilityDao();
        facilityDao.setEntityManager(em);
        facilityDao.saveFacility( new Facility("1.2.3.4","1234","probeit", "probeurl"));

        List<Facility> facilities = facilityDao.findAllFacilities();

        assertEquals( "1.2.3.4", facilities.get(0).getIpAddress());
        assertEquals(1, facilities.size());
    }

    @Test
    public void saveFacility() throws Exception {
        Facility facility = new Facility("1.2.3.4","1234","probeit", "probeurl");
        em.persist(facility);


    }

}