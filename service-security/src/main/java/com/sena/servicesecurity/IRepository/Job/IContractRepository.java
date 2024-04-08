package com.sena.servicesecurity.IRepository.Job;

import com.sena.servicesecurity.Entity.Job.Contract;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends IBaseRepository<Contract, Long> {

}
