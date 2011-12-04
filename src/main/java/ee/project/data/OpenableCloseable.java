package ee.project.data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedSuperclass
public class OpenableCloseable implements Serializable {

    private static final long serialVersionUID = 1L;

    private String avaja;
    private Date avatud;
    private String muutja;
    private Date muudetud;
    private String sulgeja;
    private Date suletud;
    private String kommentaar;

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

    @Column(name = "KOMMENTAAR")
    public String getKommentaar() {
        return kommentaar;
    }


    public void setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
    }

}
