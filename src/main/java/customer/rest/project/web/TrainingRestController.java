package customer.rest.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import customer.rest.project.domain.Training;
import customer.rest.project.domain.TrainingRepository;

@RestController
@CrossOrigin
public class TrainingRestController {

	@Autowired
	private TrainingRepository trainingRepository;

	@GetMapping("/trainings")
	public @ResponseBody List<Training> getTrainings() {
		return (List<Training>) trainingRepository.findAll();
	}
}
