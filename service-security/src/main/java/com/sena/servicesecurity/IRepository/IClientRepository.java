package com.sena.servicesecurity.IRepository;

import com.sena.servicesecurity.Entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends IBaseRepository<Client, Long> {
}
