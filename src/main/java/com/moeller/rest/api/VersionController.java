package com.moeller.rest.api;

import com.moeller.business.service.SampleDataLoader;
import com.moeller.rest.dto.Version;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Bernd on 27.08.2016.
 */

@ApplicationScoped
@Path("version")
public class VersionController {

    @Inject
    private SampleDataLoader sampleDataLoader;

    @GET
    @Produces("application/json")
    public Version getVersion() {
        sampleDataLoader.init();
        return new Version();
    }
}
