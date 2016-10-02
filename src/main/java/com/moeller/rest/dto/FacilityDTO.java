package com.moeller.rest.dto;

import com.moeller.business.domain.Facility;

/**
 * Created by Bernd on 04.09.2016.
 */
public class FacilityDTO {

    private long id;
    private String ipAddress;
    private String port;
    private String probeService;
    private String probeUrl;

    public FacilityDTO() {
    }

    public FacilityDTO(long id, String ipAddress, String port, String probeService, String probeUrl) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.port = port;
        this.probeService = probeService;
        this.probeUrl = probeUrl;
    }

    public FacilityDTO(Facility facility){
        this.id = facility.getId();
        this.ipAddress = facility.getIpAddress();
        this.probeService = facility.getProbeService();
        this.port = facility.getPort();
        this.probeUrl = facility.getProbeUrl();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProbeService() {
        return probeService;
    }

    public void setProbeService(String probeService) {
        this.probeService = probeService;
    }

    public String getProbeUrl() {
        return probeUrl;
    }

    public void setProbeUrl(String probeUrl) {
        this.probeUrl = probeUrl;
    }
}
