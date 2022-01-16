package com.mockpage.schoolwebapp.parentportal.parent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="parent")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Pattern(regexp = "^[a-zA-Z]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Firstname cannot be empty")
	@Size(min=2, message = "Firstname must be more than 2 characters")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Lastname cannot be empty")
	@Size(min=2,message = "Lastname cannot be less than 2 characters")
	private String lastName;
	@Pattern(regexp = "^[a-zA-Z]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Student name cannot be empty")
	@Size(min=2,message = "Student name cannot be less than 2 characters")
	private String studentName;
	@NotEmpty(message = "Student Id cannot be empty")
	private String studentId;
	@NotEmpty(message = "Email is Mandatory")
	@Email(message = "Invalid email")
	private String email;
	@NotBlank(message = "Passowrd cannot be empty")
	@Size(min=8,max=16, message="password must be 8 to 16 characters length!")
	private String password;
	@AssertTrue(message="please check this before you proceed")
	private boolean checked;

	public Parent() {
	}


	public Parent(
			@Pattern(regexp = "^[a-zA-Z]{2,40}", message = "Must contain only letters") @NotBlank(message = "Firstname cannot be empty") @Size(min = 2, message = "Firstname must be more than 2 characters") String firstName,
			@Pattern(regexp = "^[a-zA-Z]{2,40}", message = "Must contain only letters") @NotBlank(message = "Lastname cannot be empty") @Size(min = 2, message = "Lastname cannot be less than 2 characters") String lastName,
			@Pattern(regexp = "^[a-zA-Z]{2,40}", message = "Must contain only letters") @NotBlank(message = "Student name cannot be empty") @Size(min = 2, message = "Student name cannot be less than 2 characters") String studentName,
			@NotEmpty(message = "Student Id cannot be empty") String studentId,
			@NotEmpty(message = "Email is Mandatory") @Email(message = "Invalid email") String email,
			@NotBlank(message = "Passowrd cannot be empty") @Size(min = 8, max = 16, message = "password must be 8 to 16 characters length!") String password,
			@AssertTrue(message = "please check this before you proceed") boolean checked) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentName = studentName;
		this.studentId = studentId;
		this.email = email;
		this.password = password;
		this.checked = checked;
	}


	@Override
	public String toString() {
		return "Parent [firstName=" + firstName + ", lastName=" + lastName + ", studentName="
				+ studentName + ", studentId=" + studentId + ", email=" + email + ", password=" + password + ", checked=" + checked + "]";
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
}
