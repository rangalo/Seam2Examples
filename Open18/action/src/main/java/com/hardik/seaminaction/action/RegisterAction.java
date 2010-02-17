package com.hardik.seaminaction.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.core.Events;
import org.jboss.seam.log.Log;
import org.jboss.seam.faces.FacesMessages;
import com.hardik.seaminaction.model.auth.PasswordBean;
import com.hardik.seaminaction.model.auth.PasswordManager;
import com.hardik.seaminaction.model.Golfer;

import javax.persistence.EntityManager;
import java.util.Date;

@Name("registerAction")
public class RegisterAction
{
    @Logger
    private Log log;
    
    @In
    protected FacesMessages facesMessages;
    @In
    protected EntityManager entityManager;
    @In(create = true)
    protected PasswordManager passwordManager;
    @In
    protected PasswordBean passwordBean;
    @In
    protected Golfer newGolfer;

    public String register()
    {
        // implement your business logic here
        log.debug("Registering golfer #{newGolfer.username}");
        String username = newGolfer.getUsername();
        if (!isUsernameAvailable(username)) {
            facesMessages.addToControl("username","Username is already taken");
            return null;
        }

        if(!passwordBean.verify())  {
            facesMessages.addToControl("Confirm", "Value doesn't match password");
            return null;
        }

        newGolfer.setPasswordHash(passwordManager.hash(passwordBean.getPassword()));
        newGolfer.setDateJoined(new Date());
        entityManager.persist(newGolfer);

        if(Events.exists()) {
        	Events.instance().raiseEvent("golferRegistered", newGolfer);
        }
        facesMessages.add("Welcome to the club, #{newGolfer.name}");        

        return "success";
    }

    public boolean isUsernameAvailable(String username) {
        return entityManager.createQuery("select m from Member m where m.username = :username ")
                .setParameter("username",username)
                .getResultList().size() == 0;


    }

    // add additional action methods

}
