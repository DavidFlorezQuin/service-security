package com.sena.servicesecurity.IService.Localitation;

import java.util.List;

import com.sena.servicesecurity.DTO.Localitation.ICountryDto;
import com.sena.servicesecurity.Entity.Localitation.Country;
import com.sena.servicesecurity.IService.IBaseService;

public interface ICountryService  extends IBaseService<Country> {
	List<ICountryDto> getListCountrys();
}
