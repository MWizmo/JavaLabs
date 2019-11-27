package app;
import app.models.*;
import app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private GoodsService g_service;
    @Autowired
    private TypesService t_service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Goods> goods = g_service.listAll();
        Goods g = new Goods();
        List<Types> types = t_service.listAll();
        model.addAttribute("goods", goods);
        model.addAttribute("new_good", g);
        model.addAttribute("types", types);
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveGood(@ModelAttribute("new_good") Goods g) {
        if(!g.getTitle().equals("") && g.getType()!=0 && g.getWeight()>0){
            g_service.save(g);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editGood(@ModelAttribute("Good") Goods g) {
        if(!g.getTitle().equals("") && g.getType()!=0 && g.getWeight()>0){
            g_service.edit(g);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editGood(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit");
        Goods g = g_service.getById(id);
        List<Types> types = t_service.listAll();
        mav.addObject("types", types);
        mav.addObject("Good", g);
        return mav;
    }


    @RequestMapping(value = "/delete/{id}")
    public String deleteGood(@PathVariable(name = "id") Long id) {
        g_service.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/new_type")
    public String newType(Model model) {
        Types t = new Types();
        List<Types> types = t_service.listAll();
        model.addAttribute("types", types);
        model.addAttribute("new_type", t);
        return "new_type";
    }

    @RequestMapping(value = "/add_type", method = RequestMethod.POST)
    public String addType(@ModelAttribute("new_type") Types t) {
        if(!t.getTitle().equals("")) {
            t_service.save(t);
            return "redirect:/new_type";
        }
        return "redirect:/new_type";
    }

    @RequestMapping(value = "/edit_type/{id}")
    public ModelAndView editType(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_type");
        Types t = t_service.getById(id);
        mav.addObject("type", t);
        return mav;
    }

    @RequestMapping(value = "/delete_type/{id}")
    public String deleteType(@PathVariable(name = "id") Long id) {
        t_service.delete(id);
        return "redirect:/new_type";
    }

    @RequestMapping(value = "/save_type", method = RequestMethod.POST)
    public String saveType(@ModelAttribute("type") Types t) {
        t_service.save(t);
        return "redirect:/new_type";
    }
}
