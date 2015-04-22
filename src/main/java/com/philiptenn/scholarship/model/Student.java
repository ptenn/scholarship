package com.philiptenn.scholarship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * @author <a href="mailto:ptenn@users.noreply.github.com">Philip Tenn</a>
 */
@Entity
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "student_number")
    private Integer studentNumber;

    @Column(name = "created")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime created;

    @Column(name = "updated")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updated;

    /**
     * Get the Unique ID of the Student Model object
     * @return Unique ID of the Student Model object
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the Unique ID of the Student Model object
     * @param id Unique ID of the Student Model object
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the First Name of the Student
     * @return The First Name of the Student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the First Name of the Student
     * @param firstName The First Name of the Student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the Last Name of the Student
     * @return The Last Name of the Student
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Set the Last Name of the Student
     * @param lastName The Last Name of the Student
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    @PrePersist
    protected void onCreate() {
        created = new DateTime();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new DateTime();
    }

}
