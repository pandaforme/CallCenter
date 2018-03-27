package com.xyz.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class EmployeeTest {

  @Test
  public void testCanNotSolve() {
    Employee employee =
        new Employee() {
          @Override
          public boolean isSolve() {
            return false;
          }

          @Override
          protected void nonFreeStrategy() {}
        };

    Employee fakeDeputy = mock(Employee.class);
    employee.setDeputy(fakeDeputy);
    employee.solve();

    verify(fakeDeputy, times(1)).solve();
    assertTrue(employee.isFree());
  }

  @Test
  public void testCanSolve() {
    Employee employee =
        new Employee() {
          @Override
          public boolean isSolve() {
            return true;
          }

          @Override
          protected void nonFreeStrategy() {}
        };

    Employee fakeDeputy = mock(Employee.class);
    employee.setDeputy(fakeDeputy);
    employee.solve();

    verify(fakeDeputy, never()).solve();
    assertTrue(employee.isFree());
  }

  @Test
  public void testNotFree() {
    Employee employee =
        new Employee() {
          @Override
          public boolean isFree() {
            return false;
          }

          @Override
          protected void nonFreeStrategy() {}
        };

    Employee fakeDeputy = mock(Employee.class);
    employee.setDeputy(fakeDeputy);
    employee.solve();

    verify(fakeDeputy, never()).solve();
    assertFalse(employee.isFree());
  }

  @Test
  public void testTLIsNotFree() {
    Employee technicalLead = new TechnicalLead();
    technicalLead.setFree(false);

    Employee fakeDeputy = mock(ProductManager.class);
    technicalLead.setDeputy(fakeDeputy);
    technicalLead.solve();

    verify(fakeDeputy, times(1)).solve();
    assertFalse(technicalLead.isFree());
  }

  @Test
  public void testPMIsNotFree() {
    Employee productManager = new ProductManager();
    productManager.setFree(false);

    Employee fakeDeputy = mock(ProductManager.class);
    productManager.setDeputy(fakeDeputy);
    productManager.solve();

    verify(fakeDeputy, times(1)).solve();
    assertEquals(productManager.isFree(), false);
  }
}
