package ee.project.dao;

import ee.project.data.Objekti_liik;
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
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 11/22/11
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainDAOImpl extends HibernateDaoSupport implements MainDAO {


    @Transactional
    public int makeObjekti_liik(Objekti_liik objekti_liik){

        //Objekti_liik objekti_liik = new Objekti_liik();
//        objekti_liik.setAvaja("Tambet Tool");
//        objekti_liik.setAvatud(new Date());
//        objekti_liik.setMuutja("Malle Lammas");
//        objekti_liik.setMuudetud(new Date());
//        objekti_liik.setSuletud(new Date());
//        objekti_liik.setSulgeja("President Karu");
//        objekti_liik.setNimetus("Pall");
        objekti_liik.setObjekt_liik_id(6);
        getHibernateTemplate().save(objekti_liik);

        return 1;

    }

}
