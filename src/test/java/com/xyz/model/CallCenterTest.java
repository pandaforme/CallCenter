package com.xyz.model;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CallCenterTest {

  @Test
  public void testAnswer1() {
    CallCenter callCenter = new CallCenter();

    List<Employee> list = new ArrayList<>();
    Fresher fresher = new Fresher();
    fresher.setFree(false);
    list.add(fresher);
    callCenter.setFresherList(list);

    Employee fakeDeputy = mock(Employee.class);
    callCenter.setSupervisor(fakeDeputy);

    callCenter.answer();
    verify(fakeDeputy, times(1)).solve();
  }

  @Test
  public void testAnswer2() {
    CallCenter callCenter = new CallCenter();

    List<Employee> list = new ArrayList<>();
    Fresher fresher = new Fresher();
    fresher.setFree(true);
    list.add(fresher);
    callCenter.setFresherList(list);

    Employee fakeDeputy = mock(Employee.class);
    callCenter.setSupervisor(fakeDeputy);

    callCenter.answer();
    verify(fakeDeputy, never()).solve();
  }
}
