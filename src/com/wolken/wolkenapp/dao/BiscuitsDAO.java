package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.dto.BiscuitsDTO;

public interface BiscuitsDAO {

	public void save(BiscuitsDTO biscuitsDTO);
	public void updateBrandAndQtyByPrice(double price);
	public void updatePriceByBrandAndName(String brand, String name);
	public void updateNameByBrand(String brand);
	public void deleteByName(String name);
	public void deleteAll();
	public void getAll();
}
