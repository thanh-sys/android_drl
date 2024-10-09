package hcm.ptit.trainingpoint.service;

import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.StudentQuestion;
import hcm.ptit.trainingpoint.repository.StudentQuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentQuestionService {
	
	private EvaluationFormService evaluationFormService;


	@Autowired
	public void setEvaluationFormService(EvaluationFormService evaluationFormService) {
		this.evaluationFormService = evaluationFormService;
	}

	
	@Autowired
	private StudentQuestionRepository fileDataRepository;

	private final String FOLDER_PATH = "C:\\Users\\Admin\\training_point\\src\\main\\resources\\static\\image\\";

	

	public String uploadImageToFileSystem(EvaluationForm evaluation, List<MultipartFile> files) throws IOException {
		
		EvaluationForm evaluationForm = evaluationFormService.findById(evaluation.getId());

		List<String> filePaths = new ArrayList<>();
	    
	    for (MultipartFile file : files) {
	        String filePath = FOLDER_PATH + file.getOriginalFilename();
	        file.transferTo(new File(filePath));
	        filePaths.add("/image/"+file.getOriginalFilename());
	    }

	    String filePathsString = String.join(",", filePaths);
//		File directory = new File(FOLDER_PATH);
		
//		if(!directory.exists())
//		{
//			System.out.println("khong co directory nay");
////			directory.mkdirs(); // Tạo thư mục nếu chưa tồn tại
//		}
//		System.out.print("TAO NE:" + evaluation.getStudentQuestion().getQuestion1());
		StudentQuestion fileData = fileDataRepository.save(StudentQuestion.builder()
				.question1(evaluation.getStudentQuestion().getQuestion1()).evidenceImageUrl1(filePathsString).question2("1")
				.question3("1").question4("1").question5("1").build());

		evaluationForm.setStudentQuestion(fileData);
		evaluationFormService.save(evaluationForm);
//		file.transferTo(new File(filePath));

		if (fileData != null) {
			return "file uploaded successfully : " + filePathsString;
		}
		return null;
	}

}