package si.um.feri.jee.petapp.rest;


import jakarta.ejb.EJB;
import java.util.Collection;
import java.util.logging.Logger;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import si.um.feri.jee.petapp.dao.PatientDAO;
import si.um.feri.jee.petapp.vao.Patient;

@Path("/patient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientRessource {

    @EJB
    PatientDAO patientDAO;

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/info")
    public String info() {
        return "OsebaResource";
    }

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Collection<Patient> allPatients() {
        return patientDAO.findAll();
    }

    @PUT
    public Patient editPatient(Patient patient) throws Exception {
        return patientDAO.edit(patient);
    }

    @POST
    public Patient addPatient(Patient patient) throws Exception {
        return patientDAO.save(patient);
    }
}