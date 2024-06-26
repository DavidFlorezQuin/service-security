package com.sena.servicesecurity.IRepository.Localitation;

import java.util.List;

import com.sena.servicesecurity.DTO.Localitation.ICountryDto;
import com.sena.servicesecurity.Entity.Localitation.Country;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends IBaseRepository<Country, Long> {

	@Query(value = "SELECT `country`.`id`,\r\n"
			+ "    `country`.`created_at`,\r\n"
			+ "    `country`.`created_by`,\r\n"
			+ "    `country`.`deleted_at`,\r\n"
			+ "    `country`.`deleted_by`,\r\n"
			+ "    `country`.`state`,\r\n"
			+ "    `country`.`updated_at`,\r\n"
			+ "    `country`.`updated_by`,\r\n"
			+ "    `country`.`code` AS code_country,\r\n"
			+ "    `country`.`name` AS name_country\r\n"
		
			+ "FROM `service_security`.`country`;\r\n"
			+ "",nativeQuery = true)
	List<ICountryDto> getListCountrys();
}
