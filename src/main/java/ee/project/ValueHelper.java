package ee.project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 11/29/11
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValueHelper {

    public static String convertDateString(String in) {

        if(in == null  || "".equals(in) ){
            return "";
        }
        String inDate = in.substring(0,10);
        inDate = inDate.replace("-","/");

        return inDate;
    }

    public static Date getFakeDate() {

        int year = 9999;
        int month = 12;
        int day = 12;
        String date = year + "/" + month + "/" + day;
        java.util.Date utilDate = null;

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            utilDate = formatter.parse(date);

        } catch (ParseException e) {

        }

        return utilDate;

    }

}
