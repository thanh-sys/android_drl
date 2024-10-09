package hcm.ptit.trainingpoint.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.TrainingResultsSummary;
import hcm.ptit.trainingpoint.repository.TrainingResultsSummaryRepository;
import hcm.ptit.trainingpoint.util.ExcelExportUtil;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TrainingResultsSummaryService {
	private TrainingResultsSummaryRepository trainingResultsSummaryRepository;
	
	public List<TrainingResultsSummary> exportTrainingResultsSummariesToExcel(HttpServletResponse response,String classes,String faculty,List<EvaluationForm> evaluationForm) throws IOException{
		List<TrainingResultsSummary> trainingResultsSummaries = trainingResultsSummaryRepository.findAll();
		ExcelExportUtil exportUtil = new ExcelExportUtil(trainingResultsSummaries);
		exportUtil.exportDataToExcel(response,classes,faculty,evaluationForm);
		
		return trainingResultsSummaries;
	}
}
