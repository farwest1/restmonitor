package com.moeller.business.dao;

import com.moeller.business.domain.Permission;
import com.moeller.common.Dao;
import com.moeller.rest.dto.PermissionDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernd on 27.08.2016.
 */
@Dao
public class PermissionRepository {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public PermissionDTO findPermissionById(long id){
        PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setPermissionId(id);
        permissionDTO.setPermissionName("open shift");
        TypedQuery<Permission> query =
                    entityManager.createQuery("select p from Permission  p where p.id = :id", Permission.class);
        query.setParameter("id", id);
        query.getSingleResult();
        return permissionDTO;
    }

    public List<PermissionDTO> findPermissions(){
        List<PermissionDTO> permissionDTOList = new ArrayList<PermissionDTO>();
        permissionDTOList.add(new PermissionDTO(1,"Perm1"));
        permissionDTOList.add(new PermissionDTO(2,"Perm2"));

        return permissionDTOList;
    }
}
