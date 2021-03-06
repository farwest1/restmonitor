package com.moeller.rest.integration;

import com.moeller.configuration.MyFeatures;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Bernd on 08.10.2016.
 */
public class MyRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {
            from("jetty:http://localhost:8555/triggerit?matchOnUriPrefix=true")
                    .to("log:com.moeller.rest.integration.httpproxy")
                    .to("http://172.28.128.3:8080/loadb/resources?bridgeEndpoint=true");
    }
}
