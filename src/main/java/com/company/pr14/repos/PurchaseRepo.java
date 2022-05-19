package com.company.pr14.repos;

import com.company.pr14.domain.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends CrudRepository<Purchase, Integer> {
}
