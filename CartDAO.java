package com.Project.dao;

import java.util.List;

import com.Project.model.AddProduct;
import com.Project.model.Cart;

public interface CartDAO {

  void cartsave(Cart cart1);
  List<Cart> cartlist();
AddProduct single_object(int pid);
public void deleteRow(int productId);
}
