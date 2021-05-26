package vnu.uet.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vnu.uet.trainingpoint.model.dto.SemesterDTO;
import vnu.uet.trainingpoint.service.SemesterService;

@RestController
@RequestMapping("/semester")
public class SemesterController {

    private SemesterService semesterService;

    @Autowired
    public void setSemesterService(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping("/{semesterNo}")
    public ResponseEntity<SemesterDTO> get(@PathVariable Integer semesterNo){
        return semesterService.find(semesterNo);
    }

    @PostMapping("/add")
    public ResponseEntity<SemesterDTO> add(@RequestBody SemesterDTO semesterDTO){
        return semesterService.add(semesterDTO.getSemesterNo());
        //tạo học kỳ là tạo tất cả các phiếu đánh giá của sinh viên 4 khóa chính đang học tại trường
        // VD kì 184 là kỳ 1 của sv QH2017 -> K62
        //tạo phiếu đánh giá của SV các khóa QH2017, QH2016, QH2015, QH2014
    }

    // không có update, vì khi update kỳ nào-> sẽ ảnh hưởng đến sinh viên đang đánh giá điểm rèn luyện
    // ví dụ đang là kỳ 184 -> sinh viên đang đánh giá sẽ là QH-2017, QH-2016, QH-2015, QH-2014
    // nếu đổi thành 193 -> sinh viên đang đánh giá sẽ là QH-2020, QH-2019, QH-2018, QH-2017

    @DeleteMapping("/delete/{semesterNo}")
    public ResponseEntity<SemesterDTO> delete(@PathVariable Integer semesterNo){
        return semesterService.delete(semesterNo);
        //xóa học kỳ là xóa tất cả các phiếu đánh giá của sinh viên 4 khóa chính đang học tại trường
        // VD kì 184 là kỳ 1 của sv QH2017 -> K62
        //xóa phiếu đánh giá của SV các khóa QH2017, QH2016, QH2015, QH2014
    }
}
