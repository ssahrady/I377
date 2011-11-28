package ee.project.dao;

import ee.project.data.*;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.jpa.support.JpaDaoSupport;
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
    public int saveObjekti_liik(Objekti_liik objekti_liik){

        //objekti_liik.setObjekt_liik_id(6);
        getHibernateTemplate().save(objekti_liik);

        return 1;

    }
        @Transactional
    public int saveObjekt(Objekt objekt){

        //objekt.setObjekt_ID(1);
        getHibernateTemplate().save(objekt);

        return 1;

    }

    @Transactional
    public int savePiiririkkuja(Piiririkkuja piiririkkuja){
        getHibernateTemplate().persist(piiririkkuja);

        return 1;
    }
    @Transactional
    public void saveRiik(Riik riik){

        getHibernateTemplate().save(riik);

    }

    public void saveKodakondsus(Kodakondsus kodakondsus){

        getHibernateTemplate().save(kodakondsus);
    }

    public List<Kodakondsus> getAllKodakondsus(){

        DetachedCriteria criteria = DetachedCriteria.forClass(Kodakondsus.class);
        List<Kodakondsus> kodakondsusList = getHibernateTemplate().findByCriteria(criteria);

        return kodakondsusList;

    }

}
