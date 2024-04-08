package com.sena.servicesecurity.Service;

import com.sena.servicesecurity.IService.IEnumService;
import com.sena.servicesecurity.Utils.Enum.DiasSemana;
import com.sena.servicesecurity.Utils.Enum.Meses;
import com.sena.servicesecurity.Utils.Enum.Nomenclatura;
import com.sena.servicesecurity.Utils.Enum.TypeDni;
import org.springframework.stereotype.Service;

@Service
public class EnumService implements IEnumService {
    @Override
    public Meses[] getMeses() {
        return Meses.values();
    }

    @Override
    public DiasSemana[] Dias() {
        return DiasSemana.values();
    }

    @Override
    public Nomenclatura[] getNomenclatura() {
        return Nomenclatura.values();
    }

    @Override
    public TypeDni[] getTypeId() {
        return TypeDni.values();
    }
}
