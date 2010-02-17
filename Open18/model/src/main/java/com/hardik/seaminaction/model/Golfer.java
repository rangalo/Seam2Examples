package com.hardik.seaminaction.model;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.ScopeType;


@Entity
@PrimaryKeyJoinColumn(name = "MEMBER_ID")
@Name("newGolfer")
@Scope(org.jboss.seam.ScopeType.EVENT)
public class Golfer extends Member {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateJoined;
    private Date dateOfBirth;
    private String location;

    @Column (name = "first_name", nullable = false)
    @NotNull
    @Length(max = 40)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column (name = "last_name", nullable = false)
    @NotNull
    @Length(max = 40)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Enumerated (EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "joined", nullable = false, updatable = false)
    @NotNull
    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Transient
    public String getName() {
        return firstName + " "  + lastName;
    }
}
