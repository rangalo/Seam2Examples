package com.hardik.seaminaction.action;

import com.hardik.seaminaction.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("facilityList")
public class FacilityList extends EntityQuery<Facility> {

	private static final String EJBQL = "select facility from Facility facility";

	private static final String[] RESTRICTIONS = {
			"lower(facility.address) like lower(concat(#{facilityList.facility.address},'%'))",
			"lower(facility.city) like lower(concat(#{facilityList.facility.city},'%'))",
			"lower(facility.country) like lower(concat(#{facilityList.facility.country},'%'))",
			"lower(facility.county) like lower(concat(#{facilityList.facility.county},'%'))",
			"lower(facility.description) like lower(concat(#{facilityList.facility.description},'%'))",
			"lower(facility.name) like lower(concat(#{facilityList.facility.name},'%'))",
			"lower(facility.phone) like lower(concat(#{facilityList.facility.phone},'%'))",
			"lower(facility.state) like lower(concat(#{facilityList.facility.state},'%'))",
			"lower(facility.type) like lower(concat(#{facilityList.facility.type},'%'))",
			"lower(facility.uri) like lower(concat(#{facilityList.facility.uri},'%'))",
			"lower(facility.zip) like lower(concat(#{facilityList.facility.zip},'%'))",};

	private Facility facility = new Facility();

	public FacilityList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Facility getFacility() {
		return facility;
	}
}
