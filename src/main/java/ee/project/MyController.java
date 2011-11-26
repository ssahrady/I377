package ee.project;

import ee.project.dao.MainDAO;
import ee.project.dao.MainDAOImpl;
import ee.project.data.Objekti_liik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private MainDAO myDAOImpl;


    @RequestMapping("/hello")
    public ModelAndView helloWorld() {

        String message = "HelloWorld, Spring 3.0!";

        //int a = getMyDAOImpl().makeObjekti_liik();

        String now = "Tere";
        return new ModelAndView("hello", "now", now);
    }

    @RequestMapping(value = "/objekti_liik", method = RequestMethod.POST)
    public void saveObjekti_liik(@ModelAttribute("objekti_liik")Objekti_liik objekti_liik){


        objekti_liik.getAvaja();
        getMyDAOImpl().makeObjekti_liik(objekti_liik);

    }

    public MainDAO getMyDAOImpl() {
        return myDAOImpl;
    }

    public void setMyDAOImpl(MainDAO myDAOImpl) {
        this.myDAOImpl = myDAOImpl;
    }
}