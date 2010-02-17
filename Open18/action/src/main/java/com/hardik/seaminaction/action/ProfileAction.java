package com.hardik.seaminaction.action;

import org.jboss.seam.annotations.*;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.ScopeType;
import com.hardik.seaminaction.ProfileNotFoundException;
import javax.persistence.EntityManager;
import com.hardik.seaminaction.model.Golfer;
import java.util.List;
import java.util.Random;


/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Sep 28, 2009
 * Time: 10:05:03 PM
 * To change this template use File | Settings | File Templates.
 */

@Name("profileAction")
@Scope(ScopeType.SESSION)
public class ProfileAction {
    @In
    protected EntityManager entityManager;

    @DataModelSelection
    @Out(required = false)
    protected Golfer selectedGolfer;

    @RequestParameter
    protected Long golferId;

    @DataModel(scope = ScopeType.PAGE)
    protected List<Golfer> newGolfers;

    protected int newGolferPoolSize = 25;
    protected int newGolferDisplaySize = 5;


    public String view() {

        return "/profile.xhtml";
    }

    public void load() {
        if (null != selectedGolfer ) {
            return;            
        }

        if (null != golferId && golferId > 0) {
            selectedGolfer = entityManager.find(Golfer.class, golferId);
        }
        if (null ==  selectedGolfer) {
            throw new ProfileNotFoundException(golferId);
        }
    }

    @SuppressWarnings("unchecked")
	@Factory("newGolfers")
    public void findGolfers() {
        newGolfers = entityManager.createQuery
                ("select g from Golfer g order by g.dateJoined desc")
                .setMaxResults(newGolferPoolSize)
                .getResultList();

        Random rnd  = new Random(System.currentTimeMillis());

        while(newGolfers.size() > newGolferDisplaySize) {
            newGolfers.remove(rnd.nextInt(newGolfers.size()));
        }
    }

}
