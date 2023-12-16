package com.hexaware.entities;
import java.util.Date;

public class Claim {
	private int claimId;
	 private String claimNumber;
	 private Date dateFiled;
	 private double claimAmount;
	 private ClaimStatus status;
	 private Policy policy;
	 private Client client;
	 public enum ClaimStatus {
		 PENDING, APPROVED, DENIED
	 }
	public Claim(int claimId, String claimNumber, Date dateFiled, double claimAmount, Policy policy, Client client) {
		
		this.claimId = claimId;
		this.claimNumber = claimNumber;
		this.dateFiled = dateFiled;
		this.claimAmount = claimAmount;
		this.policy = policy;
		this.client = client;
	}
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public Date getDateFiled() {
		return dateFiled;
	}
	public void setDateFiled(Date dateFiled) {
		this.dateFiled = dateFiled;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString()
	{
		return claimId+" "+claimNumber+" "+dateFiled+" "+claimAmount+" "+status+" "+policy+" "+client;
	}
	 

}
