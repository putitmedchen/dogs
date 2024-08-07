package com.example.dogs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public  String greeting() {
        return "Hello, World";
    }

    @RequestMapping(value = "/bark", method = RequestMethod.GET)
    @ResponseBody
    public  String barking() {
        return "Hark! Hark! The Dogs Do Bark\n" +
                "Nursery Rhyme\n" +
                "Hark! hark! the dogs do bark,\n" +
                "The beggars are coming to town;\n" +
                "Some in rags and some in tags,\n" +
                "And some in silken gowns.*\n" +
                "\n" +
                "Some gave them white bread,\n" +
                "And some gave them brown,\n" +
                "And some gave them a good horse-whip,\n" +
                "And sent them out of the town.";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public  String addDog() {
        return "Hello, World";
    }

}
