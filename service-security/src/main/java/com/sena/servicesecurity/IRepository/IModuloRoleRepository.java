package com.sena.servicesecurity.IRepository;

import java.util.List;

import com.sena.servicesecurity.DTO.IModuleRoleDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IViewDto;
import com.sena.servicesecurity.Entity.ModuleRole;

@Repository
public interface IModuloRoleRepository extends IBaseRepository<ModuleRole, Long>{

	
	@Query(value = " SELECT "
			+ "	id,"
			+ "	name as view,"			
			+ " description, "
			+ " route, "
			+ " state "
			+ "	FROM "
			+ "	view "
			+ "	WHERE "
			+ " deleted_at IS NULL", nativeQuery = true)
		List<IViewDto> getList();

	@Query(value = "SELECT "
			+ "    m.id,"
			+ "    m.name AS moduleName,"
			+ "    r.name AS roleName "
			+ "FROM "
			+ "    module_role mr "
			+ "INNER JOIN "
			+ "    role r ON r.id = mr.role_id "
			+ "INNER JOIN "
			+ "    module m ON m.id = mr.module_id "
			+ "WHERE "
			+ "    mr.role_id = :idRole", nativeQuery = true)
	List<IModuleRoleDto> getModuleRole(Long idRole);

}
