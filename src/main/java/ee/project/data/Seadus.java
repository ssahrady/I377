package ee.project.data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SEADUS")
public class Seadus extends OpenableCloseable {

    private int seaduse_ID;
    private String nimetus;
    private  String kood;
    private Date kehtiv_alates;
    private Date kehtiv_kuni;
    private List<Seaduse_punkt> seaduse_punkts;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SEADUSE_ID")
    public int getSeaduse_ID() {
        return seaduse_ID;
    }

    public void setSeaduse_ID(int seaduse_ID) {
        this.seaduse_ID = seaduse_ID;
    }

    @Column(name = "NIMETUS")
    public String getNimetus() {
        return nimetus;
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
    @Column(name = "KEHTIV_ALATES")
    public Date getKehtiv_alates() {
        return kehtiv_alates;
    }

    public void setKehtiv_alates(Date kehtiv_alates) {
        this.kehtiv_alates = kehtiv_alates;
    }
    @Column(name = "KEHTIV_KUNI")
    public Date getKehtiv_kuni() {
        return kehtiv_kuni;
    }

    public void setKehtiv_kuni(Date kehtiv_kuni) {
        this.kehtiv_kuni = kehtiv_kuni;
    }

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Seaduse_punkt.class /*cascade=CascadeType.ALL*/)
    @JoinColumn(name = "SEADUSE_ID", referencedColumnName = "SEADUSE_ID")
    public List<Seaduse_punkt> getSeaduse_punkts() {
        return seaduse_punkts;
    }

    public void setSeaduse_punkts(List<Seaduse_punkt> seaduses) {
        this.seaduse_punkts = seaduses;
    }
}
