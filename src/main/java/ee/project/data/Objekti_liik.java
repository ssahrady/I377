package ee.project.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OBJEKTI_LIIK")
public class Objekti_liik extends OpenableCloseable{

    private int objekt_liik_id;
    private String nimetus;
    private String kood;


    @Column(name = "NIMETUS", nullable = false)
    public String getNimetus() {
        return this.nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }

    @Column(name = "KOOD")
    public String getKood() {
        return kood;
    }

    public void setKood(String kood) {
        this.kood = kood;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "OBJEKT_LIIK_ID")
    public int getObjekt_liik_id() {
        return objekt_liik_id;
    }

    public void setObjekt_liik_id(int objekt_liik_id) {
        this.objekt_liik_id = objekt_liik_id;
    }
}
