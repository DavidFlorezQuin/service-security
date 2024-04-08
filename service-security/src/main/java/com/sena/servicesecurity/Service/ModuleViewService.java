package com.sena.servicesecurity.Service;

import com.sena.servicesecurity.DTO.IModuleViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.servicesecurity.Entity.ModuleView;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.IModuloViewRepository;
import com.sena.servicesecurity.IService.IModuleViewService;

import java.util.List;

@Service
public class ModuleViewService extends ABaseService<ModuleView> implements IModuleViewService{

	@Override
	protected IBaseRepository<ModuleView, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IModuloViewRepository repository;

	@Override
	public List<IModuleViewDto> getModuleView(Long idModule) {
		return repository.getViewModule(idModule);
	}
}