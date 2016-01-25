package ua.freesbe.test.javaee5days.day1_jpa_example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Bohdan on 1/21/2016.
 */
@Entity
@Access(AccessType.FIELD)
public class Patient {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String familyName;

    @Enumerated(EnumType.ORDINAL)
    Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOB")
    Date dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Pills> patientsPills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List getPatientsPills() {
        return patientsPills;
    }

    public void setPatientsPills(List patientsPills) {
        this.patientsPills = patientsPills;
    }
}
