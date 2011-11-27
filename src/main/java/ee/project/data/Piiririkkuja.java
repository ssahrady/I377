package ee.project.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PIIRIRIKKUJA")
public class Piiririkkuja extends OpenableCloseable{

    private int piiririkkuja_ID;
    private String isikukood;
    private String eesnimi;
    private String perek_nimi;
    private String sugu;
    private Date synniaeg;
    private int objekt_ID;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PIIRIRIKKUJA_ID")
    public int getPiiririkkuja_ID() {
        return piiririkkuja_ID;
    }

    public void setPiiririkkuja_ID(int piiririkkuja_ID) {
        this.piiririkkuja_ID = piiririkkuja_ID;
    }

    @Column(name = "ISIKUKOOD")
    public String getIsikukood() {
        return isikukood;
    }

    public void setIsikukood(String isikukood) {
        this.isikukood = isikukood;
    }

    @Column(name = "EESNIMI")
    public String getEesnimi() {
        return eesnimi;
    }

    public void setEesnimi(String eesnimi) {
        this.eesnimi = eesnimi;
    }

    @Column(name = "PEREK_NIMI")
    public String getPerek_nimi() {
        return perek_nimi;
    }

    public void setPerek_nimi(String perek_nimi) {
        this.perek_nimi = perek_nimi;
    }

    @Column(name = "SUGU")
    public String getSugu() {
        return sugu;
    }

    public void setSugu(String sugu) {
        this.sugu = sugu;
    }

    @Column(name = "SYNNIAEG")
    public Date getSynniaeg() {
        return synniaeg;
    }

    public void setSynniaeg(Date synniaeg) {
        this.synniaeg = synniaeg;
    }

    @Column(name = "OBJEKT_ID", nullable = false)
    public int getObjekt_ID() {
        return objekt_ID;
    }

    public void setObjekt_ID(int objekt_ID) {
        this.objekt_ID = objekt_ID;
    }
}
