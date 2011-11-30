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


    public List<Riik> getAllRiik(){

        List<Riik> riikList = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Riik.class));

        return riikList;
    }


    @Transactional
    public int getObjektiLiikCount(){

        DetachedCriteria dc = DetachedCriteria.forClass(Objekti_liik.class);
        List<Objekti_liik> objekti_liikList = getHibernateTemplate().findByCriteria(dc);
      return objekti_liikList.size();
    }

    @Transactional
    public int saveObjekti_liik(Objekti_liik objekti_liik){
        getHibernateTemplate().save(objekti_liik);

        return 1;

    }
        @Transactional
    public int saveObjekt(Objekt objekt){

        getHibernateTemplate().save(objekt);

        return 1;

    }

    @Transactional
    public int savePiiririkkuja(Piiririkkuja piiririkkuja){
        getHibernateTemplate().saveOrUpdate(piiririkkuja);

        return 1;
    }
    @Transactional
    public void saveRiik(Riik riik){

        getHibernateTemplate().save(riik);

    }
    @Transactional
    public void saveKodakondsus(Kodakondsus kodakondsus){

        getHibernateTemplate().save(kodakondsus);
    }
    @Transactional
    public List<Kodakondsus> getAllKodakondsus(){

        DetachedCriteria criteria = DetachedCriteria.forClass(Kodakondsus.class);
        List<Kodakondsus> kodakondsusList = getHibernateTemplate().findByCriteria(criteria);

        return kodakondsusList;

    }
    @Transactional
    public Piiririkkuja getPiiririkkujaById(int id){
        DetachedCriteria criteria = DetachedCriteria.forClass(Piiririkkuja.class);
        criteria.add(Restrictions.eq("piiririkkuja_ID", id));
        List<Piiririkkuja> piiririkkujad = getHibernateTemplate().findByCriteria(criteria);

        return piiririkkujad.iterator().next();
    }
    @Transactional
    public void saveSeadus(Seadus seadus){
        getHibernateTemplate().save(seadus);
    }
    @Transactional
    private Seadus getSeadusById(int id){
        DetachedCriteria dc = DetachedCriteria.forClass(Seadus.class);
        dc.add(Restrictions.eq("seaduse_ID", id));

        List<Seadus> seadusList = getHibernateTemplate().findByCriteria(dc);

       return seadusList.iterator().next();
    }
    @Transactional
    public void saveSeaduse_punkt(Seaduse_punkt seaduse_punkt){
        seaduse_punkt.setYlemus_seaduse_punkt_id(230);
        getHibernateTemplate().save(seaduse_punkt);

    }
    @Transactional
    public List<Seaduse_punkt> getAllSeaduse_punktid() {

        DetachedCriteria dc = DetachedCriteria.forClass(Seaduse_punkt.class);
        List<Seaduse_punkt> seaduse_punktList = getHibernateTemplate().findByCriteria(dc);

        return seaduse_punktList;
    }
        @Transactional
    public Seaduse_punkt getSeaduse_punktById(int id){

        DetachedCriteria dc = DetachedCriteria.forClass(Seaduse_punkt.class);
            dc.add(Restrictions.eq("seaduse_punkt_ID",id));
        List<Seaduse_punkt> seaduse_punktList = getHibernateTemplate().findByCriteria(dc);

        return seaduse_punktList.iterator().next();
    }
    @Transactional
    public Objekt getFirstObjekt(){
      List<Objekt> objektList = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Objekt.class));
      if(objektList.size() >0){
          return objektList.iterator().next();
      } else {
          return null;
      }
    }

        @Transactional
    public List<Seadus> getAllSeaduse_ajalugu(){

        DetachedCriteria dc = DetachedCriteria.forClass(Seadus.class);
        List<Seadus> seadusList = getHibernateTemplate().findByCriteria(dc);

        return seadusList;
    }

}
