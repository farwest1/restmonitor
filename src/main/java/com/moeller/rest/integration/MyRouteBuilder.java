package com.moeller.rest.integration;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.SSLContextParametersSecureProtocolSocketFactory;
import org.apache.camel.util.jsse.SSLContextClientParameters;
import org.apache.camel.util.jsse.SSLContextParameters;
import org.apache.camel.util.jsse.TrustManagersParameters;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


/**
 * Created by Bernd on 08.10.2016.
 */
@ApplicationScoped
public class MyRouteBuilder extends RouteBuilder{

    @Inject
    private MyFilterBean myFilterBean;

    @Inject
    private DynamicRoutes dynamicRoutes;


    @Override
    public void configure() throws Exception {

        // configure SSL
   /*     SSLContextClientParameters sccp = new SSLContextClientParameters();

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
                        443));*/


        from("jetty:http://192.168.2.108:8555/triggerit?matchOnUriPrefix=true")
                    .filter().method(myFilterBean, "isValid")
                    .to("log:com.moeller.rest.integration.httpproxy?showAll=true")
                    .recipientList(method(dynamicRoutes,"getPort"));

    }
}
