package com.moeller.rest.api;

import com.moeller.business.service.PermissionService;
import com.moeller.rest.dto.PermissionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Bernd on 25.08.2016.
 *
 * The Controller for the PermissionDTO Ressource
 */
@ApplicationScoped
@Path("permission/{permissionId}")
public class PermissionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Inject
    private PermissionService permissionService;

    @Context
    private HttpHeaders httpHeaders;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces("application/json")
    public PermissionDTO getPerm(@PathParam("permissionId") long permissionId){
        LOGGER.debug("provide PermissionDTO");

        LOGGER.info(uriInfo.getPath());
        LOGGER.info(httpHeaders.getHeaderString("MyHead"));

        if(permissionId>=1000) {
            throw new NotFoundException("Ressource " + permissionId + " was not found");
        }

        return permissionService.getPermission(permissionId);
    }
}
