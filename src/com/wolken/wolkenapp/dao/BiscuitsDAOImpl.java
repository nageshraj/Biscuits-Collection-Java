package com.wolken.wolkenapp.dao;

import java.util.*; 
import com.wolken.wolkenapp.dto.BiscuitsDTO;


public class BiscuitsDAOImpl implements BiscuitsDAO {

	List<BiscuitsDTO> listbiscuitsDTO = new ArrayList<BiscuitsDTO>();

	@Override
	public void save(BiscuitsDTO biscuitsDTO) {

		boolean check = listbiscuitsDTO.contains(biscuitsDTO);

		if (!check) {
			this.listbiscuitsDTO.add(biscuitsDTO);
			System.out.println("Biscuit added to list\n");
		}
	}

	@Override
	public void updateBrandAndQtyByPrice(double price) {
		
		Scanner sc = new Scanner(System.in);
		
		if(listbiscuitsDTO.isEmpty()) {
			System.out.println("No entries exist yet \nEnter 1 to add an item");			
		}
		
		for (BiscuitsDTO biscuitsDTO : listbiscuitsDTO) {
			
			if(biscuitsDTO.getPrice() == price)
			{
				System.out.println("Enter new Brand and Quantity to be updated : ");
				String brand = sc.next();
				int qty = sc.nextInt();
				biscuitsDTO.setBrand(brand);
				biscuitsDTO.setQty(qty);
				System.out.println("Item has been updated");
				displayBiscuitDeets(biscuitsDTO);
			}
		}
	}

	@Override
	public void updatePriceByBrandAndName(String brand, String name) {
		
		Scanner sc = new Scanner(System.in);
		
		if(listbiscuitsDTO.isEmpty()) {
			System.out.println("No entries exist yet \nEnter 1 to add an item");			
		}
		
		for (BiscuitsDTO biscuitsDTO : listbiscuitsDTO) {
			
			if( (biscuitsDTO.getBrand().equals(brand)) && (biscuitsDTO.getName().equals(name)) )
			{
				System.out.println("Enter new Price to be updated : ");
				double price = sc.nextDouble();
				biscuitsDTO.setPrice(price);
				System.out.println("Item has been updated");
				displayBiscuitDeets(biscuitsDTO);
			}
		}
		
	}

	@Override
	public void updateNameByBrand(String brand) {
		
		Scanner sc = new Scanner(System.in);
		
		if(listbiscuitsDTO.isEmpty()) {
			System.out.println("No entries exist yet \nEnter 1 to add an item");			
		}
		
		for (BiscuitsDTO biscuitsDTO : listbiscuitsDTO) {
			
			if(biscuitsDTO.getBrand().equals(brand))
			{
				System.out.println("Enter new Name to be updated : ");
				String name  = sc.next();
				biscuitsDTO.setName(name);
				System.out.println("Item has been updated");
				displayBiscuitDeets(biscuitsDTO);
			}
		}
	}

	@Override
	public void deleteByName(String name) {
		
		if(listbiscuitsDTO.isEmpty()) {
			System.out.println("No entries exist yet \nEnter 1 to add an item");			
		}
		
		for(int i=0; i<listbiscuitsDTO.size(); i++) {
			if(listbiscuitsDTO.get(i).getName().equals(name)) {
				System.out.println("Item with Name "+listbiscuitsDTO.get(i).getName()+" has been removed");
				listbiscuitsDTO.remove(i);
				return;
			}
		}
		System.out.println("No item named "+name+" exists");
	}

	@Override
	public void deleteAll() {
		
		if( ! this.listbiscuitsDTO.isEmpty()) {
			listbiscuitsDTO.removeAll(listbiscuitsDTO);
			System.out.println("All items have been deleted from the list\nEnter 1 to Add new item");
		}
		else
			System.out.println("No entries exist yet \nEnter 1 to add an item");
	}

	@Override
	public void getAll() {
		
		if(this.listbiscuitsDTO.isEmpty()) {
			System.out.println("No entries exist yet \nEnter 1 to add an item");
		}
		else {
			for (BiscuitsDTO biscuitsDTO : this.listbiscuitsDTO) {
				displayBiscuitDeets(biscuitsDTO);
			}
		}
	}
	
	public void displayBiscuitDeets (BiscuitsDTO obj) {
		
		BiscuitsDTO bDTO = (BiscuitsDTO) obj;
		if(bDTO == null) {
			System.out.println("No obj");
		}
		System.out.println("\nID : "+obj.getId()+"\nName : "+obj.getName()+"\nBrand : "+obj.getBrand()+"\nQuantity : "+obj.getQty()+"g\nPrice : "+obj.getPrice());
		}
	}
	