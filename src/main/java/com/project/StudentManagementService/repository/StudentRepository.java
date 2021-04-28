package com.project.StudentManagementService.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.StudentManagementService.domain.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Serializable>{

	@Query(value="select s from Student s where s.firstName like %:firstName% and s.lastName like %:lastName%")
	public List<Student> searchStudents(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
