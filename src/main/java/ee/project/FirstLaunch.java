package ee.project;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;

public class FirstLaunch implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ServletContextListener started");

       java.util.Map<java.lang.String,java.lang.String> map = System.getenv();
        System.out.print("asd");
        String userHome = System.getProperty("user.home");
         try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection c = null;

        try{
        c = DriverManager.getConnection(
                 "jdbc:hsqldb:file:"+userHome+"/Team17/db;shutdown=true", "SA", "");

            //c.setAutoCommit(false);
//            PreparedStatement statement = c.prepareStatement(Piir.SQL);
//
//            statement.executeUpdate();
//            c.commit();
            Statement statement  = c.createStatement();
            statement.execute(Piir.SQL);
            c.close();



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

