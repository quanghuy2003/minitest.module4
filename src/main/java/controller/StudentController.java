package controller;

import model.Clasz;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.IClaszService;
import service.IStudentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClaszService claszService;

    @GetMapping("")
    public String list(Model model, String key) {
        List<Student> students;
        if (key != null) {
            students = (List<Student>) studentService.findByName(key);
        } else {
            students = (List<Student>) studentService.findAllByOrderByScoreAsc();
        }
        model.addAttribute("students", students);
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Student> student = studentService.findById(id);
        Student student1 = student.get();
        model.addAttribute("student", student1);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit1(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @ModelAttribute("clasz")
    public Iterable<Clasz> claszs() {
        return claszService.findAll();
    }

    @PostMapping("")
    public String score (Model model){
        List<Student> studens;
        studens= (List<Student>) studentService.findAllByScoreGreaterThan(8);
        model.addAttribute("students",studens);
        return "/list";
    }
}
