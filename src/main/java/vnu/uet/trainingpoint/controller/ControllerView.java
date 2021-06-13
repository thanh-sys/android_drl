package vnu.uet.trainingpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerView {

    @GetMapping("/demoUploadFile")
    public String indexUploadFile() {
        return "upload/upload";
    }
}
