package com.hardik.seaminaction.model;

/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Apr 19, 2010
 * Time: 5:46:17 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Weather {
    SUNNY("Sunny"), RAINY("Rainy");

    private final String label;

    Weather(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
