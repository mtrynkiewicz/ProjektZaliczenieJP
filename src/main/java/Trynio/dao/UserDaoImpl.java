package Trynio.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserDaoImpl implements UserDao
{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public boolean isLoggedIn(String userName, String password)
    {
        Session session = sessionFactory.openSession();
        String queryString = "SELECT u FROM user u WHERE u.name LIKE ?1 and u.password LIKE ?2";
        Query query = session.createQuery(queryString);
        query.setParameter(1,userName);
        query.setParameter(2,password);
        boolean loggedSuccess = query.getSingleResult() != null;
        return loggedSuccess;
    }
}
