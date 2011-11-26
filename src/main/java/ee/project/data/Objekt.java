package ee.project.data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "OBJEKT")
public class Objekt {

  private String avaja;
    private Date avatud;
    private String muutja;
    private Date muudetud;
    private String sulgeja;
    private Date suletud;
    private String nimetus;
    private String kommentaar;
    private int objekt_ID;
    private int objekti_liik_id;


    @Column(name = "AVAJA" , nullable = false)
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

    @Id
    @GeneratedValue
    @Column(name = "OBJEKT_ID", nullable = false)
    public int getObjekt_ID() {
        return objekt_ID;
    }

    public void setObjekt_ID(int objekt_ID) {
        this.objekt_ID = objekt_ID;
    }

    @Column(name = "OBJEKTI_LIIK_ID", nullable = false)
    public int getObjekti_liik_id() {
        return objekti_liik_id;
    }

    public void setObjekti_liik_id(int objekti_liik_id) {
        this.objekti_liik_id = objekti_liik_id;
    }
}
