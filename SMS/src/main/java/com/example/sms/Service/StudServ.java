package com.example.sms.Service;

import com.example.sms.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudServ {
    ArrayList<Student> students=new ArrayList<>();

//Get
public ArrayList<Student>getStudents(){
    return students;
}

//Post
public void addStud(Student student){
    students.add(student);

}

//Put
public boolean updStud(String id,Student student){
    for (int i = 0; i <students.size() ; i++) {
        if (students.get(i).getID().equals(id)){
            students.set(i,student);
        return  true;
        }
    }
return false;
}


//Delete
    public  boolean delStud(String id){
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getID().equals(id)){
                students.remove(i);
            return true;
            }
        }
return  false;
}

//Search name
    public void studSrarch(String name){
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getName().equals(name))
                students.get(i);
        }
        }

}
