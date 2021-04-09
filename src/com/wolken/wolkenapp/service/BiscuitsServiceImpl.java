package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.dao.BiscuitsDAO;
//import com.wolken.wolkenapp.dao.BiscuitsDAOImpl;
import com.wolken.wolkenapp.dto.BiscuitsDTO;

public class BiscuitsServiceImpl implements BiscuitsService {

	public BiscuitsDAO biscuitsDAO;

	public BiscuitsServiceImpl(BiscuitsDAO biscuitsDAO) {
		// TODO Auto-generated constructor stub
		this.biscuitsDAO = biscuitsDAO;
	}

	@Override
	public boolean validateAndService(BiscuitsDTO biscuitsDTO) {

		boolean check = false;
		boolean flag = false;
		String brand = biscuitsDTO.getBrand();

		if (brand != null && !brand.isEmpty() && !brand.contains(" ")) {
			check = true;
			System.out.println("\nBrand is valid");
		} else {
			System.out.println("\nBrand is invalid");
			check = false;
			flag = true;
		}

		double price = biscuitsDTO.getPrice();
		if (price > 0 && price <= 500) {
			check = true;
			System.out.println("Price is valid");
		} else {
			System.out.println("Price is invalid");
			check = false;
			flag = true;
		}
		int qty = biscuitsDTO.getQty();
		if (qty > 0 && qty <= 2000) {
			check = true;
			System.out.println("Quantity is valid");
		} else {
			check = false;
			System.out.println("Quantity is invalid");
			flag = true;
		}


		if (!flag) {
			biscuitsDAO.save(biscuitsDTO);
		} else {
			System.out.println("Biscuit not added to list !!");
		}

		return check;
	}
}