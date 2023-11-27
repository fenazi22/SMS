package com.example.sms.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {



    @NotNull(message = "Please Enter your ID \n")
    @Size(min = 2,message = "Sould be your Id more then 2 \n")
    @Pattern(regexp = "^\\d{10}")
    private String ID;




    @NotNull(message = "Please Enter your Name \n")
    @Size(min = 2,message = "Sould be your name more then 2 \n")
    @Pattern(regexp = "^[A-zA-Z]+$")
    private String name;




    @NotNull(message = "Please Enter your Salare")
  @Positive(message = " Enter Postivive salarey")
    private  double salary;

}
