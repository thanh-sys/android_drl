package vnu.uet.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vnu.uet.trainingpoint.enitty.Classes;
import vnu.uet.trainingpoint.enitty.Consultant;
import vnu.uet.trainingpoint.model.dto.ClassesDTO;
import vnu.uet.trainingpoint.repository.ClassesRepository;
import vnu.uet.trainingpoint.repository.ConsultantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesService {

    private ClassesRepository classesRepository;

    private ConsultantRepository consultantRepository;

    @Autowired
    public void setConsultantRepository(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    @Autowired
    public void setClassesRepository(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    public Optional<Classes> findByUsernameConsultant(String username) {
        return classesRepository.findByUsernameConsultant(username);
    }

    public ResponseEntity<ClassesDTO> find(String name) {
        Optional<Classes> classesOptional = classesRepository.getByName(name);
        return classesOptional.map(classes -> new ResponseEntity<>(
                new ClassesDTO(
                        classes.getName(),
                        classes.getConsultant().getId()
                ), HttpStatus.OK
        )).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<ClassesDTO> add(ClassesDTO classesDTO) {
        if (!classesRepository.getByName(classesDTO.getName()).isPresent()) {
            //kiểm tra tồn tại, nếu chưa tồn tại lớp này trong DB -> new Classes
            Classes classes = new Classes();
            classes.setName(classesDTO.getName());

            Optional<Consultant> consultant = consultantRepository.findById(classesDTO.getConsultantId());
//            System.out.println(consultant);
            consultant.ifPresent(classes::setConsultant); //thêm thông tin cố vấn học tập nếu có

            //lưu vào DB
            classesRepository.save(classes);
            return new ResponseEntity<>(new ClassesDTO(classes.getName(), classes.getConsultant().getId()), HttpStatus.OK);
        }
        return ResponseEntity.status(400).build();
    }

    public ResponseEntity<ClassesDTO> update(String name, ClassesDTO classesDTO) {
        Optional<Classes> classesOptional = classesRepository.getByName(name);
        // query trong DB xem có đúng là có lớp này hay không -> nếu không return HttpStatus.NOT_FOUND
        return classesOptional.map(classes -> {
            Optional<Consultant> consultant = consultantRepository.findById(classesDTO.getConsultantId());
            consultant.ifPresent(classes::setConsultant); //nếu tồn tại thì set Consultant

            classes.setName(classesDTO.getName());
            //lưu lại xuống DB
            classesRepository.save(classes);
            //return tên DTO mới check xem có thay đổi đúng k>
            return new ResponseEntity<>(new ClassesDTO(classes.getName(), classes.getConsultant().getId())
                    , HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<ClassesDTO> delete(String name) {
        Optional<Classes> classesOptional = classesRepository.getByName(name);
        return classesOptional.map(classes -> {
            classesRepository.delete(classes);
            return new ResponseEntity<>(
                    new ClassesDTO(classes.getName(), classes.getConsultant().getId()), HttpStatus.OK
            );
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
