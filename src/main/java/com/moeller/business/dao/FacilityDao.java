package com.moeller.business.dao;

import com.moeller.business.domain.Facility;
import com.moeller.common.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by Bernd on 30.08.2016.
 */
@Dao
public class FacilityDao {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public Facility findFacilityById(long id){
        return entityManager.find(Facility.class, id);
    }

    public void saveFacility(Facility facility){
        entityManager.persist(facility);
    }

}
