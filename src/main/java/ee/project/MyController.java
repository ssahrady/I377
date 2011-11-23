package ee.project;

import ee.project.dao.MainDAO;
import ee.project.dao.MainDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private MainDAO myDAOImpl;


    @RequestMapping("/hello")
    public ModelAndView helloWorld() {

        String message = "Hello World, Spring 3.0!";

        int a = getMyDAOImpl().testing();


        return new ModelAndView("hello", "message", message);
    }

    public MainDAO getMyDAOImpl() {
        return myDAOImpl;
    }

    public void setMyDAOImpl(MainDAO myDAOImpl) {
        this.myDAOImpl = myDAOImpl;
    }
}