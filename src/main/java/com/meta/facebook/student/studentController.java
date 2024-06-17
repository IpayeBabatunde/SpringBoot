package com.meta.facebook.student;

import com.meta.facebook.student.student;
import com.meta.facebook.student.studentDto;
import com.meta.facebook.student.studentResponseDto;
import com.meta.facebook.student.studentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

@RestController
public class studentController {

    private final com.meta.facebook.student.studentService studentService;

    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public studentResponseDto saveStudent(
       @Valid @RequestBody studentDto dto
    ) {
       return this.studentService.saveStudent(dto);

    }



    @GetMapping("/student")
    public List<student> findAllStudent() {

        return studentService.findAllStudent();

    }

    @GetMapping("/student/{student-id}")
    public student findStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return studentService.findStudentById(id);

    }
    @GetMapping("/student/search/{student-name}")
    public List<student> findStudentByName(
            @PathVariable ("student-name") String name
    ) {

        return studentService.findStudentByName(name);

    }

    @DeleteMapping ("/student/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ){
        studentService.delete(id);
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp){
            var errors = new HashMap<String, String>();
            exp.getBindingResult().getAllErrors()
                    .forEach(error -> {
                        var fieldName = ((FieldError) error).getField();
                        var errorMessage = error.getDefaultMessage();
                        errors.put(fieldName, errorMessage);
                    });
                return  new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
