package com.xyz.model;

import java.util.ArrayList;
import java.util.List;

public class CallCenter {
  private List<Employee> fresherList;
  private Employee supervisor;

  public CallCenter() {
    this.fresherList = new ArrayList<>();
  }

  public void answer() {
    if (fresherList.stream().noneMatch(Employee::isFree)) {
      supervisor.solve();
    }

    fresherList.forEach(
        employee ->
            new Thread() {
              @Override
              public void run() {
                super.run();
                employee.solve();
              }
            }.start());
  }

  public void createWithTL(int fresherNumber) {
    supervisor = new TechnicalLead();

    for (int i = 0; i < fresherNumber; i++) {
      Employee fresher = new Fresher();
      fresher.setDeputy(supervisor);
      fresherList.add(fresher);
    }
  }

  public void createWithPM(int fresherNumber) {
    supervisor = new ProductManager();

    for (int i = 0; i < fresherNumber; i++) {
      Employee fresher = new Fresher();
      fresher.setDeputy(supervisor);
      fresherList.add(fresher);
    }
  }

  public void createWithBoth(int fresherNumber) {
    ProductManager productManager = new ProductManager();
    TechnicalLead technicalLead = new TechnicalLead();
    technicalLead.setDeputy(productManager);

    supervisor = technicalLead;

    for (int i = 0; i < fresherNumber; i++) {
      Employee fresher = new Fresher();
      fresher.setDeputy(supervisor);
      fresherList.add(fresher);
    }
  }

  public List<Employee> getFresherList() {
    return fresherList;
  }

  public void setFresherList(List<Employee> fresherList) {
    this.fresherList = fresherList;
  }

  public Employee getSupervisor() {
    return supervisor;
  }

  public void setSupervisor(Employee supervisor) {
    this.supervisor = supervisor;
  }
}
