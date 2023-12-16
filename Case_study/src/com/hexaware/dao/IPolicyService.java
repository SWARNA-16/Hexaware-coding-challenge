package com.hexaware.dao;
import java.util.List;
import com.hexaware.entities.Policy;
import com.hexaware.myexceptions.PolicyNumberNotFoundException;


public interface IPolicyService  {
	
	 boolean createPolicy(Policy policy);
	 Policy getPolicy(int policyId) throws PolicyNumberNotFoundException;
	 List<Policy> getAllPolicies();
	 boolean updatePolicy(Policy policy);
	 boolean deletePolicy(int policyId);

}
