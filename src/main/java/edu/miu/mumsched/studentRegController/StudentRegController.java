package edu.miu.mumsched.studentRegController;

import edu.miu.mumsched.domain.Student;
import edu.miu.mumsched.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class StudentRegController {
    @Autowired
    StudentServiceInterface studentServiceInterface;
    @GetMapping("/")
    public String studentRegForm(@ModelAttribute("student")Student student, Model model){

        model.addAttribute(student);
        //System.out.println("student " + student);
        return "studentRegForm";

    }
     @PostMapping("/addStudent")
    public String registerStudent(@ModelAttribute("student") Student student,Model model){
  studentServiceInterface.save(student);
        model.addAttribute(studentServiceInterface.getStudentByEmail(student.getEmail()));

         return "addSuccessForm";
    }

}
