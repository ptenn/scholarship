package com.philiptenn.scholarship.controller;


import java.util.List;

import javax.validation.Valid;

import com.philiptenn.scholarship.exception.StudentNotFound;
import com.philiptenn.scholarship.model.Student;
import com.philiptenn.scholarship.service.StudentService;
import com.philiptenn.scholarship.validation.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author <a href="mailto:ptenn@users.noreply.github.com">Philip Tenn</a>
 */
@Controller
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentValidator studentValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(studentValidator);
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView newStudentPage() {
        ModelAndView mav = new ModelAndView("student/new", "student", new Student());
        return mav;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView createNewStudent(@ModelAttribute @Valid Student student,
                                      BindingResult result,
                                      final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("student/new");

        ModelAndView mav = new ModelAndView();
        String message = "New student "+student.getFirstName()+" " + student.getLastName() + " was successfully created.";

        studentService.create(student);
        mav.setViewName("redirect:/index.html");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView studentListPage() {
        ModelAndView mav = new ModelAndView("student/list");
        List<Student> studentList = studentService.findAll();
        mav.addObject("studentList", studentList);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editStudentPage(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("student/edit");
        Student student = studentService.findById(id);
        mav.addObject("student", student);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editStudent(@ModelAttribute @Valid Student student,
                                 BindingResult result,
                                 @PathVariable Integer id,
                                 final RedirectAttributes redirectAttributes) throws StudentNotFound {

        if (result.hasErrors())
            return new ModelAndView("student/edit");

        ModelAndView mav = new ModelAndView("redirect:/index.html");
        String message = "Student was successfully updated.";

        studentService.update(student);

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteStudent(@PathVariable Integer id,
                                   final RedirectAttributes redirectAttributes) throws StudentNotFound {

        ModelAndView mav = new ModelAndView("redirect:/index.html");

        Student student = studentService.delete(id);
        String message = "The student "+student.getFirstName()+" " + student.getLastName() + " was successfully deleted.";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

}
