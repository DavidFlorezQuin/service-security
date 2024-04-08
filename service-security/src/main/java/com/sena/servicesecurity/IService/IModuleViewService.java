package com.sena.servicesecurity.IService;

import com.sena.servicesecurity.DTO.IModuleViewDto;
import com.sena.servicesecurity.Entity.ModuleView;

import java.util.List;

public interface IModuleViewService extends IBaseService<ModuleView>{

    List<IModuleViewDto> getModuleView(Long idModule);

}
