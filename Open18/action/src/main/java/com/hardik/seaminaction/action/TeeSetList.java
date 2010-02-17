package com.hardik.seaminaction.action;

import com.hardik.seaminaction.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("teeSetList")
public class TeeSetList extends EntityQuery<TeeSet> {

	private static final String EJBQL = "select teeSet from TeeSet teeSet";

	private static final String[] RESTRICTIONS = {
			"lower(teeSet.color) like lower(concat(#{teeSetList.teeSet.color},'%'))",
			"lower(teeSet.name) like lower(concat(#{teeSetList.teeSet.name},'%'))",};

	private TeeSet teeSet = new TeeSet();

	public TeeSetList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TeeSet getTeeSet() {
		return teeSet;
	}
}
