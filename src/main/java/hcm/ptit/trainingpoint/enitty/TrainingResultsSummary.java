package hcm.ptit.trainingpoint.enitty;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;



@Getter
@Setter
@Entity
@Data
@NoArgsConstructor

public class TrainingResultsSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "student_name", nullable = false)
	private String studentName;

	@Column(name = "student_id", nullable = false, unique = true)
	private String studentId;

	@Column(name = "class_name")
	private String className;

	@Column(name = "faculty")
	private String faculty;

	@Column(name = "semester")
	private String semester;

	@Column(name = "academic_year")
	private String academicYear;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "content_1")
	private int content1;

	@Column(name = "content_2")
	private int content2;

	@Column(name = "content_3")
	private int content3;

	@Column(name = "content_4")
	private int content4;

	@Column(name = "content_5")
	private int content5;

	@Column(name = "total_points")
	private int totalPoints;

	@Column(name = "classification")
	private String classification;

	@Column(name = "note")
	private String note;
	
	 public TrainingResultsSummary(String studentName, String studentId, String className, String faculty, String semester, String academicYear, LocalDate date, int content1, int content2, int content3, int content4, int content5, int totalPoints, String classification, String note) {
	        this.studentName = studentName;
	        this.studentId = studentId;
	        this.className = className;
	        this.faculty = faculty;
	        this.semester = semester;
	        this.academicYear = academicYear;
	        this.date = date;
	        this.content1 = content1;
	        this.content2 = content2;
	        this.content3 = content3;
	        this.content4 = content4;
	        this.content5 = content5;
	        this.totalPoints = totalPoints;
	        this.classification = classification;
	        this.note = note;
	    }

}