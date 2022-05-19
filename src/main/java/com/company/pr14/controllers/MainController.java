package com.company.pr14.controllers;

import com.company.pr14.domain.Frame;
import com.company.pr14.domain.Lens;
import com.company.pr14.domain.Contact;
import com.company.pr14.domain.Purchase;
import com.company.pr14.repos.ContactRepo;
import com.company.pr14.repos.FrameRepo;
import com.company.pr14.repos.LensRepo;
import com.company.pr14.repos.PurchaseRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@Slf4j
public class MainController {
    private String name;
    private ArrayList req = new ArrayList<>();
    private Integer tmp;
    private String tmp2;
    private Integer idd;
    @Autowired
    private ContactRepo contactRepo;
    @Autowired
    private PurchaseRepo purchaseRepo;
    @Autowired
    private FrameRepo frameRepo;
    @Autowired
    private LensRepo lensRepo;

    public MainController() {
    }

    @GetMapping("/home")
    public String home(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        Iterable<Frame> frames = frameRepo.findAll();
        ArrayList<Frame> frames0 = new ArrayList<>();
        ArrayList<Frame> frames2 = new ArrayList<>();
        ArrayList<Frame> frames3 = new ArrayList<>();
        int k = 1;
        for (Frame i: frames)
            frames0.add(i);
        Collections.shuffle(frames0);
        for (Frame i: frames0) {
            if (k>4)
                frames3.add(i);
            else if(k<=4)
                frames2.add(i);
            if (k>7) break;
            k++;
        }
        model.addAttribute("frames", frames3);
        model.addAttribute("frames2", frames2);
        log.info("home controller: works");
        return "index";
    }
    @GetMapping("/frames")
    public String frames(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        Iterable<Frame> frames = frameRepo.findAll();
        model.addAttribute("frames", frames);
        log.info("frames controller: works");
        return "products";
    }
    @GetMapping("/frames/sunglasses")
    public String frames_sunglasses(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Сол","type");
        model.addAttribute("frames", frames);
        log.info("sunglasses post: works");
        return "products";
    }
    @GetMapping("/frames/medics")
    public String frames_medics(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Мед","type");
        model.addAttribute("frames", frames);
        log.info("medics post: works");
        return "products";
    }
    @GetMapping("/frames/men")
    public String frames_men(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("М","sex");
        model.addAttribute("frames", frames);
        log.info("men post: works");
        return "products";
    }
    @GetMapping("/frames/women")
    public String frames_women(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Ж","sex");
        model.addAttribute("frames", frames);
        log.info("women post: works");
        return "products";
    }
    @GetMapping("/frames/metal")
    public String frames_metal(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Металл","metal");
        model.addAttribute("frames", frames);
        log.info("metal post: works");
        return "products";
    }
    @GetMapping("/frames/plastic")
    public String frames_plastic(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Пластик","metal");
        model.addAttribute("frames", frames);
        log.info("plastic post: works");
        return "products";
    }
    @GetMapping("/lenses")
    public String lenses(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        Iterable<Lens> lenses = lensRepo.findAll();
        model.addAttribute("lenses", lenses);
        log.info("lenses controller: works");
        return "lens";
    }
    @GetMapping("/about")
    public String about(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        log.info("about controller: works");
        return "typo";
    }
    @GetMapping("/purchase/{id}")
    public String purchase(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("cl", "frame");
        this.idd = Integer.parseInt(id);
        log.info("purchase controller: works");
        return "register";
    }
    @GetMapping("/purchase/lens/{id}")
    public String purchaselens(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("cl", "lens");
        this.idd = Integer.parseInt(id);
        log.info("purchasing...");
        return "register";
    }
    @PostMapping("/purchase/{id}")
    public String purchasePost(@PathVariable String id, Model model, @RequestBody String name) {
        String str = name.replace ("name=", "");
        str = str = str.replace ("address=", "");
        str = str.replace ("mail=", " ");
        str = str.replace ("phone=", " ");
        str = str.replace ("=on", " ");
        str = str.replace ("&", " ");
        String str2 = str.substring(0, str.indexOf(' '));
        str = str.replace ("  ", " ");
        String[] words = str.split(" ");

        Purchase prch = new Purchase(this.idd, words[0], words[1].replace("%40", "@"), words[2], words[3], "frame");
        purchaseRepo.save(prch);
        this.tmp  = prch.getId();
        log.info("purchase frames poster: works");
        return "redirect:/purchase/finished";
    }
    @PostMapping("/purchase/lens/{id}")
    public String purchasePost2(@PathVariable String id, Model model, @RequestBody String name) {
        String str = name.replace ("name=", "");
        str = str = str.replace ("address=", "");
        str = str.replace ("mail=", " ");
        str = str.replace ("phone=", " ");
        str = str.replace ("=on", " ");
        str = str.replace ("&", " ");
        String str2 = str.substring(0, str.indexOf(' '));
        str = str.replace ("  ", " ");
        String[] words = str.split(" ");
        Purchase prch = new Purchase(this.idd, words[0], words[1].replace("%40", "@"), words[2], words[3], "lens");
        purchaseRepo.save(prch);
        this.tmp  = prch.getId();
        this.tmp2 = prch.getType();
        log.info("purchase lenses poster: works");
        return "redirect:/purchase/finished";
    }
    @GetMapping("/frames/black")
    public String frames_black(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Черный","color");
        model.addAttribute("frames", frames);
        log.info("black post: works");
        return "products";
    }
    @GetMapping("/purchase/finished")
    public String frinal(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("frames",  +this.tmp);
        log.info("purchase finished");
        return "ready";
    }
    @GetMapping("/frames/grey")
    public String frames_grey(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Серый","color");
        model.addAttribute("frames", frames);
        log.info("grey post: works");
        return "products";
    }
    @GetMapping("/frames/red")
    public String frames_red(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Красный","color");
        model.addAttribute("frames", frames);
        log.info("red post: works");
        return "products";
    }
    @GetMapping("/frames/yellow")
    public String frames_yellow(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Желтый","color");
        model.addAttribute("frames", frames);
        log.info("yellow post: works");
        return "products";
    }
    @GetMapping("/frames/brown")
    public String frames_brown(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        List<Frame> frames = frameRepo.findByName("Коричневый","color");
        model.addAttribute("frames", frames);
        log.info("brown post: works");
        return "products";
    }
    @GetMapping("/contact")
    public String contact(Model model) {
        log.info("contact controller: works");
        return "contact";
    }
    @PostMapping("/contact")
    public String contact(@RequestParam String name, @RequestParam String tel, @RequestParam String email, @RequestParam String text, Model model) {
        Contact contact = new Contact(name, tel, email, text);
        contactRepo.save(contact);
        log.info("contact poster: works");
        return "contacted";
    }
    @GetMapping("/srch/get")
    public String search(Model model) {
        ArrayList merge = new ArrayList();
        merge.addAll(frameRepo.findByName(name, "name"));
        merge.addAll(frameRepo.findByName(name.toUpperCase(), "name"));
        merge.addAll(frameRepo.findByName(name, "brand"));
        merge.addAll(lensRepo.findByName(name.toLowerCase(), "name"));
        merge.addAll(lensRepo.findByName(name, "brand"));
        model.addAttribute("merge", merge);
        log.info("search completed: works");
        return "srchres";
    }
    @PostMapping("/srch")
    public String srchpost(@RequestParam String name, Model model) {
        log.info("redirected to srch/get");
        name = name.toLowerCase();
        this.name = name;
        return "redirect:/srch/get";
    }
    @GetMapping("/frames/SEEN")
    public String frames_SEEN(Model model) {
        List<Frame> frames = frameRepo.findByName("seen","brand");
        model.addAttribute("frames", frames);
        log.info("SEEN post: works");
        return "products";
    }
    @GetMapping("/frames/DDYD")
    public String frames_DDYD(Model model) {
        List<Frame> frames = frameRepo.findByName("ddyd","brand");
        model.addAttribute("frames", frames);
        log.info("DDYD post: works");
        return "products";
    }
    @GetMapping("/frames/THEONE")
    public String frames_THEONE(Model model) {
        List<Frame> frames = frameRepo.findByName("the one","brand");
        model.addAttribute("frames", frames);
        log.info("THEONE post: works");
        return "products";
    }
    @GetMapping("/frames/UNOFFICIAL")
    public String frames_UNFOFICIAL(Model model) {
        List<Frame> frames = frameRepo.findByName("unofficial","brand");
        model.addAttribute("frames", frames);
        log.info("UNOFFICIAL post: works");
        return "products";
    }
    @GetMapping("/frames/DACKOR")
    public String frames_DACKOR(Model model) {
        List<Frame> frames = frameRepo.findByName("dackor","brand");
        model.addAttribute("frames", frames);
        log.info("DACKOR post: works");
        return "products";
    }
    @GetMapping("/frames/BLUMARINE")
    public String frames_BLUMARINE(Model model) {
        List<Frame> frames = frameRepo.findByName("blumarine","brand");
        model.addAttribute("frames", frames);
        log.info("BLUMARINE post: works");
        return "products";
    }
    @GetMapping("/lenses/hydro")
    public String lens_hydro(Model model) {
        List<Lens> lenses = lensRepo.findByName("гидрогель", "material");
        model.addAttribute("lenses", lenses);
        log.info("hydrohel post: works");
        return "lens";
    }
    @GetMapping("/lenses/sil")
    public String lens_sil(Model model) {
        List<Lens> lenses = lensRepo.findByName("силикон-гидрогель", "material");
        model.addAttribute("lenses", lenses);
        log.info("silicon post: works");
        return "lens";
    }
    @GetMapping("/lenses/single")
    public String lens_single(Model model) {
        List<Lens> lenses = lensRepo.findByName("однодневные", "type");
        model.addAttribute("lenses", lenses);
        log.info("single post: works");
        return "lens";
    }
    @GetMapping("/lenses/double")
    public String lens_double(Model model) {
        List<Lens> lenses = lensRepo.findByName("двухнедельные", "type");
        model.addAttribute("lenses", lenses);
        log.info("double post: works");
        return "lens";
    }
    @GetMapping("/lenses/iwear")
    public String lens_iwear(Model model) {
        List<Lens> lenses = lensRepo.findByName("iwear", "brand");
        model.addAttribute("lenses", lenses);
        log.info("iwear: works");
        return "lens";
    }
    @GetMapping("/lenses/alcon")
    public String lens_alcon(Model model) {
        List<Lens> lenses = lensRepo.findByName("alcon", "brand");
        model.addAttribute("lenses", lenses);
        log.info("alcon post: works");
        return "lens";
    }
    @GetMapping("/lenses/j&j")
    public String lens_jj(Model model) {
        List<Lens> lenses = lensRepo.findByName("j&j", "brand");
        model.addAttribute("lenses", lenses);
        log.info("j&j post: works");
        return "lens";
    }
    @GetMapping("/lenses/CV")
    public String lens_cv(Model model) {
        List<Lens> lenses = lensRepo.findByName("cooper vision", "brand");
        model.addAttribute("lenses", lenses);
        log.info("cooper view post: works");
        return "lens";
    }
    @GetMapping("/lenses/month")
    public String lens_month(Model model) {
        List<Lens> lenses = lensRepo.findByName("ежемесячные", "type");
        model.addAttribute("lenses", lenses);
        log.info("month post: works");
        return "lens";
    }
}