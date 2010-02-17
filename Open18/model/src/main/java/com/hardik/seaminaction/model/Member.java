package com.hardik.seaminaction.model;


import org.hibernate.validator.NotNull;
import org.hibernate.validator.Length;
import org.hibernate.validator.Email;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Sep 12, 2009
 * Time: 8:15:58 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MEMBER",
       uniqueConstraints = {
               @UniqueConstraint(columnNames = "username"),
               @UniqueConstraint(columnNames = "email_address")
       }
)
public  abstract class Member implements Serializable {
    private long id;
    private String username;
    private String passwordHash;
    private String emailAddress;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    @NotNull
    @Length(min = 6)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Column(name = "password_hash",nullable = false)
    @NotNull
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Column(name = "email_address", nullable = false)
    @NotNull
    @Email
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
