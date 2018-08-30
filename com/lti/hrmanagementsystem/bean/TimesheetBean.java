package com.lti.hrmanagementsystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "timesheet")
@Table(name = "timesheet")
public class TimesheetBean {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String timesheetId;
	private String psno;
	private String entryDate;
	private int inTime;
	private int outTime;
	private String commentDesc;
	private int timesheetStatus;

	public String getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(String timesheetId) {
		this.timesheetId = timesheetId;
	}

	public String getPsno() {
		return psno;
	}

	public void setPsno(String psno) {
		this.psno = psno;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

	public String getCommentDesc() {
		return commentDesc;
	}

	public void setCommentDesc(String comment) {
		this.commentDesc = comment;
	}

	public int getTimesheetStatus() {
		return timesheetStatus;
	}

	public void setTimesheetStatus(int timesheetStatus) {
		this.timesheetStatus = timesheetStatus;
	}

	@Override
	public String toString() {
		return "TimesheetBean [timesheetId=" + timesheetId + ", psno=" + psno + ", entryDate=" + entryDate + ", inTime="
				+ inTime + ", outTime=" + outTime + ", commentDesc=" + commentDesc + ", timesheetStatus="
				+ timesheetStatus + "]";
	}

}
