package com.company.pr14.repos;

import com.company.pr14.domain.Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FrameCustomRepoImpl implements FrameCustomRepo{
    @Autowired
    private EntityManager em;
    @Override
    public List<Frame> findByName(String name, String param) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Frame> query = cb.createQuery(Frame.class);
        Root<Frame> from = query.from(Frame.class);
        Expression<String> exp = from.get(param);
        Predicate in = exp.in(name);
        query.where(in);
        CriteriaQuery<Frame> select = query.select(from);
        TypedQuery<Frame> query1 = em.createQuery(select);
        return query1.getResultList();
    }
}
