package ee.project.data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "OBJEKT")
public class Objekt extends OpenableCloseable{

    private String nimetus;
    private int objekt_ID;
    private int objekt_liik_id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "OBJEKT_ID", nullable = false)
    public int getObjekt_ID() {
        return objekt_ID;
    }

    public void setObjekt_ID(int objekt_ID) {
        this.objekt_ID = objekt_ID;
    }

    @Column(name = "NIMETUS", nullable = false)
    public String getNimetus() {
        return this.nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }

    @Column(name = "OBJEKT_LIIK_ID", nullable = false)
    public int getObjekt_liik_id() {
        return objekt_liik_id;
    }

    public void setObjekt_liik_id(int objekt_liik_id) {
        this.objekt_liik_id = objekt_liik_id;
    }
}
