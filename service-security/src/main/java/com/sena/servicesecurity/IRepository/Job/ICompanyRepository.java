package com.sena.servicesecurity.IRepository.Job;

import com.sena.servicesecurity.Entity.Job.Company;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends IBaseRepository<Company, Long> {

}
