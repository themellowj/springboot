package net.project.springboot.controller;

import net.project.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Justin","McGriff");

        return ResponseEntity.ok().header("custom-header", "test").body(student);
    }
    //http://localhost:8080/student
/*    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1,"Justin","McGriff");

        return student;
    }
 */
    @GetMapping("students")
    public List<Student> Students(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Justin","McGriff"));
        students.add(new Student(2,"Jack","Jones"));
        students.add(new Student(3,"Daniel","Jim"));
        return students;
    }

    //Spring BOOT REST API with Path Variable
    //http://localhost:8080/student/1
    @GetMapping("student/{id}/{first-name}/{last-name}")
    public  Student studentPathvariable(@PathVariable("id") int studentId,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName){
        return new Student(studentId,firstName,lastName);
    }

    //Spring BOOT with Request Param
    //http://localhost:8080/student/query
    @GetMapping("student/query")
    public  Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName,@RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }

    //Handling HTTP Post Request - creating new resource
    //http://localhost:8080/student/create
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;

    }

    //Handling HTTP PUT Request - updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Handling HTTP Delete Request - delete existing resource
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student delete successfully!";

    }

}
