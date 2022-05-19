package com.company.pr14.repos;

import com.company.pr14.domain.Lens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LensCustomRepoImpl implements LensCustomRepo{
    @Autowired
    private EntityManager em;
    @Override
    public List<Lens> findByName(String name, String param) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Lens> query = cb.createQuery(Lens.class);
        Root<Lens> from = query.from(Lens.class);
        Expression<String> exp = from.get(param);
        Predicate in = exp.in(name);
        query.where(in);
        CriteriaQuery<Lens> select = query.select(from);
        TypedQuery<Lens> query1 = em.createQuery(select);
        return query1.getResultList();
    }
}
