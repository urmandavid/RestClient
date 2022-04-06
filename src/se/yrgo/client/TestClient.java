package se.yrgo.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {
    /**
     * This is the TestClient for our REST application.
     * It contains code for making requests and getting responses from our server.
     *
     * The results from each response is printed to the terminal.
     */

    public static void main(String[] args) {

        //Updating a student (id: 2)
        Student updatedStudent = new Student();
        updatedStudent.setProgram("Music");
        updatedStudent.setAcademicYear(3);

        Entity sEntity = Entity.entity(updatedStudent,"application/JSON");

        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/StudentManagement/webservice/students/2")
                .request().buildPut(sEntity).invoke();

        System.out.println("Update status was " + response.getStatus());
        System.out.println(response.readEntity(String.class));
        System.out.println(" ");

        response.close();


        //Deleting a student, printing a response:
        response = client.target("http://localhost:8080/StudentManagement/webservice/students/3")
                .request().buildDelete().invoke();
        System.out.println("Delete status was " + response.getStatus());
        System.out.println(" ");

        response.close();


        //All students in a for loop:
        response = client.target("http://localhost:8080/StudentManagement/webservice/students")
                .request().buildGet().invoke();
        List<Student> students = response.readEntity(new GenericType<List<Student>>() {});
        System.out.println("Printing a List of students:");

        for (Student s : students) {
            System.out.println(s + ", Program: " + s.getProgram() + ", Academic year: " + s.getAcademicYear());
        }
        response.close();

    }

        /* Code for testing purposes:
        //Creating a student:
        //Client client = ClientBuilder.newClient();
        Student stud = new Student();
        stud.setFirstName("Lady");
        stud.setSurname("Justinia");
        stud.setProgram("Law");
        stud.setAcademicYear(4);

        Entity studEntity = Entity.entity(stud, "application/JSON");
        response = client.target("http://localhost:8080/StudentManagement/webservice/students")
                .request().buildPost(studEntity).invoke();

        System.out.println("Creating a new student:");
        System.out.println(response.readEntity(Student.class).getId());

        response.close();


        response = client.target("http://localhost:8080/StudentManagement/webservice/students/3")
                .request("application/JSON").buildGet().invoke();

        System.out.println(response.getHeaders().toString());
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));

        response.close();


        //Printing a specific student:
        response = client.target("http://localhost:8080/StudentManagement/webservice/students/3")
                .request().buildGet().invoke();

        Student student = response.readEntity(Student.class);
        System.out.println("Printing a specific student (id: 3):");
        System.out.println(student);

        response.close();
        */

}