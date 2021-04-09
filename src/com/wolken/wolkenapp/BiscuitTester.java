package com.wolken.wolkenapp;

import java.util.Scanner;
import com.wolken.wolkenapp.dao.BiscuitsDAO;
import com.wolken.wolkenapp.dao.BiscuitsDAOImpl;
import com.wolken.wolkenapp.dto.BiscuitsDTO;
import com.wolken.wolkenapp.service.BiscuitsService;
import com.wolken.wolkenapp.service.BiscuitsServiceImpl;

public class BiscuitTester {
	
	BiscuitsDAO biscuitsDAO = new BiscuitsDAOImpl();
	
	public void enterDetails() {
		
		BiscuitsDTO biscuitsDTO = new BiscuitsDTO();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID");
		int id = sc.nextInt();
		

		System.out.println("Enter Brand");
		String brand = sc.next();
		

		System.out.println("Enter Name");
		String name = sc.next();
		

		System.out.println("Enter Price");
		double price = sc.nextDouble();
		

		System.out.println("Enter Quantity");
		int qty = sc.nextInt();		
		
		
		biscuitsDTO.setId(id);
		biscuitsDTO.setBrand(brand);
		biscuitsDTO.setName(name);
		biscuitsDTO.setPrice(price);
		biscuitsDTO.setQty(qty);
		
		BiscuitsService biscuitsService = new BiscuitsServiceImpl(biscuitsDAO);
		biscuitsService.validateAndService(biscuitsDTO);
	}

	public static void main(String[] args) {
		
		BiscuitTester biscuitTester = new BiscuitTester();
		
		while(true) {
			System.out.println("\nList of options :\n1 - Add a new biscuit\n2 - Update Brand and Quantity through price\n3 - Update Price through brand and name\n4 - Update Name by brand\n5 - Delete by Name\n6 - Display all it"
					+ "ems\n7 - Delete all items\n8 - Exit\nEnter your choice : ");
			Scanner sc = new Scanner(System.in);
			int c = sc.nextInt();
			switch(c) {
			
			case 1: biscuitTester.enterDetails();
					break;
					
			case 2: System.out.println("Enter Price of item to be updated : ");
					double price = sc.nextDouble();
					biscuitTester.biscuitsDAO.updateBrandAndQtyByPrice(price);
					break;
					
			case 3: System.out.println("Enter Brand and Name of item to be updated : ");
					String brand1 = sc.next();
					String name1 = sc.next();
					biscuitTester.biscuitsDAO.updatePriceByBrandAndName(brand1, name1);
					break;
					
			case 4: System.out.println("Enter Brand of item to be updated : ");
					String brand2 = sc.next();
					biscuitTester.biscuitsDAO.updateNameByBrand(brand2);
					break;
					
			case 5: System.out.println("Enter Name of item to be deleted :");
					String name2 = sc.next();
					biscuitTester.biscuitsDAO.deleteByName(name2);
					break;
			
			case 6: biscuitTester.biscuitsDAO.getAll();
					break;
			
			case 7: biscuitTester.biscuitsDAO.deleteAll();
					break;
			
			case 8: System.exit(0);
					break;
			
			default: System.out.println("This choice does not exist !!");
					 break;
					 
			}
		}

		
	}
	
	
}