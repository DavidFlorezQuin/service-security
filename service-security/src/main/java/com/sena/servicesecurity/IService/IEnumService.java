package com.sena.servicesecurity.IService;

import com.sena.servicesecurity.Utils.Enum.DiasSemana;
import com.sena.servicesecurity.Utils.Enum.Meses;
import com.sena.servicesecurity.Utils.Enum.Nomenclatura;
import com.sena.servicesecurity.Utils.Enum.TypeDni;

public interface IEnumService {
    Meses[] getMeses();

    DiasSemana[] Dias();

    Nomenclatura[] getNomenclatura();

    TypeDni[] getTypeId();

}
