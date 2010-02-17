package com.hardik.seaminaction;

import org.jboss.seam.annotations.exception.HttpError;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Sep 28, 2009
 * Time: 10:23:42 PM
 * To change this template use File | Settings | File Templates.
 */

@HttpError(errorCode = HttpServletResponse.SC_NOT_FOUND)
public class ProfileNotFoundException  extends RuntimeException {
    public ProfileNotFoundException(Long id) {
        super(null == id ? "No profile was requested" : "The requested profile does not exist: " + id);
    }
}
