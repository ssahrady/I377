package ee.project.data;

import javax.persistence.*;

@Entity
@Table(name = "SEADUSE_PUNKT")
public class Seaduse_punkt extends OpenableCloseable{


    private int seaduse_punkt_ID;

   // private Seadus seadus;

    private String paragrahv;
    private String pais;
    private String tekst;
    private String kehtiv_alates;
    private String kehtiv_kuni;
    private int ylemus_seaduse_punkt_id;
    private int seaduse_ID;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SEADUSE_PUNKT_ID")
    public int getSeaduse_punkt_ID() {
        return seaduse_punkt_ID;
    }

    public void setSeaduse_punkt_ID(int seaduse_punkt_ID) {
        this.seaduse_punkt_ID = seaduse_punkt_ID;
    }
//    @ManyToOne
//    @JoinColumn(mappedBy = "SEADUSE_ID", insertable = false, updatable = false)
//    public Seadus getSeadus() {
//        return seadus;
//    }
//
//    public void setSeadus(Seadus seadus) {
//        this.seadus = seadus;
//    }

    @Column(name = "PARAGRAHV")
    public String getParagrahv() {
        return paragrahv;
    }

    public void setParagrahv(String paragrahv) {
        this.paragrahv = paragrahv;
    }

    @Column(name = "PAIS")
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Column(name = "TEKST")
    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    @Column(name = "KEHTIV_ALATES")
    public String getKehtiv_alates() {
        return kehtiv_alates;
    }

    public void setKehtiv_alates(String kehtiv_alates) {
        this.kehtiv_alates = kehtiv_alates;
    }

    @Column(name = "KEHTIV_KUNI")
    public String getKehtiv_kuni() {
        return kehtiv_kuni;
    }

    public void setKehtiv_kuni(String kehtiv_kuni) {
        this.kehtiv_kuni = kehtiv_kuni;
    }

    @Column(name = "YLEMUS_SEADUSE_PUNKT_ID")
    public int getYlemus_seaduse_punkt_id() {
        return ylemus_seaduse_punkt_id;
    }

    public void setYlemus_seaduse_punkt_id(int ylemus_seaduse_punkt_id) {
        this.ylemus_seaduse_punkt_id = ylemus_seaduse_punkt_id;
    }
    @Column(name = "SEADUSE_ID")
    public int getSeaduse_ID() {
        return seaduse_ID;
    }

    public void setSeaduse_ID(int seaduse_ID) {
        this.seaduse_ID = seaduse_ID;
    }

}
