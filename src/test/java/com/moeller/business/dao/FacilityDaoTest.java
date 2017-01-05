package com.moeller.business.dao;

import com.moeller.business.Protocol;
import com.moeller.business.domain.Facility;
import com.moeller.test.JpaBaseRolledBackTestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Bernd on 04.09.2016.
 */
public class FacilityDaoTest extends JpaBaseRolledBackTestCase {
    @Test
    public void findFacilityById() throws Exception {
        FacilityDao facilityDao = new FacilityDao();
        facilityDao.setEntityManager(em);
        facilityDao.saveFacility( new Facility(2010, Protocol.HTTP,"1.2.3.4","1234","probeit", "probeurl"));

        List<Facility> facilities = facilityDao.findAllFacilities();

        assertEquals( "1.2.3.4", facilities.get(0).getIpAddress());
        assertEquals(1, facilities.size());
    }

    @Test
    public void saveFacility() throws Exception {
        Facility facility = new Facility(2010,Protocol.HTTP, "1.2.3.4","1234","probeit", "probeurl");
        em.persist(facility);
        em.flush();
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void checkUniqueFacilityId()throws Exception{

        Facility facilityA = new Facility(2010, Protocol.HTTP, "1.2.3.4","1234","probeit", "probeurl");
        Facility facilityB = new Facility(2010, Protocol.HTTP,"5.6.7.8","1234","probeit", "probeurl");
        em.persist(facilityA);
        em.persist(facilityB);      // Hier muesste es eigentlich knallen
        em.flush();
    }

    @Test
    public void findFacilityByFacilityId() throws Exception {
        FacilityDao facilityDao = new FacilityDao();
        facilityDao.setEntityManager(em);
        Facility facility = new Facility(2010, Protocol.HTTP, "1.2.3.4","1234","probeit", "probeurl");
        em.persist(facility);
        //em.flush();

        Facility testFacility = facilityDao.findFacilityByFacilityId(2010);
        System.out.println(facilityDao.findFacilityByFacilityId(2010L));
        assertEquals(2010, testFacility.getFacilityId());
    }

}