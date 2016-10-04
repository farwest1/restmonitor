package com.moeller.rest.api;

import com.moeller.business.domain.Facility;
import com.moeller.business.service.FacilityService;
import com.moeller.rest.dto.FacilityDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernd on 02.10.2016.
 */
@ApplicationScoped
@Path("facilities")
public class FacilitiesController {

    @Inject
    private FacilityService facilityService;

    @GET
    @Produces("application/json")
    public List<FacilityDTO> getFacilities(){
        List<FacilityDTO> facilityDTOs = new ArrayList<FacilityDTO>();
        List<Facility> facilities = facilityService.readFacilities();
        //TODO: implement a single Dozer instance solution
        Mapper mapper = new DozerBeanMapper();

        //Moe: Do not really understand what I'm doing but it must be the latest stuff :-)
        facilities.forEach((facility -> {
            facilityDTOs.add(mapper.map(facility, FacilityDTO.class));
        }));
        return facilityDTOs;
    }
}
