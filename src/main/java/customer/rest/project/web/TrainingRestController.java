package customer.rest.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import customer.rest.project.domain.Training;
import customer.rest.project.domain.TrainingRepository;

@RestController
@CrossOrigin
public class TrainingRestController {

	@Autowired
	private TrainingRepository trainingRepository;

	// get all training
	@GetMapping("/trainings")
	public @ResponseBody List<Training> getTrainings() {
		return (List<Training>) trainingRepository.findAll();
	}

	// get single training
	@GetMapping("/trainings/{id}")
	public @ResponseBody Training getSingleTraining(@PathVariable(name = "id") Long id) {
		return (Training) trainingRepository.findById(id).get();
	}

	// save a new training
	@PostMapping("/trainings")
	public void saveTrainings(@RequestBody Training training) {
		trainingRepository.save(training);
	}

	@DeleteMapping("/trainings/{id}")
	public void deleteTraining(@PathVariable(name = "id") Long id) {
		trainingRepository.deleteById(id);
	}
}
