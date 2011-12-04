package ee.project;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 12/4/11
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Seaduse_punktSimplified {



    private int id;
    private String punkt;
    private String alates;
    private String kuni;

    public Seaduse_punktSimplified(int id, String punkt, String alates, String kuni){
        this.id= id;
        this.punkt = punkt;
        this.alates = alates;
        this.kuni = kuni;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPunkt() {
        return punkt;
    }

    public void setPunkt(String punkt) {
        this.punkt = punkt;
    }

    public String getAlates() {
        return alates;
    }

    public void setAlates(String alates) {
        this.alates = alates;
    }

    public String getKuni() {
        return kuni;
    }

    public void setKuni(String kuni) {
        this.kuni = kuni;
    }
}
