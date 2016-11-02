package com.moeller.rest.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by Bernd on 01.11.2016.
 */
@ApplicationScoped
public class MyFilterBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilterBean.class);

    public boolean isValid (){
        LOGGER.info("Message filter was called");
        return false;
    }
}
