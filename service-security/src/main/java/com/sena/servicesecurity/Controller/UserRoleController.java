package com.sena.servicesecurity.Controller;

import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.UserRoleDto;
import com.sena.servicesecurity.DTO.IUserRoleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.servicesecurity.Entity.UserRole;
import com.sena.servicesecurity.IService.IUserRoleService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/userRole")
public class UserRoleController extends ABaseController<UserRole,IUserRoleService>{
	public UserRoleController(IUserRoleService service) {
        super(service, "UserRole");
    }

    @PostMapping("/UserRole")
    public ResponseEntity<ApiResponseDto<List<IUserRoleDto>>> showRole(@RequestBody UserRoleDto userRole){
        Long id = userRole.getId();
        try{
            List<IUserRoleDto> entity = service.getUserRole(id);
            return ResponseEntity.ok(new ApiResponseDto<List<IUserRoleDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IUserRoleDto>>(e.getMessage(), null, false));
        }
    }
}
