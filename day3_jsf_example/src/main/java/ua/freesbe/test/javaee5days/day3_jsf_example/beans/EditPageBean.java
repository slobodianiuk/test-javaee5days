package ua.freesbe.test.javaee5days.day3_jsf_example.beans;

import com.sun.javafx.scene.layout.region.Margins;
import org.primefaces.model.DualListModel;
import ua.freesbe.test.javaee5days.day1_jpa_example.model.Patient;
import ua.freesbe.test.javaee5days.day1_jpa_example.model.Pills;
import ua.freesbe.test.javaee5days.day2_ejb_example.service.PatientService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class EditPageBean {

    @EJB
    private PatientService patientService;
    private Patient patient;
    private DualListModel<Pills> pillsDualListModel;
    private Converter pillsConverter;

    @PostConstruct
    public void init() {
        List<Pills> pillsList = new ArrayList<Pills>();
        pillsList.add(new Pills("Aspirin"));
        pillsList.add(new Pills("Vicodin"));
        pillsList.add(new Pills("Abatacept"));
        pillsList.add(new Pills("Gadodiamide"));
        pillsList.add(new Pills("Asparcam"));

        patient = (Patient) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("patient");
        if (patient == null) {
            patient = new Patient();
        }

        pillsDualListModel = new DualListModel<Pills>(pillsList, patient.getPatientsPills() == null
                ? new ArrayList<Pills>() : patient.getPatientsPills());

        pillsConverter = new Converter() {
            public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
                for (Pills p : getPillsDualListModel().getSource()) {
                    if (p.getTitle().equalsIgnoreCase(s)) {
                        return p;
                    }
                }
                return null;
            }

            public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
                return (String) o;
            }
        };
    }

    public void save() throws IOException {
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("patient") == null) {
            patientService.savePatient(patient);
        } else {
            patientService.merge(patient);
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("patient", null);

        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.sendRedirect("index.xhtml");
    }

    public Converter getPillsConverter() {
        return pillsConverter;
    }

    public void setPillsConverter(Converter pillsConverter) {
        this.pillsConverter = pillsConverter;
    }

    public DualListModel<Pills> getPillsDualListModel() {
        return pillsDualListModel;
    }

    public void setPillsDualListModel(DualListModel<Pills> pillsDualListModel) {
        this.pillsDualListModel = pillsDualListModel;
    }

    public Patient getPatient() {
        return patient;
    }
}
