package com.sena.servicesecurity.Service.Job;

import com.sena.servicesecurity.Entity.Job.Position;
import com.sena.servicesecurity.IRepository.Job.IPositionRepository;
import com.sena.servicesecurity.IService.Job.IPositionService;
import com.sena.servicesecurity.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.servicesecurity.IRepository.IBaseRepository;
@Service
public class PositionService extends ABaseService<Position> implements IPositionService {

	@Override
	protected IBaseRepository<Position, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IPositionRepository repository;

}
