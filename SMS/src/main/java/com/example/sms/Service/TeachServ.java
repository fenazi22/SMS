package com.example.sms.Service;

import com.example.sms.Model.Teacher;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeachServ {
    ArrayList<Teacher> teachers=new ArrayList<>();


    //Get
    public ArrayList<Teacher>getTeach(){
        return teachers;
    }




    //Post
    public void addTeach(Teacher teach){
        teachers.add(teach);

    }



    //Put
    public boolean updTeach(String id,Teacher teach){
        for (int i = 0; i <teachers.size() ; i++) {
            if (teachers.get(i).getID().equals(id)){
                teachers.set(i,teach);
                return  true;
            }
        }
        return false;
    }




    //Delete
    public  boolean delTeach(String id){
        for (int i = 0; i <teachers.size() ; i++) {
            if (teachers.get(i).getID().equals(id)){
                teachers.remove(i);
                return true;
            }
        }
        return  false;
    }


    //Search

    public Teacher SearchID(String id ){
        for (int i = 0; i <teachers.size() ; i++) {
            if (teachers.get(i).getID().equals(i)){
                return teachers.get(i);

            }
        }

        return null;
    }

}
