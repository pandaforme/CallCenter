package com.xyz.model;

import java.util.Random;

public abstract class Employee {
  private boolean isFree = true;

  private Employee deputy;

  public boolean isFree() {
    return isFree;
  }

  public void setFree(boolean free) {
    isFree = free;
  }

  public boolean isSolve() {
    return new Random().nextBoolean();
  }

  public Employee getDeputy() {
    return deputy;
  }

  public void setDeputy(Employee deputy) {
    this.deputy = deputy;
  }

  protected abstract void nonFreeStrategy();

  public void solve() {
    if (!this.isFree()) {
      System.out.printf("[%s] %s is not free%n", Thread.currentThread().getName(), this.toString());

      nonFreeStrategy();
      return;
    }

    // start to solve a problem
    System.out.printf(
        "[%s] %s starts to solve a problem%n", Thread.currentThread().getName(), this.toString());
    this.setFree(false);

    if (!isSolve()) {
      System.out.printf(
          "[%s] %s can't solve a problem and escalate to %s%n",
          Thread.currentThread().getName(), this.toString(), this.getDeputy().toString());
      if (deputy != null) {
        deputy.solve();
      }
    }

    // finish solving a problem
    System.out.printf(
        "[%s] %s finishs solving a problem%n", Thread.currentThread().getName(), this.toString());
    this.setFree(true);
  }
}
