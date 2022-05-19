package com.company.pr14.repos;

import com.company.pr14.domain.Frame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameRepo extends CrudRepository<Frame, Integer>, FrameCustomRepo {

}
