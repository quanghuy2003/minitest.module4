package controller;

import model.Clasz;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.IClaszService;
import service.IStudentService;

import java.io.File;
import java.io.IOException;
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
    public String edit1(Student student, @RequestParam MultipartFile image) {
        String fileName = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(),
                    new File("D:\\test\\" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        student.setImg(fileName);
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

//    @GetMapping("/upload")
//    public ModelAndView showCreateIMG() {
//        ModelAndView modelAndView = new ModelAndView("/createIMG");
//        return modelAndView;
//    }
//
//
//    @PostMapping("/show")
//    public ModelAndView saveIMG(MultipartFile image, String imageLink) {
//        String fileName = image.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(image.getBytes(),
//                    new File("/D:\\test\\/" + fileName)); // coppy ảnh từ ảnh nhận được vào thư mục quy định,
//            // đường dẫn ảo là /nhuanh/
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        ModelAndView modelAndView = new ModelAndView("/index2");
//        modelAndView.addObject("src", fileName);
//        modelAndView.addObject("srcImg", imageLink);
//        return modelAndView;
//    }

    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("student",new Student());
        return "/create";
    }
    @PostMapping("create")
    public String createProduct(Student student, @RequestParam MultipartFile image) {
        String fileName = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(),
                    new File("D:\\test\\" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        student.setImg(fileName);
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.remove(id);
        return "redirect:/students";
    }
}
