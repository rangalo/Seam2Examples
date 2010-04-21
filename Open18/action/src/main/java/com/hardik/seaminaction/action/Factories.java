package com.hardik.seaminaction.action;

import com.hardik.seaminaction.model.Round;
import com.hardik.seaminaction.model.Weather;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;

/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Apr 19, 2010
 * Time: 9:20:02 PM
 * To change this template use File | Settings | File Templates.
 */

@Name("factories")
public class Factories {

    @Factory(value = "weatherCategories",scope = ScopeType.EVENT)
    public Weather[] getWeatherCategories() {
        return Weather.values();
    }
    
    
}
