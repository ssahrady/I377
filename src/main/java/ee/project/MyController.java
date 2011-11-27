package ee.project;

import ee.project.dao.MainDAO;
import ee.project.data.Objekt;
import ee.project.data.Objekti_liik;
import ee.project.data.Piiririkkuja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private MainDAO myDAOImpl;

    @RequestMapping(value = "/index")
    public String index (){
        return "index";
    }

    @RequestMapping(value = "/objekti_liik", method = RequestMethod.GET)
    public String helloWorld(ModelMap modelMap) {

        String message = "HelloyWaaorld, Spring 3.0!";

        String now = "Tere";
        modelMap.addAttribute("now", now);
//        return new ModelAndView("createObjekti_liik", "now", now);
        return "createObjekti_liik";
    }

    @RequestMapping(value = "/objekti_liik", method = RequestMethod.POST)
    public ModelAndView saveObjekti_liik(@ModelAttribute("objekti_liik")Objekti_liik objekti_liik){


        objekti_liik.getAvaja();
        getMyDAOImpl().saveObjekti_liik(objekti_liik);
        String now = "Tere";
        return new ModelAndView("createObjekti_liik", "now", now);

    }

    @RequestMapping(value = "/objekt", method = RequestMethod.GET)
    public ModelAndView createObjekt() {

        String message = "Hello World, Spring 3.0!";

        String now = "Tere";
        return new ModelAndView("createObjekt", "now", now);
    }
    @RequestMapping(value = "/objekt", method = RequestMethod.POST)
    public void saveObjekti(@ModelAttribute("objekt")Objekt objekt){

        int a = getMyDAOImpl().saveObjekt(objekt);

    }

    @RequestMapping(value = "/piiririkkuja", method = RequestMethod.GET)
    public ModelAndView createPiiririkkuja() {

        String message = "Hello World, Spring 3.0!";

        String now = "Tere";
        return new ModelAndView("createPiiririkkuja", "now", now);
    }
    @RequestMapping(value = "/piiririkkuja", method = RequestMethod.POST)
    public void savePiiririkkuja(@ModelAttribute("piiririkkuja")Piiririkkuja piiririkkuja){

        int a = getMyDAOImpl().savePiiririkkuja(piiririkkuja);

    }

    public MainDAO getMyDAOImpl() {
        return myDAOImpl;
    }

    public void setMyDAOImpl(MainDAO myDAOImpl) {
        this.myDAOImpl = myDAOImpl;
    }
}