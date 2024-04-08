package com.sena.servicesecurity.Controller.Job;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Job.Company;
import com.sena.servicesecurity.IService.Job.ICompanyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/company")
public class CompanyController extends ABaseController<Company, ICompanyService> {

	protected CompanyController(ICompanyService service) {
		super(service, "Company");
		// TODO Auto-generated constructor stub
	}

}
