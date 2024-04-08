package com.sena.servicesecurity.Controller.Job;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Job.Position;
import com.sena.servicesecurity.IService.Job.IPositionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/position")
public class PositionRepository extends ABaseController<Position, IPositionService> {

	protected PositionRepository(IPositionService service) {
		super(service, "Position");

	}

}
