package com.sena.servicesecurity.IService;

import com.sena.servicesecurity.DTO.IModuleRoleDto;
import com.sena.servicesecurity.Entity.ModuleRole;

import java.util.List;
import java.util.Optional;

public interface IModuleRoleService extends IBaseService<ModuleRole>{
    List<IModuleRoleDto> getModuleRole(Long idRole);
}
