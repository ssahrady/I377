package ee.project;

import ee.project.dao.MainDAO;
import ee.project.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private MainDAO myDAOImpl;



    public void provideDemoData() {

        //Objekti_liik
        Objekti_liik objekti_liik = new Objekti_liik();
        objekti_liik.setKood("Kood 123");
        objekti_liik.setNimetus("Objekti liik 1");
        myDAOImpl.saveObjekti_liik(objekti_liik);
        //Objekt
        Objekt objekt = new Objekt();
        objekt.setNimetus("Objekt 123");
        objekt.setObjekt_liik_id(objekti_liik.getObjekt_liik_id());
        myDAOImpl.saveObjekt(objekt);
        //Piiririkkuja
        Piiririkkuja piiririkkuja = new Piiririkkuja();
        piiririkkuja.setEesnimi("Nikolai");
        piiririkkuja.setPerek_nimi("Pahamees");
        piiririkkuja.setIsikukood("38911180247");
        piiririkkuja.setSugu("M");
        piiririkkuja.setSynniaeg(new Date());
        piiririkkuja.setObjekt_ID(objekt.getObjekt_ID());
        myDAOImpl.savePiiririkkuja(piiririkkuja);
        //Riik
        Riik riik = new Riik();
        riik.setANSI_kood("EE");
        riik.setISO_kood("EST");
        myDAOImpl.saveRiik(riik);
        //Kodakondsus
        Kodakondsus kodakondsus = new Kodakondsus();
        kodakondsus.setAlates(new Date());
        kodakondsus.setKuni(new Date());
        kodakondsus.setIsikukood("38911180247");
        Piiririkkuja piiririkkuja2 = myDAOImpl.getPiiririkkujaById(piiririkkuja.getPiiririkkuja_ID());
        kodakondsus.setPiiririkkuja_ID(piiririkkuja2);
        kodakondsus.setRiik_ID(riik.getRiik_ID());

        myDAOImpl.saveKodakondsus(kodakondsus);

    }
//    private providePseudoSeadus(){
//
//    }


    @RequestMapping(value = "/index")
    public String index (){

        int count = getMyDAOImpl().getObjektiLiikCount();
        if(count == 0){
          provideDemoData();
        }

        return "index";
    }

    @RequestMapping(value = "/objekti_liik", method = RequestMethod.GET)
    public String helloWorld(ModelMap modelMap) {
        String now = "Tere";
        modelMap.addAttribute("now", now);
        return "createObjekti_liik";
    }




    @RequestMapping(value = "/seaduse_redaktor", method = RequestMethod.GET)
    public String seaduseRedaktor(ModelMap modelMap) {

        List<Seadus> seadused = myDAOImpl.getAllSeaduse_ajalugu();
        modelMap.addAttribute("seadused", seadused);

        return "seaduse_redaktor";
    }

    @RequestMapping(value = "/seaduse_ajalugu", method = RequestMethod.GET)
    public String seaduseAjalugu(ModelMap modelMap) {
        List<Seadus> seadusList = myDAOImpl.getAllSeaduse_ajalugu();
        modelMap.addAttribute("seadused", seadusList);
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
        String now = "Tere";
        return new ModelAndView("createObjekt", "now", now);
    }
    @RequestMapping(value = "/objekt", method = RequestMethod.POST)
    public void saveObjekti(@ModelAttribute("objekt")Objekt objekt){

        int a = getMyDAOImpl().saveObjekt(objekt);

    }

    @RequestMapping(value = "/piiririkkuja", method = RequestMethod.GET)
    public String createPiiririkkuja(ModelMap modelMap) {

        List<Kodakondsus> kodakondsusList = myDAOImpl.getAllKodakondsus();

        modelMap.addAttribute("kodakondsus", kodakondsusList) ;
        return "createPiiririkkuja";
    }
    @RequestMapping(value = "/piiririkkuja/{id}", method = RequestMethod.GET)
    public String viewPiiririkkuja(ModelMap modelMap, @PathVariable int id) {

        List<Kodakondsus> kodakondsusList = myDAOImpl.getAllKodakondsus();
        Piiririkkuja piiririkkuja = myDAOImpl.getPiiririkkujaById(id);

        modelMap.addAttribute("kodakondsus", kodakondsusList);
        modelMap.addAttribute("piiririkkuja", piiririkkuja);
        return "createPiiririkkuja";
    }

    @RequestMapping(value = "/piiririkkuja/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deletePiiririkkuja(@PathVariable("id") int id) {

        Piiririkkuja piiririkkuja = myDAOImpl.getPiiririkkujaById(id);
        myDAOImpl.deletePiiririkkuja(piiririkkuja);

        return "jee";
    }

    @RequestMapping(value = "/seaduse_punkti_redaktor/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteSeaduse_punkt(@PathVariable("id") int id) {

        Seaduse_punkt seaduse_punkt = myDAOImpl.getSeaduse_punktById(id);
        myDAOImpl.deleteSeadusePunkt(seaduse_punkt);

        return "jee";
    }

    @RequestMapping(value = "/piiririkkuja/{id}", method = RequestMethod.POST)
    public String updatePiiririkkuja(ModelMap modelMap, @ModelAttribute("piiririkkuja")Piiririkkuja piiririkkuja) {

        List<Kodakondsus> kodakondsusList = myDAOImpl.getAllKodakondsus();
        Piiririkkuja dbPiiririkkuja = myDAOImpl.getPiiririkkujaById(piiririkkuja.getPiiririkkuja_ID());

        dbPiiririkkuja.setIsikukood(piiririkkuja.getIsikukood());
        dbPiiririkkuja.setEesnimi(piiririkkuja.getEesnimi());
        dbPiiririkkuja.setPerek_nimi(piiririkkuja.getPerek_nimi());
        dbPiiririkkuja.setSynniaeg(piiririkkuja.getSynniaeg());
        dbPiiririkkuja.setSugu(piiririkkuja.getSugu());
        dbPiiririkkuja.setKommentaar(piiririkkuja.getKommentaar());
        myDAOImpl.savePiiririkkuja(dbPiiririkkuja);
        modelMap.addAttribute("kodakondsus", kodakondsusList);
        modelMap.addAttribute("piiririkkuja", piiririkkuja);
        return "redirect:/piiririkkuja/"+piiririkkuja.getPiiririkkuja_ID()+".html";
    }
    @RequestMapping(value = "/piiririkkuja", method = RequestMethod.POST)
    public String savePiiririkkuja(@ModelAttribute("piiririkkuja")Piiririkkuja piiririkkuja,
                                   HttpServletRequest request){


        piiririkkuja.setPiiririkkuja_ID(0);
        //TODO avoid possible nullpointer
        piiririkkuja.setObjekt_ID(myDAOImpl.getFirstObjekt().getObjekt_ID());

        int riikID = myDAOImpl.getAllRiik().iterator().next().getRiik_ID();

        Kodakondsus kodakondsus = new Kodakondsus();
        kodakondsus.setAlates(new Date());
        kodakondsus.setKuni(new Date());
        kodakondsus.setIsikukood(piiririkkuja.getIsikukood());
        kodakondsus.setPiiririkkuja_ID(piiririkkuja);
        kodakondsus.setRiik_ID(riikID);
        //myDAOImpl.saveKodakondsus(kodakondsus);
        //piiririkkuja.getKodakondsus().add(kodakondsus);

        //myDAOImpl.saveKodakondsus(kodakondsus);
        List <Kodakondsus> kodakondsusList = new ArrayList<Kodakondsus>();
        kodakondsusList.add(kodakondsus);
        piiririkkuja.setKodakondsus(kodakondsusList);
         getMyDAOImpl().savePiiririkkuja(piiririkkuja);
        return "redirect:/piiririkkuja.html";
    }

    @RequestMapping(value = "/seaduse_redaktor", method = RequestMethod.POST)
    public String saveSeadus(@ModelAttribute("seadus")Seadus seadus){

        //myDAOImpl.getFirstObjekt().getObjekt_ID()
        myDAOImpl.saveSeadus(seadus);
      return "redirect:/seaduse_redaktor.html";
    }


    @RequestMapping(value = "/seaduse_punkti_redaktor", method = RequestMethod.GET)
    public String seadusePunktiRedaktor(ModelMap modelMap) {

         modelMap.addAttribute("seaduse_punktid",myDAOImpl.getAllSeaduse_punktid());

        return "seaduse_punkti_redaktor";
    }

    @RequestMapping(value = "/seaduse_punkti_redaktor", method = RequestMethod.POST)
    public String saveSeadusePunktiRedaktor(@ModelAttribute("seaduse_punkt")Seaduse_punkt seaduse_punkt, HttpServletResponse response) {

        List<Seadus> seadusList = myDAOImpl.getAllSeaduse_ajalugu();
        if(seadusList.size() == 0){

        }
        seaduse_punkt.setSeaduse_ID(seadusList.iterator().next().getSeaduse_ID());
        myDAOImpl.saveSeaduse_punkt(seaduse_punkt);
        return "redirect:/seaduse_punkti_redaktor.html";
    }
    @RequestMapping(value = "/seaduse_punkti_redaktor/{id}", method = RequestMethod.POST)
    public String updateSeadusePunktiRedaktor(@ModelAttribute("seaduse_punkt")Seaduse_punkt seaduse_punkt) {

        Seaduse_punkt punkt = myDAOImpl.getSeaduse_punktById(seaduse_punkt.getSeaduse_punkt_ID());
        punkt.setKehtiv_alates(seaduse_punkt.getKehtiv_alates());
        punkt.setKehtiv_kuni(seaduse_punkt.getKehtiv_kuni());
        punkt.setPais(seaduse_punkt.getPais());
        punkt.setParagrahv(seaduse_punkt.getParagrahv());

        punkt.setTekst(seaduse_punkt.getTekst());
        punkt.setYlemus_seaduse_punkt_id(seaduse_punkt.getYlemus_seaduse_punkt_id());


        List<Seadus> seadusList = myDAOImpl.getAllSeaduse_ajalugu();
        if(seadusList.size() == 0){

        }
        seaduse_punkt.setSeaduse_ID(seadusList.iterator().next().getSeaduse_ID());
        myDAOImpl.saveSeaduse_punkt(punkt);
        return "redirect:/seaduse_punkti_redaktor.html";
    }



    @RequestMapping(value = "/seaduse_punkti_redaktor/{id}", method = RequestMethod.GET)
    public String saveSeadusePunktiRedaktor(ModelMap modelMap, @PathVariable("id") int id) {
        Seaduse_punkt seaduse_punkt = myDAOImpl.getSeaduse_punktById(id);
        modelMap.addAttribute("seaduse_punkt", seaduse_punkt);
        modelMap.addAttribute("seaduse_punktid",myDAOImpl.getAllSeaduse_punktid());
        return "seaduse_punkti_redaktor";
    }
    public MainDAO getMyDAOImpl() {
        return myDAOImpl;
    }

    public void setMyDAOImpl(MainDAO myDAOImpl) {
        this.myDAOImpl = myDAOImpl;
    }
}