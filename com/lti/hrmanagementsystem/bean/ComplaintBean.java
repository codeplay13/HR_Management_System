package com.lti.hrmanagementsystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "complaint")
@Table(name = "complaint")
public class ComplaintBean {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String complaintId;
	private String complaintText;
	private String psno;
	private String department;
	private String complaintDate;

	public String getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintText() {
		return complaintText;
	}

	public void setComplaintText(String complaintText) {
		this.complaintText = complaintText;
	}

	public String getPsno() {
		return psno;
	}

	public void setPsno(String psno) {
		this.psno = psno;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}

}
