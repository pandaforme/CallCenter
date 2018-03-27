package com.xyz;

import com.xyz.model.CallCenter;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    CallCenter callCenter = new CallCenter();
    callCenter.createWithTL(100);

    while (true) {
      Thread.sleep(1000);
      callCenter.answer();
    }
  }
}
