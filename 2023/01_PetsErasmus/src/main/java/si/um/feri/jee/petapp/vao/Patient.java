package si.um.feri.jee.petapp.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import javax.print.Doc;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    private String details;
    @ManyToOne
    private Doctor doctor;

    public Patient(String name, String surname, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Patient(String name, String surname, String email, LocalDate dateOfBirth, String details, Doctor doctor) {
        this(name, surname, email, dateOfBirth);
        this.details = details;
        this.doctor = doctor;
    }

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", details='" + details + '\'' +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}
