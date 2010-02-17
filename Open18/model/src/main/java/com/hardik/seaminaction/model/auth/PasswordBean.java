package com.hardik.seaminaction.model.auth;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.intercept.BypassInterceptors;

/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Sep 12, 2009
 * Time: 8:51:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Name("passwordBean")
@BypassInterceptors
public class PasswordBean {
    private String password;
    private String confirm;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public boolean verify() {
        return (null != confirm ) && (confirm.equals(password));
    }
}
