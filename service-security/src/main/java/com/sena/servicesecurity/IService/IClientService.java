package com.sena.servicesecurity.IService;

import com.sena.servicesecurity.Entity.Client;
import com.sena.servicesecurity.Entity.Person;

public interface IClientService extends IBaseService<Client> {

        public String GenerateCodeCustomer(long idPerson) throws Exception ;

        public Client savePersonCustomer(Person entity) throws Exception;

    }
