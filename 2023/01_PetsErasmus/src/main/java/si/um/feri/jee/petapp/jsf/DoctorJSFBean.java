package si.um.feri.jee.petapp.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.petapp.dao.DoctorDAO;
import si.um.feri.jee.petapp.dao.PatientDAO;
import si.um.feri.jee.petapp.ejb.PatientsWithoutDoctor;
import si.um.feri.jee.petapp.vao.Doctor;
import si.um.feri.jee.petapp.vao.Patient;

import java.io.Serializable;
import java.security.SecureRandomParameters;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named("doctor")
@SessionScoped
public class DoctorJSFBean implements Serializable {
    private static final long serialVersionUID = 8921711252052520843L;

    @EJB
    private DoctorDAO doctorDAO;

    private int id;
    private String name;
    private String surname;
    private String email;
    private int maxNumberOfPatients;

    public List<Doctor> findAll() {
        return doctorDAO.findAll();
    }

    public void saveDoctor() {
        LocalDate date = null;
        doctorDAO.create(new Doctor(name, surname, email, maxNumberOfPatients));
        resetValues();
    }

    public void deletePatient(int id) {
        doctorDAO.delete(id);
    }
    private void resetValues () {
        name = null;
        surname = null;
        email = null;
        maxNumberOfPatients = 0;
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

    public int getMaxNumberOfPatients() {
        return maxNumberOfPatients;
    }

    public void setMaxNumberOfPatients(int maxNumberOfPatients) {
        this.maxNumberOfPatients = maxNumberOfPatients;
    }
}
