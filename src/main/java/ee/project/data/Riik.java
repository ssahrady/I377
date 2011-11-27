package ee.project.data;


import javax.persistence.*;

@Entity
@Table(name = "RIIK")
public class Riik extends OpenableCloseable{

    private String ISO_kood;
    private String ANSI_kood;
    private int riik_ID;


    @Column(name = "ISO_KOOD")
    public String getISO_kood() {
        return ISO_kood;
    }

    public void setISO_kood(String ISO_kood) {
        this.ISO_kood = ISO_kood;
    }

    @Column(name = "ANSI_KOOD")
    public String getANSI_kood() {
        return ANSI_kood;
    }

    public void setANSI_kood(String ANSI_kood) {
        this.ANSI_kood = ANSI_kood;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "RIIK_ID")
    public int getRiik_ID() {
        return riik_ID;
    }

    public void setRiik_ID(int riik_ID) {
        this.riik_ID = riik_ID;
    }
}
