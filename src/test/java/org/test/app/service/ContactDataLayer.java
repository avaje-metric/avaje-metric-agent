package org.test.app.service;

import java.util.List;

import org.test.app.model.Contact;

public interface ContactDataLayer {

  public List<Contact> fetchData();
}
