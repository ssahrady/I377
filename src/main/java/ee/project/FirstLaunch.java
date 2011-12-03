package ee.project;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FirstLaunch implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ServletContextListener started");


         try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection c = null;

        try{
        c = DriverManager.getConnection(
                 "jdbc:hsqldb:file:${user.home}/Team17/db2;", "SA", "");

            c.setAutoCommit(false);
            PreparedStatement statement = c.prepareStatement(Piir.SQL);

            statement.executeUpdate();
            c.commit();



        } catch(Exception e){

            System.out.print("err");
        } finally {

            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
}


}

