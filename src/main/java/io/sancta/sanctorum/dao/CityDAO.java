package io.sancta.sanctorum.dao;

import io.sancta.sanctorum.domain.City;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CityDAO {
    SessionFactory sessionFactory;

    public List<City> getItems(int offer, int limit) {
        String hql = "select c from City as c";
        Query<City> query = sessionFactory.getCurrentSession().createQuery(hql, City.class);
        query.setFirstResult(offer);
        query.setMaxResults(limit);
        return query.list();
    }

    public int getTotalCount() {
        String hql = "select count(c) from City as c";
        Query<Long> query = sessionFactory.getCurrentSession().createQuery(hql, Long.class);
        return Math.toIntExact(query.getSingleResult());
    }

    public City getById(Integer id) {
        String hql = "select c from City c join fetch c.country where c.id = : ID";
        Query<City> query = sessionFactory.getCurrentSession().createQuery(hql, City.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }

}
