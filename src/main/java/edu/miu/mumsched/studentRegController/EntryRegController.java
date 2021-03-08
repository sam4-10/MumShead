package edu.miu.mumsched.studentRegController;

import edu.miu.mumsched.domain.Entry;
import edu.miu.mumsched.repository.EntryRepositoryIntrface;
import edu.miu.mumsched.service.EntryServiceIntrface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class EntryRegController {

    @Autowired
    EntryServiceIntrface entryServiceIntrface;

    @GetMapping("/entry")
    public String getEntryRegForm(@ModelAttribute("entry")Entry entry, Model model){

        List<Entry> entryList = new ArrayList<>();
        entryList.addAll(entryServiceIntrface.getAllEntry());
        model.addAttribute("entryList",entry);
        model.addAttribute("entry", entry);

        return "addEntryForm";


    }
    @PostMapping("/addNewEntry")
    public String registerNewEntry(@ModelAttribute("entry")Entry entry,Model model){
        entryServiceIntrface.save(entry);
        System.out.println("date format " +entry.getEndDate());
        return "redirect:/entry/";
    }
}
