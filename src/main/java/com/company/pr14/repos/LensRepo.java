package com.company.pr14.repos;

import com.company.pr14.domain.Lens;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LensRepo extends CrudRepository<Lens, Integer>, LensCustomRepo {


}
