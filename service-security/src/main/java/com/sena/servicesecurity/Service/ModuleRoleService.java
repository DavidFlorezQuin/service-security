package com.sena.servicesecurity.Service;

import com.sena.servicesecurity.DTO.IModuleRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.ModuleRole;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.IModuloRoleRepository;
import com.sena.servicesecurity.IService.IModuleRoleService;

import java.util.List;

@Service
public class ModuleRoleService extends ABaseService<ModuleRole> implements IModuleRoleService{

	@Override
	protected IBaseRepository<ModuleRole, Long> getRepository() {
		return repository;
	}
	@Autowired
	private IModuloRoleRepository repository;

	@Override
	public List<IModuleRoleDto> getModuleRole(Long idRole) {
		return repository.getModuleRole(idRole);
	}
}