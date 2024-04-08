package com.sena.servicesecurity.Service;

import com.sena.servicesecurity.Entity.ABaseEntity;
import com.sena.servicesecurity.Entity.Client;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.IClientRepository;
import com.sena.servicesecurity.IService.IBaseService;
import com.sena.servicesecurity.IService.IClientService;
import com.sena.servicesecurity.IService.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClientService extends ABaseService<Client> implements IClientService {

    @Autowired
    public IClientRepository repository;
    @Autowired
    public IPersonService personService;

    @Override
    protected IBaseRepository<Client, Long> getRepository() {
        return repository;
    }
    @Override
    public Client save(Client entity) throws Exception {
        try {
            String codeCustomer = GenerateCodeCustomer(entity.getPerson().getId());
            entity.setCode(codeCustomer);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setCreatedBy((long) 1); //
            return getRepository().save(entity);
        } catch (Exception e) {
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
    }

    @Override
    public String GenerateCodeCustomer(long idPerson) throws Exception {

        Optional<Person> person = personService.findById(idPerson) ;

        if (person == null) {
            throw new Exception("No se encontro persona con el ID: " + idPerson);
        } else {

            String document = person.get().getDni();

            String documentDigits = document.substring(Math.max(0, document.length() - 4));

            int currentYear = LocalDate.now().getYear();

            String code = currentYear + "-" + person.get().getTypeInit() + "-" + documentDigits;

            return code;
        }
    }

    @Override
    public Client savePersonCustomer(Person entity) throws Exception {

        Person person = personService.save(entity);

        Client entityCliente = new Client();

        String codeCustomer = GenerateCodeCustomer(person.getId());

        entityCliente.setCode(codeCustomer);
        entityCliente.setPerson(person);
        entityCliente.setState(true);
        entityCliente.setCreatedAt(LocalDateTime.now());
        entityCliente.setCreatedBy((long) 1);

        repository.save(entityCliente);

        return entityCliente;
    }


}




