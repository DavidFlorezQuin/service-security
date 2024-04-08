package com.sena.servicesecurity.Service.Localitation;

import java.util.List;

import com.sena.servicesecurity.DTO.Localitation.ICityDto;
import com.sena.servicesecurity.Entity.Localitation.City;
import com.sena.servicesecurity.IRepository.Localitation.ICityRepository;
import com.sena.servicesecurity.IService.Localitation.ICityService;
import com.sena.servicesecurity.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Service
public class CityService extends ABaseService<City> implements ICityService {

	@Override
	protected IBaseRepository<City, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public ICityRepository repository;

	@Override
	public List<ICityDto> GetListCitys() {
		// TODO Auto-generated method stub
		return repository.GetListCitys();
	}

}
