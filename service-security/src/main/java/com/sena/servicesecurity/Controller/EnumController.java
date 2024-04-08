package com.sena.servicesecurity.Controller;

import com.sena.servicesecurity.IService.IEnumService;
import com.sena.servicesecurity.Service.EnumService;
import com.sena.servicesecurity.Utils.Enum.DiasSemana;
import com.sena.servicesecurity.Utils.Enum.Meses;
import com.sena.servicesecurity.Utils.Enum.Nomenclatura;
import com.sena.servicesecurity.Utils.Enum.TypeDni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/enum")
public class EnumController {

    @Autowired
    private IEnumService service;

    @GetMapping("/meses")
    public Meses[] getMeses(){
        return service.getMeses();
    }

    @GetMapping("/direction")
    public Nomenclatura[] getNomenclatura(){
        return service.getNomenclatura();
    }


    @GetMapping("/dias")
    public DiasSemana[] getDias(){
        return service.Dias();
    }

    @GetMapping("/tipo-id")
    public TypeDni[] getDni() {
        return service.getTypeId();
    }

}
