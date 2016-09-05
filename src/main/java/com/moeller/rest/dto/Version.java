package com.moeller.rest.dto;

/**
 * Created by Bernd on 27.08.2016.
 */
public class Version {
    private static final String version = "0.0.9";
    private static final String description = "Resttemplate";

    public String getVersion(){
        return version;
    }

    public String getDescription(){
        return description;
    }
}
