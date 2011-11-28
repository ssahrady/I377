package ee.project.dao;

import ee.project.data.*;

import java.util.List;

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
    public void saveRiik(Riik riik);
    public void saveKodakondsus(Kodakondsus kodakondsus);
    public List<Kodakondsus> getAllKodakondsus();
    public Piiririkkuja getPiiririkkujaById(int id);
}
