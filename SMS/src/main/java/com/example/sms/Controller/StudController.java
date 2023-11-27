package com.example.sms.Controller;

import com.example.sms.Model.Student;
import com.example.sms.Service.StudServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/SMS")
@RequiredArgsConstructor
public class StudController {

    private final StudServ studServ;

    //Get
    @GetMapping("/get")
    public ResponseEntity getStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studServ.getStudents());
    }


    //add
    @PostMapping("/add")
    public ResponseEntity addStud(@Valid @RequestBody Student studServ1, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        studServ.addStud(studServ1);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Add ");
    }


    //Put
    @PutMapping("/update/{id}")
    public ResponseEntity updStud(@PathVariable String id, @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdate = studServ.updStud(id, student);
        if (isUpdate)
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Update");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!");

    }


    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleStud(@PathVariable String id) {

        boolean isDetele = studServ.delStud(id);
        if (isDetele)
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Delete");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!");


    }

    @GetMapping("/searchNam/{name}")
    public  ResponseEntity studSrarch(String name){



        return  ResponseEntity.status(HttpStatus.OK).body(studServ.studSrarch(name));
    }

}
