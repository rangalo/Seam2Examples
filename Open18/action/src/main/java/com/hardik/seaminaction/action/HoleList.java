package com.hardik.seaminaction.action;

import com.hardik.seaminaction.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("holeList")
public class HoleList extends EntityQuery<Hole> {

	private static final String EJBQL = "select hole from Hole hole";

	private static final String[] RESTRICTIONS = {"lower(hole.name) like lower(concat(#{holeList.hole.name},'%'))",};

	private Hole hole = new Hole();

	public HoleList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Hole getHole() {
		return hole;
	}
}
