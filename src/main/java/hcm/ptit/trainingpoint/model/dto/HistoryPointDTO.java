package hcm.ptit.trainingpoint.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryPointDTO {

    private String year;
    private String semester;
    private String graded;
    private int totalPoint;
    private String status;
    private String username;
	public HistoryPointDTO(String year, String semester, String graded, int totalPoint, String status) {
		
		this.year = year;
		this.semester = semester;
		this.graded = graded;
		this.totalPoint = totalPoint;
		this.status = status;
	}
    
    

}
