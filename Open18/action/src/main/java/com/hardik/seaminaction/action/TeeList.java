package com.hardik.seaminaction.action;

import com.hardik.seaminaction.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("teeList")
public class TeeList extends EntityQuery<Tee> {

	private static final String EJBQL = "select tee from Tee tee";

	private static final String[] RESTRICTIONS = {};

	private Tee tee;

	public TeeList() {
		tee = new Tee();
		tee.setId(new TeeId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tee getTee() {
		return tee;
	}
}
