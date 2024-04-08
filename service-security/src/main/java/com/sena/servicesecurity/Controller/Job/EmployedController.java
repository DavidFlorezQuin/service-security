package com.sena.servicesecurity.Controller.Job;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Job.Employed;
import com.sena.servicesecurity.IService.Job.IEmployedService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/employed")
public class EmployedController extends ABaseController<Employed, IEmployedService> {

	protected EmployedController(IEmployedService service) {
		super(service, "Employed");
	}

}
