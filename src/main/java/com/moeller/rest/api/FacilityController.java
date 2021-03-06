package com.moeller.rest.api;

import com.moeller.business.domain.Facility;
import com.moeller.business.service.FacilityService;
import com.moeller.rest.dto.FacilityDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Bernd on 04.09.2016.
 */
@ApplicationScoped
@Path("facility")
public class FacilityController {

    @Inject
    private FacilityService facilityService;

    @POST
    public void saveFacility(){

    }

    @GET
    @Path("/{facilityId}")
    public FacilityDTO getFacility(@PathParam("facilityId") long id){
        FacilityDTO facilityDTO;
        Facility facility = facilityService.readFacilty(id);
        Mapper mapper = new DozerBeanMapper();
        facilityDTO = mapper.map(facility, FacilityDTO.class);

        return  facilityDTO;

    }
}
