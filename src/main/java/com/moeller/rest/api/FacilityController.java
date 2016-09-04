package com.moeller.rest.api;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by Bernd on 04.09.2016.
 */
@ApplicationScoped
@Path("facility")
public class FacilityController {

    @POST
    public void saveFacility(){

    }
}
