package com.hardik.seaminaction.action;

import com.hardik.seaminaction.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("courseList")
public class CourseList extends EntityQuery<Course> {

	private static final String EJBQL = "select course from Course course";

	private static final String[] RESTRICTIONS = {
			"lower(course.description) like lower(concat(#{courseList.course.description},'%'))",
			"lower(course.designer) like lower(concat(#{courseList.course.designer},'%'))",
			"lower(course.fairways) like lower(concat(#{courseList.course.fairways},'%'))",
			"lower(course.greens) like lower(concat(#{courseList.course.greens},'%'))",
			"lower(course.name) like lower(concat(#{courseList.course.name},'%'))",};

	private Course course = new Course();

	public CourseList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Course getCourse() {
		return course;
	}
}
