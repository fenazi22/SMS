package com.example.sms.Controller;

import com.example.sms.Model.Teacher;
import com.example.sms.Service.TeachServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/SMS/Teach/")
@RequiredArgsConstructor
public class TeachController {
    private final TeachServ teachServ;




    //Get
    @GetMapping("/get")
    public ResponseEntity getTeach() {
        return ResponseEntity.status(HttpStatus.OK).body(teachServ.getTeach());
    }






    //add
    @PostMapping("/add")
    public ResponseEntity addStud(@Valid @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        teachServ.addTeach(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Add ");
    }






    //Put
    @PutMapping("/update/{id}")
    public ResponseEntity updTeach(@PathVariable String id, @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdate = teachServ.updTeach(id,teacher);
        if (isUpdate)
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Update");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!");

    }





    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleStud(@PathVariable String id) {

        boolean isDetele = teachServ.delTeach(id);
        if (isDetele)
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Delete");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!");


    }


    @GetMapping("/Search/{id}")
    public ResponseEntity SearchID(@PathVariable String id){



    return ResponseEntity.status(HttpStatus.OK).body(teachServ.SearchID(id));

}



}
