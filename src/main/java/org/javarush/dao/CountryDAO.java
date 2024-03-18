package org.javarush.dao;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.javarush.domain.Country;

import java.util.List;

@AllArgsConstructor
public class CountryDAO {
    private final SessionFactory sessionFactory;

    public List<Country> getAll() {
        Query<Country> query = sessionFactory.getCurrentSession().createQuery("select c from Country c join fetch c.languages", Country.class);
        return query.list();
    }
}
