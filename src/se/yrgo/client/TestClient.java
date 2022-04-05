package se.yrgo.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/StudentManagement/webservice/students/4")
                .request().buildGet().invoke();

        Student student = response.readEntity(Student.class);
        System.out.println("Printing a specific student (id: 4):");
        System.out.println(student);
        System.out.println("");
        response.close();

        response = client.target("http://localhost:8080/StudentManagement/webservice/students")
                .request().buildGet().invoke();

        List<Student> students = response.readEntity(new GenericType<List<Student>>() {});
        System.out.println("Printing a List of students:");

        for (Student s : students) {
            System.out.println(s);
        }
        response.close();
    }

}
