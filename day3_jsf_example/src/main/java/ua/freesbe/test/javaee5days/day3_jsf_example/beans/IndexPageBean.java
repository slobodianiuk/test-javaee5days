package ua.freesbe.test.javaee5days.day3_jsf_example.beans;

import ua.freesbe.test.javaee5days.day1_jpa_example.model.Patient;
import ua.freesbe.test.javaee5days.day2_ejb_example.service.PatientService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@ManagedBean
@ViewScoped
public class IndexPageBean {
    @EJB
    private PatientService patientService;

    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    public void editPatient(Patient patient) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("patient", patient);

        HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
        response.sendRedirect("edit.xhtml");
    }

    public void removePatient(Patient patient) {
        patientService.removePatient(patient);
    }
}
