package ee.project.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OBJEKTI_LIIK")
public class Objekti_liik {

    private int objekt_liik_id;
    private String avaja;
    private Date avatud;
    private String muutja;
    private Date muudetud;
    private String sulgeja;
    private Date suletud;
    private String nimetus;
    private String kommentaar;
    private String kood;


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

    @Column(name = "MUUTJA", nullable = false)
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

    @Column(name = "NIMETUS", nullable = false)
    public String getNimetus() {
        return this.nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }

    @Column(name = "KOMMENTAAR")
    public String getKommentaar() {
        return kommentaar;
    }


    public void setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
    }

    @Column(name = "KOOD")
    public String getKood() {
        return kood;
    }

    public void setKood(String kood) {
        this.kood = kood;
    }

    @Id
    @Column(name = "OBJEKT_LIIK_ID")
    public int getObjekt_liik_id() {
        return objekt_liik_id;
    }

    public void setObjekt_liik_id(int objekt_liik_id) {
        this.objekt_liik_id = objekt_liik_id;
    }
}
