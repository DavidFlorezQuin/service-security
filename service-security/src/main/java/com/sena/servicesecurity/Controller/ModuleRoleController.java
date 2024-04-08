package com.sena.servicesecurity.Controller;

import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IModuleRoleDto;
import com.sena.servicesecurity.DTO.IdRoleModuleDto;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.servicesecurity.Entity.ModuleRole;
import com.sena.servicesecurity.IService.IModuleRoleService;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/module-role")
public class ModuleRoleController extends ABaseController<ModuleRole, IModuleRoleService>{
	public ModuleRoleController(IModuleRoleService service) {
        super(service, "ModuleRole");
    }

    @PostMapping("/moduleRole")
    public ResponseEntity<ApiResponseDto<List<IModuleRoleDto>>> showList(@RequestBody IdRoleModuleDto idRole){
        Long id = idRole.getId();
        try{
        List<IModuleRoleDto> entity = service.getModuleRole(id);
        return ResponseEntity.ok(new ApiResponseDto<List<IModuleRoleDto>>("Registro encontrado", entity, true));
    } catch (Exception e){
        return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IModuleRoleDto>>(e.getMessage(), null, false));
    }
}
}