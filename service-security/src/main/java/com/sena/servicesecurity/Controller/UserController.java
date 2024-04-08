package com.sena.servicesecurity.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sena.servicesecurity.DTO.ILoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IUserDto;
import com.sena.servicesecurity.Entity.User;
import com.sena.servicesecurity.IService.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/user")
public class UserController extends ABaseController<User,IUserService>{
	public UserController(IUserService service) {
        super(service, "User");
    }
	
	@PostMapping("/login")
    public ResponseEntity<ApiResponseDto<Optional<IUserDto>>> show(@RequestBody ILoginDto login) {
        String username = login.getUsername();
        String password = login.getPassword();
        try {
            Optional<IUserDto> entity = service.getLogin(username, password);
            return ResponseEntity.ok(new ApiResponseDto<Optional<IUserDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Optional<IUserDto>>(e.getMessage(), null, false));
        }
    }
	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IUserDto>>> show() {
        try {
            List<IUserDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IUserDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IUserDto>>(e.getMessage(), null, false));
        }
		}
}
