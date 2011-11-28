package ee.project;

import ee.project.data.OpenableCloseable;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class MyEntityInterceptor extends EmptyInterceptor {

    public boolean onSave(java.lang.Object entity, java.io.Serializable id, java.lang.Object[] state, java.lang.String[] propertyNames, org.hibernate.type.Type[] types) {

        if (entity instanceof OpenableCloseable) {
            int muutjaIndex = -1;
            int muudetudIndex = -1;
            int avajaIndex = -1;
            int avatudIndex = -1;
            int suletudIndex = -1;
            int sulgejaIndex = -1;

            for (int i = 0; i < propertyNames.length; i++) {
                String s = propertyNames[i];
                if (s.equals("muutja")) {
                    muutjaIndex = i;
                }
                if (s.equals("muudetud")) {
                    muudetudIndex = i;
                }
                if (s.equals("avaja")) {
                    avajaIndex = i;
                }
                if (s.equals("avatud")) {
                    avatudIndex = i;
                }
                if (s.equals("suletud")) {
                    suletudIndex = i;
                }
                if (s.equals("sulgeja")) {
                    sulgejaIndex = i;
                }

            }
            if (((OpenableCloseable) entity).getAvaja() == null && ((OpenableCloseable) entity).getAvatud() == null) {
                //TODO: SAVE loogika
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                state[muudetudIndex] = new Date();
                state[muutjaIndex] = auth.getName();
                state[avatudIndex] = new Date();
                state[avajaIndex] = auth.getName();
                state[suletudIndex] = getFakeDate();
                state[sulgejaIndex] = "NA";
            } else {
                //TODO : UPDATE loogika
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                state[muudetudIndex] = new Date();
                state[muutjaIndex] = auth.getName();
                state[suletudIndex] = getFakeDate();
                state[sulgejaIndex] = "NA";
            }
        }
        System.out.println("onSave");
        return true;
    }

    public boolean onFlushDirty(java.lang.Object entity, java.io.Serializable id, java.lang.Object[] currentState, java.lang.Object[] previousState, java.lang.String[] propertyNames, org.hibernate.type.Type[] types)
            throws CallbackException {

        System.out.println("onFlushDirty");


        return false;

    }

    public void onDelete(java.lang.Object entity, java.io.Serializable id, java.lang.Object[] state, java.lang.String[] propertyNames, org.hibernate.type.Type[] types) {

        //TODO: make a hack
    }

    //called before commit into database
    public void preFlush(Iterator iterator) {
        System.out.println("preFlush");
    }

    //called after committed into database
    public void postFlush(Iterator iterator) {
        System.out.println("postFlush");
    }

    private Date getFakeDate() {

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
