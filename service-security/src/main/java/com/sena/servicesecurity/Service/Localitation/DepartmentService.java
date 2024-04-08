package com.sena.servicesecurity.Service.Localitation;

import java.util.List;

import com.sena.servicesecurity.DTO.Localitation.IDepartmentDto;
import com.sena.servicesecurity.Entity.Localitation.Departament;
import com.sena.servicesecurity.IRepository.Localitation.IDepartmentRepository;
import com.sena.servicesecurity.IService.Localitation.IDepartmentService;
import com.sena.servicesecurity.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Service
public class DepartmentService  extends ABaseService<Departament> implements IDepartmentService {

	
	@Autowired
	public IDepartmentRepository repository;

	@Override
	public List<IDepartmentDto> getListDepartaments() {
		// TODO Auto-generated method stub
		return repository.getListDepartaments();
	}

	@Override
	protected IBaseRepository<Departament, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}

