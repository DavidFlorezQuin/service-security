package com.sena.servicesecurity.IService;

import com.sena.servicesecurity.DTO.IUserRoleDto;
import com.sena.servicesecurity.Entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface IUserRoleService extends IBaseService<UserRole>{

    List<IUserRoleDto> getUserRole(Long user);

}
