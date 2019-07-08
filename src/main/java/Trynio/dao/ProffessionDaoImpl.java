package Trynio.dao;

import Trynio.entity.proffession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public class ProffessionDaoImpl implements ProffessionDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<proffession> getProffessions()
    {
        //sesja hibernate
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        ///
        String s = "FROM proffession";
        Query<proffession> query = currentSession.createQuery(s,proffession.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveProffession(proffession proffession) {
        Session session = sessionFactory.getCurrentSession();
        session.save(proffession);    }

    @Override
    @Transactional
    public proffession getSingleProffession(int proffessionId) {
       Session session = sessionFactory.getCurrentSession();
       proffession proffession = session.find(proffession.class,proffessionId);
       return proffession;
    }

    @Override
    @Transactional
    public proffession getProffessionByName(String proffessionName)
    {
        Session session = sessionFactory.getCurrentSession();
        String s = "FROM proffession as p WHERE p.name like \''" + proffessionName + "\''";
        Query<proffession> query = session.createQuery(s,proffession.class);
        return query.getSingleResult();
    }
}
