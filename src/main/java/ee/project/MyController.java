package ee.project;

import com.sun.org.apache.xpath.internal.operations.Mod;
import ee.project.dao.MainDAO;
import ee.project.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestHandler;
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

    @RequestMapping(value = "/login*", method = RequestMethod.GET)
    public String login(HttpServletRequest req, ModelMap modelMap){
        System.out.print("asd");
        if("fail".equals(req.getParameter("login"))){
            modelMap.addAttribute("fail", 1);
        }
        modelMap.addAttribute("url", req.getContextPath());
        return "login";
    }


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
    public String index (HttpServletRequest req, ModelMap modelMap){
        modelMap.addAttribute("url", req.getContextPath());
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
    public String seaduseRedaktor(HttpServletRequest req, ModelMap modelMap) {

        List<Seadus> seadused = myDAOImpl.getAllSeaduse_ajalugu();
        modelMap.addAttribute("url", req.getContextPath());
        modelMap.addAttribute("seadused", seadused);

        return "seaduse_redaktor";
    }

    @RequestMapping(value = "/seaduse_ajalugu", method = RequestMethod.GET)
    public String seaduseAjalugu(HttpServletRequest req, ModelMap modelMap) {
        List<Seadus> seadusList = myDAOImpl.getAllSeaduse_ajalugu();
        modelMap.addAttribute("url", req.getContextPath());
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
    public String createPiiririkkuja(HttpServletRequest req, ModelMap modelMap) {

        List<Kodakondsus> kodakondsusList = myDAOImpl.getAllKodakondsus();
        modelMap.addAttribute("url", req.getContextPath());
        modelMap.addAttribute("kodakondsus", kodakondsusList) ;
        return "createPiiririkkuja";
    }
    @RequestMapping(value = "/piiririkkuja/{id}", method = RequestMethod.GET)
    public String viewPiiririkkuja(HttpServletRequest req, ModelMap modelMap, @PathVariable int id) {

        List<Kodakondsus> kodakondsusList = myDAOImpl.getAllKodakondsus();
        Piiririkkuja piiririkkuja = myDAOImpl.getPiiririkkujaById(id);

        modelMap.addAttribute("url", req.getContextPath());
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
    public String updatePiiririkkuja(ModelMap modelMap, @ModelAttribute("piiririkkuja")Piiririkkuja piiririkkuja, HttpServletRequest request) {

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
    public String seadusePunktiRedaktor(HttpServletRequest req, ModelMap modelMap) {

        modelMap.addAttribute("seaduse_punktid",myDAOImpl.getAllSeaduse_punktid());
        modelMap.addAttribute("url", req.getContextPath());
        return "seaduse_punkti_redaktor";
    }

    @RequestMapping(value = "/seaduse_punkti_redaktor", method = RequestMethod.POST)
    public String saveSeadusePunktiRedaktor(@ModelAttribute("seaduse_punkt")Seaduse_punkt seaduse_punkt, HttpServletResponse response) {

        List<Seadus> seadusList = myDAOImpl.getAllSeaduse_ajalugu();
        seaduse_punkt.setSeaduse_ID(seadusList.iterator().next());
        seaduse_punkt.setSeaduse_punkt_ID(0);
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
        seaduse_punkt.setSeaduse_ID(seadusList.iterator().next());
        myDAOImpl.saveSeaduse_punkt(punkt);
        return "redirect:/seaduse_punkti_redaktor.html";
    }



    @RequestMapping(value = "/seaduse_punkti_redaktor/{id}", method = RequestMethod.GET)
    public String saveSeadusePunktiRedaktor(HttpServletRequest req, ModelMap modelMap, @PathVariable("id") int id) {
        Seaduse_punkt seaduse_punkt = myDAOImpl.getSeaduse_punktById(id);
        modelMap.addAttribute("url", req.getContextPath());
        modelMap.addAttribute("seaduse_punkt", seaduse_punkt);
        modelMap.addAttribute("seaduse_punktid",myDAOImpl.getAllSeaduse_punktid());
        return "seaduse_punkti_redaktor";
    }

    @RequestMapping(value="/seaduse_ajalugu/{id}", method=RequestMethod.GET)
    public @ResponseBody ModelMap getAjaluguPunktidById(@RequestParam String name) {
        ModelMap modelMap = new ModelMap();
        int id = Integer.parseInt(name);

        List<Seaduse_punkt> seaduse_punktList= myDAOImpl.getSeaduse_punktBySeadusId(id);



//        modelMap.addAttribute("seadusePunktid", seaduse_punktList);
        List<Seaduse_punktSimplified> simplifieds = new ArrayList<Seaduse_punktSimplified>();
        int i=1;
        for(Seaduse_punkt punkt: seaduse_punktList){
            Seaduse_punktSimplified simplified =
                    new Seaduse_punktSimplified
                            (punkt.getSeaduse_punkt_ID(),
                            punkt.getPais(),
                                    punkt.getKehtiv_alates(), punkt.getKehtiv_kuni());
           // modelMap.addAttribute(""+i, simplified);
           simplifieds.add(simplified);
            i++;

        }
        modelMap.addAttribute("seadused",simplifieds);
        modelMap.addAttribute("asd", 123);
        return modelMap;
    }



    public MainDAO getMyDAOImpl() {
        return myDAOImpl;
    }

    public void setMyDAOImpl(MainDAO myDAOImpl) {
        this.myDAOImpl = myDAOImpl;
    }
}