package com.project.crudwithaop.controller;
import com.project.crudwithaop.dto.StudentDTO;
import com.project.crudwithaop.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    @RequestMapping("/api/students")
    @AllArgsConstructor
    public class StudentController {

        private final StudentService studentService;



        @GetMapping("/list")
        public String listStudents(Model model){
            List<StudentDTO> students=studentService.findAll();
            model.addAttribute("students",students);

            return "students/lists-students";

        }
        @GetMapping("/listforstudents")
        public String listStudentsForStudents(Model model){
            List<StudentDTO> students=studentService.findAll();
            model.addAttribute("students",students);

            return "students/list-students-for-students";

        }

        @GetMapping("/showFormForAdd")
        public String showFormForAdd(@ModelAttribute("student") StudentDTO studentDTO){
            return "students/student-form";
        }

        @GetMapping("/showFormForUpdate")
        public String showFormForUpdate(@RequestParam("studentId") Long id, Model model){
            StudentDTO studentDTO=studentService.findById(id);
            model.addAttribute("student",studentDTO);
            return "students/student-form";


        }
        @GetMapping("/delete")
        public String deleteStudent(@RequestParam("studentId") Long id){
            studentService.deleteById(id);
            return "redirect:/api/students/list";
        }

        @PostMapping("/save")
        public String saveStudent(@ModelAttribute("student") StudentDTO studentDTO){
            studentService.save(studentDTO);
            return "redirect:/api/students/list";

        }


}
