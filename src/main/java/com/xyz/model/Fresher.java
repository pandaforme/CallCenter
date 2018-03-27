package com.xyz.model;

public class Fresher extends Employee {

  public Fresher() {}

  @Override
  public String toString() {
    return "Fresher";
  }

  @Override
  protected void nonFreeStrategy() {
    return;
  }
}
