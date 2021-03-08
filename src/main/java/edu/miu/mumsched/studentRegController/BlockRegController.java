package edu.miu.mumsched.studentRegController;

import edu.miu.mumsched.domain.Block;
import edu.miu.mumsched.domain.Entry;
import edu.miu.mumsched.service.BlockServiceInterface;
import edu.miu.mumsched.service.EntryServiceIntrface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller

public class BlockRegController {

    @Autowired
    BlockServiceInterface blockServiceInterface;

    @Autowired
    EntryServiceIntrface entryServiceIntrface;

    @GetMapping("/block")
    public String getEntryRegForm(@ModelAttribute("block") Block block, Model model){

        List<Block> blockList = new ArrayList<>();
        blockList.addAll(blockServiceInterface.getAllBlock());
        System.out.println("block lists..................." + Arrays.toString(blockList.toArray()));
        List<String> entryNameList = new ArrayList<>();
        for (Entry entry: entryServiceIntrface.getAllEntry()){
            entryNameList.add(entry.getEntryName());
        }
        System.out.println("entry name list "+ Arrays.toString(entryNameList.toArray()));
        model.addAttribute("entryNameList",entryNameList);
        model.addAttribute("blockList",blockList);
        model.addAttribute("block", block);

        return "addBlockForm";


    }
    @PostMapping("/addNewBlock")
    public String registerNewBlock(@ModelAttribute("block")Block block,Model model){
        Entry entry = entryServiceIntrface.getEntryByName(block.getEntryName());
        entry.addBlock(block);
        blockServiceInterface.save(block);
        System.out.println("block " + block.toString());
        return "redirect:/block/";
    }
}
