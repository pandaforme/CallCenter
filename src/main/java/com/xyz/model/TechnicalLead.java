package com.xyz.model;

public class TechnicalLead extends Employee {

  public TechnicalLead() {}

  @Override
  public String toString() {
    return "Technical Lead";
  }

  @Override
  protected void nonFreeStrategy() {
    if (this.getDeputy() != null) {
      this.getDeputy().solve();
    }
  }
}
