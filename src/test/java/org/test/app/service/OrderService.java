package org.test.app.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

  public void processOrders() throws InterruptedException {
    
    Thread.sleep(1);
  }
}
