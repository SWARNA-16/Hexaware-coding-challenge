package com.hexware.mainmod;

import com.hexaware.dao.InsuranceServiceImp;

import com.hexaware.entities.Policy;
import com.hexaware.myexceptions.PolicyNumberNotFoundException;

import java.util.List;
import java.util.Scanner;

public class MainModule {

    public static void main(String[] args) throws PolicyNumberNotFoundException {
        InsuranceServiceImp insuranceService = new InsuranceServiceImp();
        Scanner scanner = new Scanner(System.in);
        System.out.println("------INSURANCE MANAGEMNET------- ");
        System.out.println("Choose an option:");
        System.out.println("1. Create Policy");
        System.out.println("2. Get Policy");
        System.out.println("3. Get All Policies");
        System.out.println("4. Update Policy");
        System.out.println("5. Delete Policy");
        int option = scanner.nextInt();
     

        switch (option) {
            case 1:
               
            
                Policy newPolicy = createPolicyFromUserInput(scanner);
                insuranceService.createPolicy(newPolicy);
                System.out.println("Policy has been created !");
                break;
            case 2:
               
                System.out.println("Enter policy ID to retrieve: ");
                int policyIdToRetrieve = scanner.nextInt();
                Policy retrievedPolicy = insuranceService.getPolicy(policyIdToRetrieve);
                System.out.println("Retrieved Policy: " + retrievedPolicy);
                break;
            case 3:
              
                List<Policy> allPolicies = insuranceService.getAllPolicies();
                System.out.println("All Policies: " + allPolicies);
                break;
            case 4:
               
                Policy updatedPolicy = createPolicyFromUserInput(scanner);
                insuranceService.updatePolicy(updatedPolicy);
                System.out.println("Congrats your has been updated !");
                break;
            case 5:
              
                System.out.println("Enter policy ID to delete: ");
                int policyIdToDelete = scanner.nextInt();
                insuranceService.deletePolicy(policyIdToDelete);
                System.out.println("The policy that you choosed has been deleted !");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }

        scanner.close();
    }

    private static Policy createPolicyFromUserInput(Scanner scanner) {
        // Read policy details from the user and create a Policy object
        Policy policy = new Policy();
        // Read and set policy attributes using scanner.nextInt(), scanner.nextDouble(), etc.
        // For example:
        System.out.println("Enter policy ID: ");
        policy.setPolicy_id(scanner.nextInt());

        // Repeat for other attributes like policy_number, policy_type, coverage_amount, premium_amount, start_date, end_date

        return policy;
    }
}