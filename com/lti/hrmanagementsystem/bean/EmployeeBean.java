package com.lti.hrmanagementsystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Employee")
@Table(name = "Employee")
public class EmployeeBean {
	@Id
	@GeneratedValue(generator = "empidGenerator")
	@GenericGenerator(name = "empidGenerator", strategy = "com.lti.hrmanagementsystem.utils.EmployeeIdGenerator")
	private String psno;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String doj;
	private String address;
	private String phoneno;
	private float percent10;
	private String board10;
	private float percent12;
	private String board12;
	private float percentGrad;
	private String degree;
	private String university;
	private String branch;
	private String projectId;
	private String skills;
	private String answer;
	
	public String getPsno() {
		return psno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public float getPercent10() {
		return percent10;
	}

	public void setPercent10(float percent10) {
		this.percent10 = percent10;
	}

	public String getBoard10() {
		return board10;
	}

	public void setBoard10(String board10) {
		this.board10 = board10;
	}

	public float getPercent12() {
		return percent12;
	}

	public void setPercent12(float percent12) {
		this.percent12 = percent12;
	}

	public String getBoard12() {
		return board12;
	}

	public void setBoard12(String board12) {
		this.board12 = board12;
	}

	public float getPercentGrad() {
		return percentGrad;
	}

	public void setPercentGrad(float percentGrad) {
		this.percentGrad = percentGrad;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
