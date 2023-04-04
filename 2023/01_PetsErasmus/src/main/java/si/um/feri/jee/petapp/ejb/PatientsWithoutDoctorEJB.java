package si.um.feri.jee.petapp.ejb;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import si.um.feri.jee.petapp.dao.PatientDAO;
import si.um.feri.jee.petapp.vao.Patient;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class PatientsWithoutDoctorEJB implements PatientsWithoutDoctor{

    @EJB
    private PatientDAO patientDAO;

    @Override
    public List<Patient> findAllWithoutDoctor() {
        return patientDAO.findAll().stream()
                .filter(patient ->
                        patient.getDoctor() == null)
                .collect(Collectors.toList());
    }
}
