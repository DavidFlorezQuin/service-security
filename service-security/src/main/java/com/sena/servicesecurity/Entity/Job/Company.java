package com.sena.servicesecurity.Entity.Job;

import com.sena.servicesecurity.Entity.ABaseEntity;
import com.sena.servicesecurity.Entity.Localitation.City;
import jakarta.persistence.*;

@Entity
@Table(name="company")
public class Company extends ABaseEntity {

    @Column(name ="nit", length = 50, nullable = false)
    private String nit;

    @Column(name ="address", length = 50, nullable = false)
    private String address;

    @Column(name="web", length = 50, nullable = false)
    private String web;

    @Column(name="phone", length = 50, nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="city_id", nullable = false)
    private City city;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


}