package com.moeller.rest.api;

import com.moeller.business.service.PermissionService;
import com.moeller.rest.dto.PermissionDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by Bernd on 27.08.2016.
 */
@ApplicationScoped
@Path(value = "permissions")
public class PermissionsController {

    @Inject
    PermissionService permissionService;

    @GET
    @Produces("application/json")
    public List<PermissionDTO> getPermissions(){
        return permissionService.getAllPermissions();
    }
}
