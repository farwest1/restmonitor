package com.moeller.rest.api;

import com.moeller.business.service.SampleDataLoader;
import com.moeller.configuration.MyFeatures;
import com.moeller.rest.dto.Version;
import org.apache.camel.CamelContext;

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

    @Inject
    CamelContext camelContext;

    @GET
    @Produces("application/json")
    public Version getVersion() {
        //TODO: This is only a temporary try to load test data.
        if(MyFeatures.FEATURE_ONE.isActive()) {
            sampleDataLoader.init();
        }
        return new Version();
    }
}
