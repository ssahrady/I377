package ee.project.dao;

import ee.project.data.Testtable;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 11/22/11
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainDAOImpl  implements MainDAO {


    private HibernateTemplate hibernateTemplate;


    public void setSessionFactory(SessionFactory sessionFactory)

    {

        this.hibernateTemplate = new HibernateTemplate(sessionFactory);

    }



    @Transactional
    public int testing(){


//        DetachedCriteria dc = DetachedCriteria.forClass(Testtable.class);
//        dc.add(Restrictions.eq("id", 5));
//
//        List res = hibernateTemplate.findByCriteria(dc);
//        hibernateTemplate.flush();
        Testtable testtable = new Testtable();
        testtable.setVal("oujea");

        hibernateTemplate.save(testtable);
        hibernateTemplate.flush();



        return 1;

    }

}
