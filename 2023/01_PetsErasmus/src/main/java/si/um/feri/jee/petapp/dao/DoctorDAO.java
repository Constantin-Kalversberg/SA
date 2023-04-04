package si.um.feri.jee.petapp.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.jee.petapp.vao.Doctor;
import si.um.feri.jee.petapp.vao.Patient;

import java.util.List;

@Local
@Stateless
public class DoctorDAO {
    @PersistenceContext
    EntityManager em;

    public void create(Doctor doctor) {
        System.out.println("Adding new doctor ");
        em.persist(doctor);
        System.out.println(em.createQuery("select p from Doctor p").getResultList().size());
    }

    public List<Doctor> findAll() {
        List<Doctor> list = (List<Doctor>) em.createQuery("select p from Doctor p").getResultList();
        System.out.println(list.size());
        return list;
    }

    public boolean delete (int id) {
        em.remove(this.find(id));
        return true;
    }

    public Doctor find(int id) {
        return em.find(Doctor.class, id);
    }

}
