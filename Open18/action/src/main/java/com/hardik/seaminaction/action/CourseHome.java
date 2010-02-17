package com.hardik.seaminaction.action;

import com.hardik.seaminaction.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("courseHome")
public class CourseHome extends EntityHome<Course> {

	@In(create = true)
	FacilityHome facilityHome;

	public void setCourseId(Long id) {
		setId(id);
	}

	public Long getCourseId() {
		return (Long) getId();
	}

	@Override
	protected Course createInstance() {
		Course course = new Course();
		return course;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Facility facility = facilityHome.getDefinedInstance();
		if (facility != null) {
			getInstance().setFacility(facility);
		}
	}

	public boolean isWired() {
		if (getInstance().getFacility() == null)
			return false;
		return true;
	}

	public Course getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Hole> getHoles() {
		return getInstance() == null ? null : new ArrayList<Hole>(getInstance()
				.getHoles());
	}
	public List<Hole> getHoles_1() {
		return getInstance() == null ? null : new ArrayList<Hole>(getInstance()
				.getHoles_1());
	}
	public List<TeeSet> getTeeSets() {
		return getInstance() == null ? null : new ArrayList<TeeSet>(
				getInstance().getTeeSets());
	}
	public List<TeeSet> getTeeSets_1() {
		return getInstance() == null ? null : new ArrayList<TeeSet>(
				getInstance().getTeeSets_1());
	}

}
