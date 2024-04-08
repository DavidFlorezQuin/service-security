package com.sena.servicesecurity.Controller;

import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.Entity.Client;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IService.IClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/client")
public class ClientController extends ABaseController<Client, IClientService> {
    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected ClientController(IClientService service) {
        super(service, "Client");
    }


    @PostMapping("/personCustomer")
    public ResponseEntity<ApiResponseDto<Client>> save(@RequestBody Person entity) {
        try {
            return ResponseEntity.ok(new ApiResponseDto<Client>("Datos guardados", service.savePersonCustomer(entity), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Client>(e.getMessage(), null, false));
        }
    }


}
