package com.example.sms.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotNull(message = "Please Enter your ID \n")
   @Size(min = 2,message = "Sould be your Id more then 2 \n")
    @Pattern(regexp = "^\\d{10}")
    private String ID;


    @NotNull(message = "Please Enter your Name \n")
   @Size(min = 2,message = "Sould be your name more then 2 \n")
    @Pattern(regexp = "^[A-zA-Z]+$")
    private String name;


    @NotNull(message = "Please Enter your age \n")
   @Positive(message = "Enter your age positive")
    private String age;



    @NotNull(message = "Please Enter your Major \n")
    @Size(min = 2,message = "Sould be your name Major then 2 \n")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String major;




}
