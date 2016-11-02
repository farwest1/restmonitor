package com.moeller.business.dao;

import com.moeller.business.domain.Facility;
import com.moeller.common.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Bernd on 30.08.2016.
 */
@Dao
public class FacilityDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(FacilityDao.class);

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;


    protected void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Facility findFacilityById(long id){
        return entityManager.find(Facility.class, id);
    }

    public Facility findFacilityByFacilityId(long facilityId) {
        LOGGER.debug("Find Facility for id " + facilityId);
        TypedQuery<Facility> query = entityManager.createNamedQuery("Facility.findByFacilityId", Facility.class );
        return query.setParameter("facilityId", facilityId).getSingleResult();
    }

    //TODO: Write test
    public List<Facility> findAllFacilities(){
        List<Facility> facilities= entityManager.
                createQuery("select f from Facility f", Facility.class)
                .getResultList();
        LOGGER.debug("Found " + facilities.size() + " facilities in database");
        return facilities;
    }

    public void saveFacility(Facility facility){
        entityManager.persist(facility);
    }

}
