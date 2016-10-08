package com.moeller.rest.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Bernd on 05.10.2016.
 */
public class MapperProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapperProducer.class);

    @Produces
    @ApplicationScoped
    public Mapper getMapper(){
        LOGGER.info("Produce a Dozer mapper");
        return new DozerBeanMapper(Arrays.asList("mapping.xml"));
    }
}
