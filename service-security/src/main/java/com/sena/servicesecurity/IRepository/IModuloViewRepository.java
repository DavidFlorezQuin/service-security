package com.sena.servicesecurity.IRepository;

import java.util.List;

import com.sena.servicesecurity.DTO.IModuleRoleDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IModuleViewDto;
import com.sena.servicesecurity.Entity.ModuleView;

@Repository
public interface IModuloViewRepository extends IBaseRepository<ModuleView, Long>{

	@Query(value = " SELECT "
			+ "	id,"
			+ "	name as module,"
			+ " route, "
			+ " description, "
			+ " state "
			+ "	FROM "
			+ "	module "
			+ "	WHERE "
			+ " deleted_at IS NULL", nativeQuery = true)
	List<IModuleViewDto> getList();


	@Query(value = "SELECT "
			+ "    v.id,"
			+ "    v.route AS routeName,"
			+ "    v.name AS viewName "
			+ "FROM "
			+ "    module_view mv "
			+ "INNER JOIN "
			+ "    view v ON v.id = mv.view_id "
			+ "INNER JOIN "
			+ "    module m ON m.id = mv.module_id "
			+ "WHERE "
			+ "    mv.module_id = :idModule", nativeQuery = true)
	List<IModuleViewDto> getViewModule(Long idModule);
}
