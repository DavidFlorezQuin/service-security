package com.sena.servicesecurity.IService.Localitation;

import java.util.List;

import com.sena.servicesecurity.DTO.Localitation.ICityDto;
import com.sena.servicesecurity.Entity.Localitation.City;
import com.sena.servicesecurity.IService.IBaseService;

public interface ICityService extends IBaseService<City> {
	List<ICityDto> GetListCitys();
}
