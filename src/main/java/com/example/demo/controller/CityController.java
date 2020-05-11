package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class CityController {
    @Autowired
    private CityService cs;

    private static final Logger logger= LoggerFactory.getLogger(CityController.class);

    @GetMapping(value = {"/city", "/"})
    public String findall(Model model) {
        List<City> list = cs.findAll();
        model.addAttribute("citylist", list);
        return "getall";
    }

    @GetMapping(value = "/city/{id}")
    public String findById(@PathVariable String id, Model model) {
        Long Id = Long.parseLong(id);
        City city = cs.findById(Id);
        model.addAttribute("city", city);
        return "show";
    }

    //    @PostMapping("/city")
    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public String updateCity(City city) {
        cs.insertCity(city);
        return "redirect:/";
    }

    @PutMapping("/city")
    public String update(City city) {
        cs.updateById(city);
        return "redirect:/";
    }

    @DeleteMapping("/city/{id}")
    public String delete(@PathVariable("id") Long id) {
        cs.deleteById(id);
        return "redirect:/";
    }

}
