package com.moeller.rest.integration;

import com.moeller.configuration.MyFeatures;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.SSLContextParametersSecureProtocolSocketFactory;
import org.apache.camel.util.jsse.SSLContextClientParameters;
import org.apache.camel.util.jsse.SSLContextParameters;
import org.apache.camel.util.jsse.TrustManagersParameters;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;


/**
 * Created by Bernd on 08.10.2016.
 */
public class MyRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {

        // configure SSL
        SSLContextClientParameters sccp = new SSLContextClientParameters();

        SSLContextParameters scp = new SSLContextParameters();
        TrustManagersParameters tmp = new TrustManagersParameters();
        tmp.setTrustManager(new FakeTrustManager());
        scp.setTrustManagers(tmp);


        ProtocolSocketFactory factory =
                new SSLContextParametersSecureProtocolSocketFactory(scp);

        Protocol.registerProtocol("https",
                new Protocol(
                        "https",
                        factory,
                        443));


        from("jetty:http://localhost:8555/triggerit?matchOnUriPrefix=true")
                    .to("log:com.moeller.rest.integration.httpproxy")
                    .to("https://172.28.128.3:8443/loadb/resources?bridgeEndpoint=true");
    }
}
