package com.sena.servicesecurity.Entity.Job;

import com.sena.servicesecurity.Entity.ABaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "contratc")
public class Contract extends ABaseEntity {

    @Column(name = "code", length = 50, nullable = false)
    private String code;

    @Column(name = "start_date", length = 50, nullable = false)
    private String startDate;

    @Column(name = "end_date", length = 50, nullable = false)
    private String endDate;

    @Column(name = "salary", length = 50, nullable = false)
    private String salary;

    @Column(name = "object", nullable = false)
    private String firstName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "employed_id", nullable = false)
    private Employed employed;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Employed getEmployed() {
        return employed;
    }

    public void setEmployed(Employed employed) {
        this.employed = employed;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


}