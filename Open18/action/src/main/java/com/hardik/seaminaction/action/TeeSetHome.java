package com.hardik.seaminaction.action;

import com.hardik.seaminaction.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("teeSetHome")
public class TeeSetHome extends EntityHome<TeeSet> {

	@In(create = true)
	CourseHome courseHome;

	public void setTeeSetId(Long id) {
		setId(id);
	}

	public Long getTeeSetId() {
		return (Long) getId();
	}

	@Override
	protected TeeSet createInstance() {
		TeeSet teeSet = new TeeSet();
		return teeSet;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Course course = courseHome.getDefinedInstance();
		if (course != null) {
			getInstance().setCourse(course);
		}
	}

	public boolean isWired() {
		if (getInstance().getCourse() == null)
			return false;
		return true;
	}

	public TeeSet getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Tee> getTees() {
		return getInstance() == null ? null : new ArrayList<Tee>(getInstance()
				.getTees());
	}
	public List<Tee> getTees_1() {
		return getInstance() == null ? null : new ArrayList<Tee>(getInstance()
				.getTees_1());
	}

}
