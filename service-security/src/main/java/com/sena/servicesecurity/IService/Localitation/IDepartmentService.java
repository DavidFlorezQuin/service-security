package com.sena.servicesecurity.IService.Localitation;

import java.util.List;

import com.sena.servicesecurity.DTO.Localitation.IDepartmentDto;
import com.sena.servicesecurity.Entity.Localitation.Departament;
import com.sena.servicesecurity.IService.IBaseService;

public interface IDepartmentService extends IBaseService<Departament> {
	 List<IDepartmentDto> getListDepartaments();
}
