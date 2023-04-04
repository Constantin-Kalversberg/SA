package si.um.feri.jee.petapp.ejb;

import jakarta.ejb.Remote;
import si.um.feri.jee.petapp.vao.Patient;

import java.util.List;

@Remote
public interface PatientsWithoutDoctor {
    public List<Patient> findAllWithoutDoctor();
}
