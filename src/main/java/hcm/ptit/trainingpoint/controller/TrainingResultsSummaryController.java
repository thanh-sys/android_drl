package hcm.ptit.trainingpoint.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.MyUserDetails;
import hcm.ptit.trainingpoint.model.dto.InputDTO;
import hcm.ptit.trainingpoint.service.ConsultantService;
import hcm.ptit.trainingpoint.service.EvaluationFormService;
import hcm.ptit.trainingpoint.service.TrainingResultsSummaryService;

@Controller
@RequestMapping("/excel")
public class TrainingResultsSummaryController {
	@Autowired
	private TrainingResultsSummaryService trainingResultsSummaryService;
	@Autowired
	private ConsultantService consultantService;
	@Autowired
	private EvaluationFormService evaluationFormService;
	
	
	@GetMapping("/export-to-excel/{classes}")
	public void exportToExcel(HttpServletResponse response ,@PathVariable String classes) throws IOException {
		
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=TrainingResultsSummary.xlsx";
		
		response.setHeader(headerKey, headerValue);
		
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String faculty = consultantService.getFacultyByUsername(user.getUsername());
		
		List<EvaluationForm> evaluationForm = evaluationFormService
				.findByCriteria(new InputDTO(null, 205, null, null, null, classes));
		
		trainingResultsSummaryService.exportTrainingResultsSummariesToExcel(response,classes,faculty,evaluationForm);
	}
}
