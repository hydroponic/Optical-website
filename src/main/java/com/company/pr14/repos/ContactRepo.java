package com.company.pr14.repos;

import com.company.pr14.domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends CrudRepository<Contact, Integer> {

}
