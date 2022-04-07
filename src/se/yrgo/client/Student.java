package se.yrgo.client;

public class Student {
    /**
     * This Student-class belongs to the REST-client application.
     * It is used when creating Student objects.
     *
     * The class contains fields corresponding to each student.
     * It also contains Getters, Setters and a toString-method.
     */

    private int id;
    private String firstName;
    private String surname;
    private String program;
    private int academicYear;

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String toString() {
        return "Student (" + this.id + ") - " + this.firstName + " " + this.surname;
    }

}
