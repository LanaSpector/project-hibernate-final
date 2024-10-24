package io.sancta.sanctorum;

import io.sancta.sanctorum.dao.CityDAO;
import io.sancta.sanctorum.dao.CountryDAO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GeoController {
    SessionFactory sessionFactory;
    CityDAO cityDAO;
    CountryDAO countryDAO;

    public GeoController() {
        sessionFactory = prepareRelationalDB();
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
    }

    private SessionFactory prepareRelationalDB() {
        return new Configuration().configure().buildSessionFactory();
    }
}
