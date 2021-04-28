package com.project.StudentManagementService.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class SearchCriteria {

	 
	  @NotEmpty
	  @Size(min = 5)
	  private String firstName;

	  @NotEmpty
	  private String lastName;

}
