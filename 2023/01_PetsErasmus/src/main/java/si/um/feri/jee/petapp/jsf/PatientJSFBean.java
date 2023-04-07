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
	private Patient patient = new Patient();
	private int doctorId;
	private int patientId;

	public List<Patient> findAll() {

		System.out.println(this.doctorId);
		return patientDAO.findAll();
	}

	public List<Patient> findAllWithoutDoctor() {
		return patientsWithoutDoctor.findAllWithoutDoctor();
	}

	public void savePatient() {
		System.out.println("patient save");
		LocalDate date = null;

		//if (dateOfBirth != null) {
		//	date = dateOfBirth.toInstant()
		//			.atZone(ZoneId.systemDefault())
		//			.toLocalDate();
		//}
		patient.setDoctor(doctorDAO.find(doctorId));
		patientDAO.save(patient);
		resetValues();
	}

	public void edit() {
		patient.setDoctor(doctorDAO.find(doctorId));
		patientDAO.edit(patient);
	}

	public void deletePatient(int id) {
		patientDAO.delete(id);
	}

	private void resetValues () {
		patient = new Patient();
		doctorId = Integer.MIN_VALUE;
	}

	public int getId() {
		return id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

}
