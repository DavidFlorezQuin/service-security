package com.sena.servicesecurity.IRepository.Job;

import com.sena.servicesecurity.Entity.Job.Employed;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface IEmployedRepository extends IBaseRepository<Employed, Long> {

}
