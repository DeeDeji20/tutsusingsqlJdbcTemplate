package com.semicolon.training.controller;

import com.semicolon.training.data.models.Tutorial;
import com.semicolon.training.service.TutorialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("api/v1/")
public class TutorialController {
    @Autowired
    private final TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping("/tuts")
    public List<Tutorial> listTut(){
        return tutorialService.getAllTuts();
    }

    @GetMapping("/tuts/{id}")
    public Optional<Tutorial> listTut(@PathVariable("id") Long id){
        try{
            return tutorialService.getutsById(id);
        }catch (NoSuchElementException e){
            log.info(e.getMessage());
            throw new NoSuchElementException("Not found");
        }
    }


    @PostMapping("/tuts/")
    public int addTut(@RequestBody Tutorial tuts){
        return tutorialService.addTuts(tuts);
    }

    @DeleteMapping("/tuts/{id}")
    public void deleteTuts(@PathVariable("id") Long id){
        tutorialService.deleteTuts(id);
    }
}
