package vnu.uet.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vnu.uet.trainingpoint.enitty.Classes;
import vnu.uet.trainingpoint.enitty.Consultant;
import vnu.uet.trainingpoint.enitty.Student;
import vnu.uet.trainingpoint.enitty.User;
import vnu.uet.trainingpoint.repository.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
public class InitDBService {

    private ConsultantRepository consultantRepository;

    private UserRepository userRepository;

    private ClassesRepository classesRepository;

    private EvaluationFormRepository evaluationFormRepository;

    private EvaluationFormOfClassPresidentRepository evaluationFormOfClassPresidentRepository;

    private StudentRepository studentRepository;

    @Autowired
    public void setConsultantRepository(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setClassesRepository(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    @Autowired
    public void setEvaluationFormRepository(EvaluationFormRepository evaluationFormRepository) {
        this.evaluationFormRepository = evaluationFormRepository;
    }

    @Autowired
    public void setEvaluationFormOfClassPresidentRepository(EvaluationFormOfClassPresidentRepository evaluationFormOfClassPresidentRepository) {
        this.evaluationFormOfClassPresidentRepository = evaluationFormOfClassPresidentRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostConstruct //được gọi khi khởi tạo hết các bean
    public void init() {

        // init consultant
        if (consultantRepository.count() == 0) {
            User userConsultant1 = new User("van.ntt", "ROLE_CONSULTANT");
            Consultant consultant1 = new Consultant("TS. Nguyễn Thị Thanh Vân", "Điện tử viễn thông", userConsultant1);
            userRepository.save(userConsultant1);
            consultantRepository.save(consultant1);

            User userConsultant2 = new User("vinh.nv", "ROLE_CONSULTANT");
            Consultant consultant2 = new Consultant("TS. Nguyễn Văn Vinh", "Công Nghệ Thông Tin", userConsultant2);
            userRepository.save(userConsultant2);
            consultantRepository.save(consultant2);

            User userConsultant3 = new User("vu.tm", "ROLE_CONSULTANT");
            Consultant consultant3 = new Consultant("TS. Trần Mai Vũ", "Công Nghệ Thông Tin", userConsultant3);
            userRepository.save(userConsultant3);
            consultantRepository.save(consultant3);

            System.out.println("init consultant");


            //init class
            Classes classes1 = new Classes("QH-2016-C-A-CLC1", consultant1);
            Classes classes2 = new Classes("QH-2017-C-B", consultant2);
            Classes classes3 = new Classes("QH-2017-C-C", consultant2);
            Classes classes4 = new Classes("QH-2017-C-D", consultant2);
            Classes classes5 = new Classes("QH-2018-C-D", consultant1);
            Classes classes6 = new Classes("QH-2019-C-D", consultant3);
            Classes classes7 = new Classes("QH-2020-C-D", consultant3);
            classesRepository.save(classes1);
            classesRepository.save(classes2);
            classesRepository.save(classes3);
            classesRepository.save(classes4);
            classesRepository.save(classes5);
            classesRepository.save(classes6);
            classesRepository.save(classes7);
            System.out.println("init classes");

            User user = new User("admin","ROLE_ADMIN");
            userRepository.save(user);
            //init student

            if (studentRepository.count() == 0) {

                User user1 = new User("16020046");
                userRepository.save(user1);
                Student student1 = new Student("Nguyễn Văn Mạnh", "Bac Giang",
                        LocalDate.of(1998, 7, 4),
                        "VN", user1, classes1);
                studentRepository.save(student1);

                User user2 = new User("16020046");
                userRepository.save(user2);
                Student student2 = new Student("Vũ Thị Thanh Lâm", "Thai Binh",
                        LocalDate.of(1998, 2, 22),
                        "VN", user2, classes1);
                studentRepository.save(student2);

                User user3 = new User("16020046"); //16020046	Nguyễn Văn Mạnh	7/4/1998
                userRepository.save(user3);
                Student student3 = new Student("Nguyễn Văn Mạnh", "Yên Bái",
                        LocalDate.of(1998, 4, 7),
                        "VN", user3, classes1);
                studentRepository.save(student3);

                User user4 = new User("16020047"); //16020047	Vũ Duy Mạnh	13/06/1998
                userRepository.save(user4);
                Student student4 = new Student("Vũ Duy Mạnh", "Hưng Yên",
                        LocalDate.of(1998, 6, 13),
                        "VN", user4, classes1);
                studentRepository.save(student4);


                User user5 = new User("16020062", "ROLE_PRESIDENT"); //16020062	Vũ Thị Thanh Lâm	22/02/1998
                userRepository.save(user5);
                Student student5 = new Student("Vũ Thị Thanh Lâm", "Thanh Hóa",
                        LocalDate.of(1998, 2, 22),
                        "VN", user5, classes1);
                studentRepository.save(student5);


                User user6 = new User("17020711"); //17020711	Nguyễn Thị Lệ Hà	18/01/1999
                userRepository.save(user6);
                Student student6 = new Student("Nguyễn Thị Lệ Hà", "Hà Nội",
                        LocalDate.of(1999, 1, 18),
                        "VN", user6, classes2);
                studentRepository.save(student6);


                User user7 = new User("17020031");//17020031	Nguyễn Thị Ngọc Lan	25/08/1999
                userRepository.save(user7);
                Student student7 = new Student("Nguyễn Thị Ngọc Lan", "Hà Nội",
                        LocalDate.of(1999, 8, 25),
                        "VN", user7, classes2);
                studentRepository.save(student7);


                User user8 = new User("17020962"); //17020962	Trần Hồng Phúc	2/1/1999
                userRepository.save(user8);
                Student student8 = new Student("Trần Hồng Phúc", "Hải Dương",
                        LocalDate.of(1999, 1, 2),
                        "VN", user8, classes2);
                studentRepository.save(student8);


                User user9 = new User("17020966", "ROLE_PRESIDENT"); //17020966	Lại Thị Thu Phương	5/11/1999
                userRepository.save(user9);
                Student student9 = new Student("Lại Thị Thu Phương", "Hải Phòng",
                        LocalDate.of(1999, 11, 5),
                        "VN", user9, classes2);
                studentRepository.save(student9);


                User user10 = new User("17021031"); // 17021031	Nguyễn Thành Thắng	22/01/1999
                userRepository.save(user10);
                Student student10 = new Student("Nguyễn Thành Thắng", "Hải Dương",
                        LocalDate.of(1999, 1, 22),
                        "VN", user10, classes2);
                studentRepository.save(student10);


                User user11 = new User("17020776"); //17020776	Trương Việt Hoàng	29/07/1999
                userRepository.save(user11);
                Student student11 = new Student("Trương Việt Hoàng", "Thái Bình",
                        LocalDate.of(1999, 7, 29),
                        "VN", user11, classes3);
                studentRepository.save(student11);


                User user12 = new User("17020809"); //17020809	Nguyễn Thị Ngọc Huyền	8/1/1999
                userRepository.save(user12);
                Student student12 = new Student("Nguyễn Thị Ngọc Huyền", "Hải Dương",
                        LocalDate.of(1999, 1, 8),
                        "VN", user12, classes3);
                studentRepository.save(student12);


                User user13 = new User("17020867"); //17020867	Trần Quang Long	3/12/1999
                userRepository.save(user13);
                Student student13 = new Student("Trần Quang Long", "Lạng Sơn",
                        LocalDate.of(1999, 12, 3),
                        "VN", user13, classes3);
                studentRepository.save(student13);


                User user14 = new User("17020876");  //17020876	Trần Thị Thúy Mai	4/10/1999
                userRepository.save(user14);
                Student student14 = new Student("Trần Thị Thúy Mai", "Thái Bình",
                        LocalDate.of(1999, 10, 4),
                        "VN", user14, classes3);
                studentRepository.save(student14);


                User user15 = new User("17021023", "ROLE_PRESIDENT"); //17021023	Lục Thị Thảo	11/11/1999
                userRepository.save(user15);
                Student student15 = new Student("Lục Thị Thảo", "Hà Nội",
                        LocalDate.of(1999, 11, 11),
                        "VN", user15, classes3);
                studentRepository.save(student15);


                User user16 = new User("17020670"); //17020670	Lê Quốc Đạt	1/12/1999
                userRepository.save(user16);
                Student student16 = new Student("Lê Quốc Đạt", "Thái Nguyên",
                        LocalDate.of(1999, 12, 1),
                        "VN", user16, classes4);
                studentRepository.save(student16);


                User user17 = new User("17020675"); //17020675	Nguyễn Chí Đạt	11/8/1999
                userRepository.save(user17);
                Student student17 = new Student("Nguyễn Chí Đạt", "Bắc Ninh",
                        LocalDate.of(1999, 8, 11),
                        "VN", user17, classes4);
                studentRepository.save(student17);


                User user18 = new User("17020724"); //17020724	Nguyễn Thu Hằng	4/4/1999
                userRepository.save(user18);
                Student student18 = new Student("Nguyễn Thu Hằng", "Bắc Giang",
                        LocalDate.of(1999, 4, 4),
                        "VN", user18, classes4);
                studentRepository.save(student18);


                User user19 = new User("17020753"); //17020753	Dương Văn Hòa	19/02/1999
                userRepository.save(user19);
                Student student19 = new Student("Dương Văn Hòa", "Hải Phòng",
                        LocalDate.of(1999, 2, 19),
                        "VN", user19, classes4);
                studentRepository.save(student19);


                User user20 = new User("17020770", "ROLE_PRESIDENT"); //17020770	Nguyễn Việt Hoàng	13/04/1999
                userRepository.save(user20);
                Student student20 = new Student("Nguyễn Việt Hoàng", "Hưng Yên",
                        LocalDate.of(1999, 4, 13),
                        "VN", user20, classes4);
                studentRepository.save(student20);


                User user21 = new User("18020251"); //18020251	Lê Mạnh Cường	17/05/2000
                userRepository.save(user21);
                Student student21 = new Student("Lê Mạnh Cường", "Hải Phòng",
                        LocalDate.of(2000, 5, 17),
                        "VN", user21, classes5);
                studentRepository.save(student21);


                User user22 = new User("18020640"); //18020640	Nguyễn Quốc Huy	27/08/2000
                userRepository.save(user22);
                Student student22 = new Student("Nguyễn Quốc Huy", "Hải Phòng",
                        LocalDate.of(2000, 8, 27),
                        "VN", user22, classes5);
                studentRepository.save(student22);


                User user23 = new User("18020661", "ROLE_PRESIDENT"); //18020661	Trần Nguyễn Quang Huy	5/12/2000
                userRepository.save(user23);
                Student student23 = new Student("Trần Nguyễn Quang Huy", "Hưng Yên",
                        LocalDate.of(2000, 12, 5),
                        "VN", user23, classes5);
                studentRepository.save(student23);


                User user24 = new User("18021124"); //18021124	Phạm Trọng Tấn	26/08/2000
                userRepository.save(user24);
                Student student24 = new Student("Phạm Trọng Tấn", "Hà Nội",
                        LocalDate.of(2000, 8, 26),
                        "VN", user24, classes5);
                studentRepository.save(student24);


                User user25 = new User("18021140");//18021140	Phạm Việt Thắng	20/10/2000
                userRepository.save(user25);
                Student student25 = new Student("Phạm Việt Thắng", "Hưng Yên",
                        LocalDate.of(2000, 10, 20),
                        "VN", user25, classes5);
                studentRepository.save(student25);


                User user26 = new User("19020218"); //19020218	Nguyễn Cao Bách	26/08/2001
                userRepository.save(user26);
                Student student26 = new Student("Nguyễn Cao Bách", "Hải Dương",
                        LocalDate.of(2001, 8, 26),
                        "VN", user26, classes6);
                studentRepository.save(student26);


                User user27 = new User("19020288", "ROLE_PRESIDENT");//19020288	Trương Xuân Hiếu	11/11/2001
                userRepository.save(user27);
                Student student27 = new Student("Trương Xuân Hiếu", "Hà Nội",
                        LocalDate.of(2001, 11, 11),
                        "VN", user27, classes6);
                studentRepository.save(student27);


                User user28 = new User("19020388"); //19020388	Võ Phùng Bảo Nhật	27/01/2000
                userRepository.save(user28);
                Student student28 = new Student("Võ Phùng Bảo Nhật", "Hà Nội",
                        LocalDate.of(2000, 1, 27),
                        "VN", user28, classes6);
                studentRepository.save(student28);


                User user29 = new User("19020403"); //19020403	Nguyễn Văn Quang	16/09/2001
                userRepository.save(user29);
                Student student29 = new Student("Nguyễn Văn Quang", "Hải Phòng",
                        LocalDate.of(2001, 9, 16),
                        "VN", user29, classes6);
                studentRepository.save(student29);


                User user30 = new User("19020458"); //19020458	Lê Cảnh Toàn	26/05/2001
                userRepository.save(user30);
                Student student30 = new Student("Lê Cảnh Toàn", "Hưng Yên",
                        LocalDate.of(2001, 5, 26),
                        "VN", user30, classes6);
                studentRepository.save(student30);


                User user31 = new User("20020357"); //20020357	Bùi Tuấn Anh	7/3/2002
                userRepository.save(user31);
                Student student31 = new Student("Bùi Tuấn Anh", "Hải Phòng",
                        LocalDate.of(2002, 3, 7),
                        "VN", user31, classes7);
                studentRepository.save(student31);


                User user32 = new User("20020359", "ROLE_PRESIDENT"); //20020359	Nguyễn Quang Anh	23/10/2002
                userRepository.save(user32);
                Student student32 = new Student("Nguyễn Quang Anh", "Hà Nội",
                        LocalDate.of(2002, 10, 23),
                        "VN", user32, classes7);
                studentRepository.save(student32);


                User user33 = new User("20020096"); //20020096	Nguyễn Thế Anh	17/11/2002
                userRepository.save(user33);
                Student student33 = new Student("Nguyễn Thế Anh", "Quảng Ninh",
                        LocalDate.of(2002, 11, 17),
                        "VN", user33, classes7);
                studentRepository.save(student33);


                User user34 = new User("20020360"); //20020360	Nguyễn Vũ Anh	9/6/2002
                userRepository.save(user34);
                Student student34 = new Student("Nguyễn Vũ Anh", "Hà Nội",
                        LocalDate.of(2002, 6, 9),
                        "VN", user34, classes7);
                studentRepository.save(student34);


                User user35 = new User("20020363");//20020363	Vũ Huy Anh	28/11/2002
                userRepository.save(user35);
                Student student35 = new Student("Vũ Huy Anh", "Quảng Ninh",
                        LocalDate.of(2002, 11, 20),
                        "VN", user35, classes7);
                studentRepository.save(student35);
                System.out.println("init student");
            }
        }
    }
}
