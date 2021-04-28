package com.project.StudentManagementService.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.StudentManagementService.domain.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Serializable>{

	@Query(value="select c from Course c where c.name like %:name% and c.description like %:description%")
	public List<Course> searchCourses(@Param("name") String name, @Param("description") String description);
}
