package com.sena.servicesecurity.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client extends ABaseEntity{

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public String getCode() {   
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
