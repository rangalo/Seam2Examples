package com.hardik.seaminaction.action;

import com.hardik.seaminaction.model.Golfer;
import com.hardik.seaminaction.model.Round;
import com.hardik.seaminaction.model.TeeSet;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.log.Log;

/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Apr 19, 2010
 * Time: 6:02:48 PM
 * To change this template use File | Settings | File Templates.
 */

@Name("roundHome")
public class RoundHome extends EntityHome<Round>{

    @In(required = false)
    private Golfer currentGolfer;

    @In(create = true)
    private TeeSetHome teeSetHome;

    @Override
    public String persist() {

        logger.info("Persist called");
        if (null != getInstance().getTeeSet() ) {
            logger.info("teeSet not null in persist");
        } else {
            logger.info("teeSet null in persist");            
        }
        String retVal =  super.persist();    //To change body of overridden methods use File | Settings | File Templates.
        return retVal;
    }

    @Logger
    private Log logger;

    public void wire() {

        logger.info("wire called");
        TeeSet teeSet = teeSetHome.getDefinedInstance();


        if (null != teeSet) {
            getInstance().setTeeSet(teeSet);
            logger.info("Successfully wired the teeSet instance with color: " + teeSet.getColor());
        }
    }

    public boolean isWired() {
        logger.info("is wired called");
        if(null == getInstance().getTeeSet()) {
            logger.info("wired teeSet instance is null, the button will be disabled !");
            return false;
        }
        else {
            logger.info("wired teeSet instance is NOT null, the button will be enabled !");
            logger.info("teeSet color: "+getInstance().getTeeSet().getColor());
            return true;
        }
    }

    @RequestParameter
    public void setRoundId(Long id) {
        super.setId(id);
    }

    @Override
    protected Round createInstance() {
        Round round = super.createInstance();
        round.setGolfer(currentGolfer);
        round.setDate(new java.sql.Date(System.currentTimeMillis()));
        return round;
    }
}
