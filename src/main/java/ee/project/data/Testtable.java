package ee.project.data;

import javax.persistence.*;

@Entity
@Table(name = "TESTTABLE")
public class Testtable {

    private int id;
    private String val;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "VAL")
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
