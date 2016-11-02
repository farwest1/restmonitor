package com.moeller.business.domain;

import javax.persistence.*;

/**
 * Created by Bernd on 30.08.2016.
 *  Facility entity
 */

@Entity
@NamedQuery(
            name = "Facility.findByFacilityId",
            query = "select f from Facility f where f.facilityId = :facilityId")
@Table(name = "RM_FACILITY")
@TableGenerator(name = "gen", table="SHARED_SEQUENCES", initialValue=0, allocationSize=50)
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "gen")
    private long id;

    @Column(nullable = false, unique = true)
    private long facilityId;

    private String ipAddress;
    private String port;
    private String probeService;
    private String probeUrl;

    protected Facility() { //for JPA
    }

    public Facility(long facilityId, String ipAddress, String port, String probeService, String probeUrl){
        this.facilityId = facilityId;
        this.ipAddress = ipAddress;
        this.port = port;
        this.probeService = probeService;
        this.probeUrl = probeUrl;
    }

    public long getId(){
        return id;
    }

    public long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(long facilityId) {
        this.facilityId = facilityId;
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
