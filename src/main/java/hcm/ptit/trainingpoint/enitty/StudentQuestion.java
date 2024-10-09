package hcm.ptit.trainingpoint.enitty;


import lombok.*;
import java.time.LocalDateTime;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "question_1", columnDefinition = "TEXT", nullable = false)
    private String question1;

    @Column(name = "evidence_image_url_1", length = 255)
    private String evidenceImageUrl1;

    @Column(name = "question_2", columnDefinition = "TEXT", nullable = false)
    private String question2;

    @Column(name = "evidence_image_url_2", length = 255)
    private String evidenceImageUrl2;
    
    @Column(name = "question_3", columnDefinition = "TEXT", nullable = false)
    private String question3;

    @Column(name = "evidence_image_url_3", length = 255)
    private String evidenceImageUrl3;
    
    @Column(name = "question_4", columnDefinition = "TEXT", nullable = false)
    private String question4;

    @Column(name = "evidence_image_url_4", length = 255)
    private String evidenceImageUrl4;
     
    @Column(name = "question_5", columnDefinition = "TEXT", nullable = false)
    private String question5; 

    @Column(name = "evidence_image_url_5", length = 255)
    private String evidenceImageUrl5;
   
    

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
