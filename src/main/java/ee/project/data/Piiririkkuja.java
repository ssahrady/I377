package ee.project.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PIIRIRIKKUJA")
public class Piiririkkuja {

    private int piiririkkuja_ID;
    private String avaja;
    private Date avatud;
    private String muutja;
    private Date muudetud;
    private String sulgeja;
    private Date suletud;
    private String isikukood;
    private String kommentaar;
    private String eesnimi;
    private String perek_nimi;
    private String sugu;
    private Date synniaeg;
    private int objekt_ID;


    @Id
    @GeneratedValue
    @Column(name = "PIIRIRIKKUJA_ID")
    public int getPiiririkkuja_ID() {
        return piiririkkuja_ID;
    }

    public void setPiiririkkuja_ID(int piiririkkuja_ID) {
        this.piiririkkuja_ID = piiririkkuja_ID;
    }

    @Column(name = "AVAJA", nullable = false)
    public String getAvaja() {
        return avaja;
    }

    public void setAvaja(String avaja) {
        this.avaja = avaja;
    }

    @Column(name = "AVATUD", nullable = false)
    public Date getAvatud() {
        return avatud;
    }

    public void setAvatud(Date avatud) {
        this.avatud = avatud;
    }

    @Column(name = "MUUTJA",nullable = false)
    public String getMuutja() {
        return muutja;
    }

    public void setMuutja(String muutja) {
        this.muutja = muutja;
    }

    @Column(name = "MUUDETUD", nullable = false)
    public Date getMuudetud() {
        return muudetud;
    }

    public void setMuudetud(Date muudetud) {
        this.muudetud = muudetud;
    }

    @Column(name = "SULGEJA")
    public String getSulgeja() {
        return sulgeja;
    }

    public void setSulgeja(String sulgeja) {
        this.sulgeja = sulgeja;
    }

    @Column(name = "SULETUD", nullable = false)
    public Date getSuletud() {
        return suletud;
    }

    public void setSuletud(Date suletud) {
        this.suletud = suletud;
    }

    @Column(name = "ISIKUKOOD")
    public String getIsikukood() {
        return isikukood;
    }

    public void setIsikukood(String isikukood) {
        this.isikukood = isikukood;
    }

    @Column(name = "KOMMENTAAR")
    public String getKommentaar() {
        return kommentaar;
    }

    public void setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
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
