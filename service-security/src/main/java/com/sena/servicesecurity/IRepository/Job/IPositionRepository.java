package com.sena.servicesecurity.IRepository.Job;

import com.sena.servicesecurity.Entity.Job.Position;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends IBaseRepository<Position, Long> {

}
