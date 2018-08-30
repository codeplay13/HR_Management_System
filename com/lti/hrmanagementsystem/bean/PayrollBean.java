package com.lti.hrmanagementsystem.bean;

public class PayrollBean {
	private String psno;
	private double basic;
	private double pf;
	private double gratuity;
	private double tax;
	private double total;

	public String getPsno() {
		return psno;
	}

	public void setPsno(String psno) {
		this.psno = psno;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double basic) {
		this.pf = Math.ceil(basic*0.1);
	}

	public double getGratuity() {
		return gratuity;
	}

	public void setGratuity(double basic) {
		this.gratuity = Math.ceil(basic*0.004);
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double basic) {
		this.tax = Math.ceil(basic*0.0167);
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double basic, double pf, double gratuity, double tax) {
		this.total = Math.ceil(basic-pf-gratuity-tax);
	}

}
