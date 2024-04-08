package com.sena.servicesecurity.IRepository;

import com.sena.servicesecurity.DTO.IUserRoleDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.UserRole;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRoleRepository extends IBaseRepository<UserRole, Long>{

        
    @Query(value = " SELECT "
            + " r.name roleName,	"
            + " r.id id,	"
            + " u.username userName, "
            + " u.state "
            + "FROM "
            + "	user_role ur "
            + " INNER JOIN user u ON u.id = ur.user_id "
            + " INNER JOIN role r ON r.id = ur.role_id "
            + "WHERE "
            + " u.id = :userId  ", nativeQuery = true)
    List<IUserRoleDto> getUserRole(Long userId);
}
