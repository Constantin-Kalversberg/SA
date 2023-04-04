package si.um.feri.jee.petapp.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.petapp.dao.DoctorDAO;
import si.um.feri.jee.petapp.dao.PatientDAO;
import si.um.feri.jee.petapp.ejb.PatientsWithoutDoctor;
import si.um.feri.jee.petapp.vao.Doctor;
import si.um.feri.jee.petapp.vao.Patient;

import javax.print.Doc;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named("patient")
@SessionScoped
public class PatientJSFBean implements Serializable {

	private static final long serialVersionUID = 8921711252052520843L;

	@EJB
	private PatientDAO patientDAO;

	@EJB
	private DoctorDAO doctorDAO;

	@EJB
	private PatientsWithoutDoctor patientsWithoutDoctor;

	private int id;
	private String name;
	private String surname;
	private String email;
	private Date dateOfBirth;
	private String details;
	private int doctor;

	public List<Patient> findAll() {

		System.out.println(this.doctor);
		return patientDAO.findAll();
	}

	public List<Patient> findAllWithoutDoctor() {
		return patientsWithoutDoctor.findAllWithoutDoctor();
	}

	public void savePatient() {
		System.out.println("patient save");
		LocalDate date = null;

		if (dateOfBirth != null) {
			date = dateOfBirth.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();
		}
		patientDAO.create(name, surname, email, date, details, doctorDAO.find(doctor));
		resetValues();
	}

	public void deletePatient(int id) {
		patientDAO.delete(id);
	}
	private void resetValues () {
		name = null;
		surname = null;
		email = null;
		dateOfBirth = null;
		details = null;
		doctor = Integer.MIN_VALUE;
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
		System.out.println("sadaf");
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public PatientDAO getPatientDAO() {
		return patientDAO;
	}

	public void setPatientDAO(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getDoctor() {
		return doctor;
	}

	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}

}
