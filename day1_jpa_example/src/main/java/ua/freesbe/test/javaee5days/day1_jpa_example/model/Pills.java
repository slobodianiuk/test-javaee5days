package ua.freesbe.test.javaee5days.day1_jpa_example.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bohdan on 1/21/2016.
 */
@Entity
@Access(AccessType.FIELD)
public class Pills implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    Long id;

    String title;

    public Pills(String title) {
        this.title = title;
    }

    public Pills() {
    }
}
