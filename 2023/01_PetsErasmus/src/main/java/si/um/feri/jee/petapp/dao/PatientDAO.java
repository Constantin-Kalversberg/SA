package si.um.feri.jee.petapp.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.jee.petapp.vao.Doctor;
import si.um.feri.jee.petapp.vao.Patient;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;

@Local
@Stateless
public class PatientDAO {

    @PersistenceContext
    EntityManager em;

    public void create(String name, String surname, String email, LocalDate dateOfBirth, String details, Doctor doctor) {
        //Doctor doc = new Doctor("peter", "peter", null, 12);
        Patient patient = new Patient(name, surname, email, dateOfBirth, details, doctor);
        System.out.println("Adding new pet "+patient);
        em.persist(patient);
        System.out.println(em.createQuery("select p from Patient p").getResultList().size());


    }

    public List<Patient> findAll() {
        List<Patient> list = (List<Patient>) em.createQuery("select p from Patient p").getResultList();
        System.out.println(list.size());
        return list;
    }

    public Patient find(int id) {
        return em.find(Patient.class, id);
    }

    public boolean delete (int id) {
        em.remove(this.find(id));
        return true;
    }

    public Patient edit (int id, String name, String surname, String email, LocalDate dateOfBirth, String details, Doctor doctor) {
        Patient patient = find(id);
        if(patient != null) {
            patient.setName(name);
            patient.setSurname(surname);
            patient.setDateOfBirth(dateOfBirth);
            patient.setDetails(details);
            patient.setDoctor(doctor);
        }
        return patient;
    }

}
