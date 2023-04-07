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

    public Patient save(Patient patient) {
        //Doctor doc = new Doctor("peter", "peter", null, 12);
        System.out.println("Adding new pet "+patient);
        em.persist(patient);
        System.out.println(em.createQuery("select p from Patient p").getResultList().size());
        return patient;
    }

    public Patient edit(Patient patient) {
        Patient old = find(patient.getId());
        if (patient.getName() != null && !patient.getName().isEmpty())
            old.setName(patient.getName());
        if(patient.getSurname() != null && !patient.getSurname().isEmpty())
            old.setSurname(patient.getSurname());
        if(patient.getEmail() != null && !patient.getEmail().isEmpty())
            old.setEmail(patient.getEmail());
        if (patient.getDetails() != null && !patient.getDetails().isEmpty())
            old.setDetails(patient.getDetails());
        if(patient.getDoctor() != null)
            old.setDoctor(patient.getDoctor());
        return old;
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
