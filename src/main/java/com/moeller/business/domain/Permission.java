package com.moeller.business.domain;

import javax.persistence.*;

/**
 * Created by Bernd on 28.08.2016.
 */
@Entity(name = "Permission")
@TableGenerator(name = "gen", table="SHARED_SEQUENCES", initialValue=0, allocationSize=50)
@Table(name = "PERMISSION")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "gen")
    @Column(name="P_ID")
    private long id;

    @Column(name = "P_DESCRIPTION")
    private String description;

    protected Permission(){
        //for JPA
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
