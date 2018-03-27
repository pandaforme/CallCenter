package com.xyz.model;

public class ProductManager extends Employee {

  public ProductManager() {}

  @Override
  public String toString() {
    return "Product Manager";
  }

  @Override
  protected void nonFreeStrategy() {
    if (this.getDeputy() != null) {
      this.getDeputy().solve();
    }
  }
}
