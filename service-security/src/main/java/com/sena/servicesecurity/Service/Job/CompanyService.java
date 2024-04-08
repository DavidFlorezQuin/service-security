package com.sena.servicesecurity.Service.Job;

import com.sena.servicesecurity.Entity.Job.Company;
import com.sena.servicesecurity.IRepository.Job.ICompanyRepository;
import com.sena.servicesecurity.IService.Job.ICompanyService;
import com.sena.servicesecurity.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.IRepository.IBaseRepository;

@Service
public class CompanyService extends ABaseService<Company> implements ICompanyService {

	@Autowired
	private ICompanyRepository repository;
	
	@Override
	protected IBaseRepository<Company, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
