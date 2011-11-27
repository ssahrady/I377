package ee.project.data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KODAKONDSUS")
public class Kodakondsus extends OpenableCloseable{

    private int kodakondsus_ID;
    private int piiririkkuja_ID;
    private int riik_ID;
    private String isikukood;
    private Date alates;
    private Date kuni;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "KODAKONDSUS_ID", nullable = false)
    public int getKodakondsus_ID() {
        return kodakondsus_ID;
    }

    public void setKodakondsus_ID(int kodakondsus_ID) {
        this.kodakondsus_ID = kodakondsus_ID;
    }

    @Column(name = "PIIRIRIKKUJA_ID", nullable = false)
    public int getPiiririkkuja_ID() {
        return piiririkkuja_ID;
    }

    public void setPiiririkkuja_ID(int piiririkkuja_ID) {
        this.piiririkkuja_ID = piiririkkuja_ID;
    }

    @Column(name = "RIIK_ID", nullable = false)
    public int getRiik_ID() {
        return riik_ID;
    }

    public void setRiik_ID(int riik_ID) {
        this.riik_ID = riik_ID;
    }

    @Column(name = "ISIKUKOOD")
    public String getIsikukood() {
        return isikukood;
    }

    public void setIsikukood(String isikukood) {
        this.isikukood = isikukood;
    }
    @Column(name = "ALATES")
    public Date getAlates() {
        return alates;
    }

    public void setAlates(Date alates) {
        this.alates = alates;
    }

    @Column(name = "KUNI")
    public Date getKuni() {
        return kuni;
    }

    public void setKuni(Date kuni) {
        this.kuni = kuni;
    }
}
