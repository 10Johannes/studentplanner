package com.immr.studentplanner.model;

public class Professor {
    private int professorID;
    private String professorName;
    private String professorPhone;
    private String professorEmail;
    private int courseID;

    public Professor() {

    }

    public Professor(String professorName, String professorPhone, String professorEmail, int courseID){
        this.professorName = professorName;
        this.professorPhone = professorPhone;
        this.professorEmail = professorEmail;
        this.courseID = courseID;
    }


    public Professor(int professorID, String professorName, String professorPhone, String professorEmail){
        this.professorID = professorID;
        this.professorName = professorName;
        this.professorPhone = professorPhone;
        this.professorEmail = professorEmail;
    }


    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorPhone() {
        return professorPhone;
    }

    public void setProfessorPhone(String professorPhone) {
        this.professorPhone = professorPhone;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}