package com.semicolon.training.controller;

import com.semicolon.training.data.models.Tutorial;
import com.semicolon.training.service.TutorialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TutorialController {
    private final TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping("/tuts")
    public List<Tutorial> listTut(){
        return tutorialService.getAllTuts();
    }

    @GetMapping("/tuts/{id}")
    public Tutorial listTut(@PathVariable("id") Long id){
        return tutorialService.getAllTutsId(id);
    }

    @PostMapping("/tuts/")
    public Tutorial addTut(@RequestBody Tutorial tuts){
        return tutorialService.addTuts(tuts);
    }

    @GetMapping("/tuts/{id}")
    public Tutorial deleteTuts(@PathVariable("id") Long id){
        return tutorialService.deleteTuts(id);
    }
}
