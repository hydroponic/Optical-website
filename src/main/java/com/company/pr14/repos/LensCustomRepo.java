package com.company.pr14.repos;

import com.company.pr14.domain.Lens;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LensCustomRepo {
    List<Lens> findByName(String name, String param);
}
