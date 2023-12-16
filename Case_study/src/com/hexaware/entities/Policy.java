package com.hexaware.entities;
import java.util.Date;

public class Policy {
	private int policy_id;
	private int policy_number;
	private String policy_type;
	private double coverage_amount;
	private double premium_amount;
	private Date start_date;
	private Date end_date;
	
	
	

	public Policy(int policy_id, int policy_number, String policy_type, double coverage_amount, double premium_amount,
			Date start_date, Date end_date) {

		this.policy_id = policy_id;
		this.policy_number = policy_number;
		this.policy_type = policy_type;
		this.coverage_amount = coverage_amount;
		this.premium_amount = premium_amount;
		this.start_date = start_date;
		this.end_date = end_date;
	}



	public Policy() {

		this.policy_id = policy_id;
		this.policy_number = policy_number;
		this.policy_type = policy_type;
		this.coverage_amount = coverage_amount;
		this.premium_amount = premium_amount;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	



	public int getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}

	public int getPolicy_number() {
		return policy_number;
	}

	public void setPolicy_number(int policy_number) {
		this.policy_number = policy_number;
	}

	public String getPolicy_type() {
		return policy_type;
	}

	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}

	public double getCoverage_amount() {
		return coverage_amount;
	}

	public void setCoverage_amount(double coverage_amount) {
		this.coverage_amount = coverage_amount;
	}

	public double getPremium_amount() {
		return premium_amount;
	}

	public void setPremium_amount(double premium_amount) {
		this.premium_amount = premium_amount;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	@Override
    public String toString() {
        return "Policy{" +
                "policy_Id=" + policy_id +
                ", policy_Number='" + policy_number + '\'' +
                ", policy_Type='" + policy_type + '\'' +
                ", coverage_Amount=" + coverage_amount +
                ", premium_Amount=" + premium_amount +
                ", start_Date=" + start_date +
                ", end_Date=" + end_date +
                '}';
	
	
	

}
}
	
