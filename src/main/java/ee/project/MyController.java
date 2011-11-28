package ee.project;

import ee.project.dao.MainDAO;
import ee.project.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private MainDAO myDAOImpl;

    @RequestMapping(value = "/index")
    public String index (){

        Riik riik = new Riik();
        riik.setANSI_kood("EE");
        riik.setISO_kood("EST");
        riik.setAvaja("asd");
        riik.setAvatud(new Date());
        riik.setMuudetud(new Date());
        riik.setMuutja("adsds");
        riik.setSulgeja("asd");
        riik.setSuletud(new Date());

        myDAOImpl.saveRiik(riik);

        Kodakondsus kodakondsus = new Kodakondsus();
        kodakondsus.setAlates(new Date());
        kodakondsus.setKuni(new Date());
        kodakondsus.setIsikukood("38911180247");
        kodakondsus.setPiiririkkuja_ID(100);
        kodakondsus.setRiik_ID(riik.getRiik_ID());
        kodakondsus.setAvaja("jarko");
        kodakondsus.setAvatud(new Date());
        kodakondsus.setMuudetud(new Date());
        kodakondsus.setMuutja("asd");
        kodakondsus.setSuletud(new Date());
        kodakondsus.setSulgeja("jarks");
        myDAOImpl.saveKodakondsus(kodakondsus);


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


    @RequestMapping(value = "/seaduse_punkti_redaktor")
    public String seadusePunktiRedaktor(ModelMap modelMap) {
        return "seaduse_punkti_redaktor";
    }

    @RequestMapping(value = "/seaduse_redaktor")
    public String seaduseRedaktor(ModelMap modelMap) {
        return "seaduse_redaktor";
    }

    @RequestMapping(value = "/seaduse_ajalugu")
    public String seaduseAjalugu(ModelMap modelMap) {
        return "seaduse_ajalugu";
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
    public String createPiiririkkuja(ModelMap modelMap) {

        String message = "Hello World, Spring 3.0!";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Kodakondsus> kodakondsusList = myDAOImpl.getAllKodakondsus();

        modelMap.addAttribute("kodakondsus", kodakondsusList) ;
        return "createPiiririkkuja";
    }
    @RequestMapping(value = "/piiririkkuja", method = RequestMethod.POST)
    public String savePiiririkkuja(@ModelAttribute("piiririkkuja")Piiririkkuja piiririkkuja,
                                   Principal principal){

        int a = getMyDAOImpl().savePiiririkkuja(piiririkkuja);
        //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user = principal.getName();

        Kodakondsus kodakondsus = new Kodakondsus();
        kodakondsus.setAlates(new Date());
        kodakondsus.setKuni(new Date());
        kodakondsus.setIsikukood(piiririkkuja.getIsikukood());
        kodakondsus.setPiiririkkuja_ID(piiririkkuja.getPiiririkkuja_ID());
        kodakondsus.setRiik_ID(1);
        kodakondsus.setAvaja(user);
        kodakondsus.setAvatud(new Date());
        kodakondsus.setMuudetud(new Date());
        kodakondsus.setMuutja(user);
        kodakondsus.setSuletud(new Date());
        kodakondsus.setSulgeja("jarks");
        myDAOImpl.saveKodakondsus(kodakondsus);

        return "redirect:/piiririkkuja.html";
    }

    public MainDAO getMyDAOImpl() {
        return myDAOImpl;
    }

    public void setMyDAOImpl(MainDAO myDAOImpl) {
        this.myDAOImpl = myDAOImpl;
    }
}