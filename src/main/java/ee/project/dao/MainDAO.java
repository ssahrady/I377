package ee.project.dao;

import ee.project.data.Objekt;
import ee.project.data.Objekti_liik;
import ee.project.data.Piiririkkuja;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 11/22/11
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MainDAO {

    public int saveObjekti_liik(Objekti_liik objekti_liik);
    public int saveObjekt(Objekt objekt);
    public int savePiiririkkuja(Piiririkkuja piiririkkuja);
}
