package com.project.StudentManagementService.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchCourseCriteria {

	  @NotEmpty
	  @Size(min = 5)
	  private String name;

	  @NotEmpty
	  private String description;
}
