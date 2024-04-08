package com.sena.servicesecurity.Service.Job;

import com.sena.servicesecurity.Entity.Job.Employed;
import com.sena.servicesecurity.IRepository.Job.IEmployedRepository;
import com.sena.servicesecurity.IService.Job.IEmployedService;
import com.sena.servicesecurity.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.IRepository.IBaseRepository;

@Service
public class EmployedService extends ABaseService<Employed> implements IEmployedService {

	@Autowired
	private IEmployedRepository repository;
	
	@Override
	protected IBaseRepository<Employed, Long> getRepository() {
		return repository;
	}

}
