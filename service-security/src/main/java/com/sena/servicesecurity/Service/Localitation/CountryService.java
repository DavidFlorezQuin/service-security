package com.sena.servicesecurity.Service.Localitation;

import java.util.List;

import com.sena.servicesecurity.DTO.Localitation.ICountryDto;
import com.sena.servicesecurity.Entity.Localitation.Country;
import com.sena.servicesecurity.IRepository.Localitation.ICountryRepository;
import com.sena.servicesecurity.IService.Localitation.ICountryService;
import com.sena.servicesecurity.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.servicesecurity.IRepository.IBaseRepository;
@Service
public class CountryService extends ABaseService<Country> implements ICountryService {


	
	@Autowired
	public ICountryRepository repository;

	@Override
	protected IBaseRepository<Country, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Override
	public List<ICountryDto> getListCountrys() {
		// TODO Auto-generated method stub
		return repository.getListCountrys();
	}
	
	

}
