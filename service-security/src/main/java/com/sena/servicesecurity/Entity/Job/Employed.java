package com.sena.servicesecurity.Entity.Job;


import com.sena.servicesecurity.Entity.ABaseEntity;
import com.sena.servicesecurity.Entity.Person;
import jakarta.persistence.*;


@Entity
@Table(name="employed")

public class Employed extends ABaseEntity {
        @Column(name = "code", length = 50, nullable = false)
        private String code;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "company_id", nullable = false)
        private Company company;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "person_id", nullable = false)
        private Person person;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "position_id", nullable = false)
        private Position position;

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public Company getCompany() {
                return company;
        }

        public void setCompany(Company company) {
                this.company = company;
        }

        public Person getPerson() {
                return person;
        }

        public void setPerson(Person person) {
                this.person = person;
        }

        public Position getPosition() {
                return position;
        }

        public void setPosition(Position position) {
                this.position = position;
        }
}
