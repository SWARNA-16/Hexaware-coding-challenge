package com.hexaware.dao;
import com.hexaware.util.*;
import java.util.List;
import java.util.Scanner;
import com.hexaware.entities.Policy;
import com.hexaware.myexceptions.PolicyNumberNotFoundException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InsuranceServiceImp implements IPolicyService {
	
	 private static Connection connection;
	 
	 public InsuranceServiceImp() 
	 {
	        connection = DBconnection.getConnection();
	 }
	
	public boolean createPolicy(Policy policy)
	{
		Scanner scanner = new Scanner(System.in);

	    try {
	        String query = "INSERT INTO Policies (policy_id, policy_number, policy_type, coverage_amount, premium_amount, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = connection.prepareStatement(query);
	      
	     
	        System.out.println("Enter policy ID: ");
	        int policyId = scanner.nextInt();
	        System.out.println("Enter policy number: ");
	        int policyNumber = scanner.nextInt();
	        System.out.println("Enter policy type: ");
	        String policyType = scanner.next();
	        System.out.println("Enter coverage amount: ");
	        double coverageAmount = scanner.nextDouble();
	        System.out.println("Enter premium amount: ");
	        double premiumAmount = scanner.nextDouble();
	        System.out.println("Enter start date (YYYY-MM-DD): ");
	        String startDateStr = scanner.next();
	        Date startDate = Date.valueOf(startDateStr);
	        System.out.println("Enter end date (YYYY-MM-DD): ");
	        String endDateStr = scanner.next();
	        Date endDate = Date.valueOf(endDateStr);

	        statement.setInt(1, policyId);
	        statement.setInt(2, policyNumber);
	        statement.setString(3, policyType);
	        statement.setDouble(4, coverageAmount);
	        statement.setDouble(5, premiumAmount);
	        statement.setDate(6, startDate);
	        statement.setDate(7, endDate);

	     
	        return statement.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        scanner.close(); 
	    }
	}

	@Override

    public Policy getPolicy(int policyId) throws PolicyNumberNotFoundException {
        String query = "SELECT * FROM Policies WHERE policy_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, policyId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return constructPolicyFromResultSet(resultSet);
                } else {
                    throw new PolicyNumberNotFoundException("Policy with ID  not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public List<Policy> getAllPolicies() {
		 List<Policy> policies = new ArrayList<>();
	        String query = "SELECT * FROM Policies";
	        try (PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery())
	        {
	            while (resultSet.next()) {
	               
	                policies.add(constructPolicyFromResultSet(resultSet));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return policies;
		
	}

	@Override
	public boolean updatePolicy(Policy policy) {
		
		Scanner scanner = new Scanner(System.in);

	    try {
	        System.out.println("Enter policy ID to update: ");
	        int policyIdToUpdate = scanner.nextInt();

	       
	        System.out.println("Enter new policy ID: ");
	        int newPolicyId = scanner.nextInt();
	        System.out.println("Enter new policy number: ");
	        int newPolicyNumber = scanner.nextInt();
	        System.out.println("Enter new policy type: ");
	        String newPolicyType = scanner.next();
	        System.out.println("Enter new coverage amount: ");
	        double newCoverageAmount = scanner.nextDouble();
	        System.out.println("Enter new premium amount: ");
	        double newPremiumAmount = scanner.nextDouble();
	        System.out.println("Enter new start date (YYYY-MM-DD): ");
	        String newStartDateStr = scanner.next();
	        Date newStartDate = Date.valueOf(newStartDateStr);
	        System.out.println("Enter new end date (YYYY-MM-DD): ");
	        String newEndDateStr = scanner.next();
	        Date newEndDate = Date.valueOf(newEndDateStr);

	        String query = "UPDATE Policies SET policy_id=?, policy_number=?, policy_type=?, coverage_amount=?, premium_amount=?, start_date=?, end_date=? WHERE policy_id=?";
	        PreparedStatement statement = connection.prepareStatement(query);

	
	        statement.setInt(1, newPolicyId);
	        statement.setInt(2, newPolicyNumber);
	        statement.setString(3, newPolicyType);
	        statement.setDouble(4, newCoverageAmount);
	        statement.setDouble(5, newPremiumAmount);
	        statement.setDate(6, newStartDate);
	        statement.setDate(7, newEndDate);
	        statement.setInt(8, policyIdToUpdate); 

	    
	        return statement.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        scanner.close(); 
	    }
	}

	@Override
	public boolean deletePolicy(int policyId) {
		 String query = "DELETE FROM Policies WHERE policy_id=?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, policyId);
                
	            
	          
	            return statement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }

	}
	private Policy constructPolicyFromResultSet(ResultSet resultSet) throws SQLException {
        Policy policy = new Policy();
        policy.setPolicy_id(resultSet.getInt("policy_id"));
        policy.setPolicy_number(resultSet.getInt("policy_number"));
        policy.setPolicy_type(resultSet.getString("policy_type"));
        policy.setCoverage_amount(resultSet.getDouble("coverage_amount"));
        policy.setPremium_amount(resultSet.getDouble("premium_amount"));
        policy.setStart_date(resultSet.getDate("start_date"));
        policy.setEnd_date(resultSet.getDate("end_date"));
        return policy;
    }

}
