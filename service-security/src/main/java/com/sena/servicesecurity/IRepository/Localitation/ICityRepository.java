package com.sena.servicesecurity.IRepository.Localitation;

import java.util.List;

import com.sena.servicesecurity.DTO.Localitation.ICityDto;
import com.sena.servicesecurity.Entity.Localitation.City;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ICityRepository extends IBaseRepository<City, Long> {

	@Query(value = "	SELECT `city`.`id`,\r\n"
			+ "			    `city`.`created_at`,\r\n"
			+ "			    `city`.`created_by`,\r\n"
			+ "			    `city`.`deleted_at`,\r\n"
			+ "			    `city`.`deleted_by`,\r\n"
			+ "			    `city`.`state`,\r\n"
			+ "			    `city`.`updated_at`,\r\n"
			+ "			    `city`.`updated_by`,\r\n"
			+ "			    `city`.`code` AS code_city, \r\n"
			+ "			    `city`.`name` AS name_city,\r\n"
			+ "			\r\n"
			+ "			    `d`.`name` AS department\r\n"
			+ "			    FROM `service_security`.`city`\r\n"
			+ "			inner join department AS d on city.department_id =d.id",nativeQuery = true)
		List<ICityDto> GetListCitys();
	
	
}
