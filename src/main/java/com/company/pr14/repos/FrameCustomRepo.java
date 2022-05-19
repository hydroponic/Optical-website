package com.company.pr14.repos;

import com.company.pr14.domain.Frame;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FrameCustomRepo {
    List<Frame> findByName(String name, String param);
}
