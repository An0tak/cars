package com.cars.controllers;

import com.cars.models.Car;
import com.cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class MainController {
    private CarService carService;

    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String index(Model model, String orderby, String orderbyhow) {

        model.addAttribute("carlist", carService.orderByName());
        return "index";
    }

    @PostMapping("/order")
    public String order(String orderby, String order, Model model) {
        if (orderby.equals("power") && order.equals("asc")) {
            model.addAttribute("carlist", carService.lowestPowerFirst());
            return "index";
        } else if (orderby.equals("power") && order.equals("desc")) {
            model.addAttribute("carlist", carService.highestPowerFirst());
            return "index";
        } else if (orderby.equals("price") && order.equals("asc")) {
            model.addAttribute("carlist", carService.cheapestFirst());
            return "index";
        } else if (orderby.equals("price") && order.equals("desc")) {
            model.addAttribute("carlist", carService.expensiveFirst());
            return "index";
        } else if (orderby.equals("make") && order.equals("asc")) {
            model.addAttribute("carlist", carService.orderByName());
            return "index";
        } else if (orderby.equals("weight") && order.equals("asc")) {
            model.addAttribute("carlist", carService.orderByWeightAsc());
            return "index";
        } else if (orderby.equals("weight") && order.equals("desc")) {
            model.addAttribute("carlist", carService.orderByWeightDesc());
            return "index";
        }

        return "index";
    }


    @GetMapping("/addcar")
    public String addcars() {

        return "addcar";
    }


    @PostMapping("/addcar")
    public RedirectView addcar(Car car) {
        carService.save(car);
        return new RedirectView("/");
    }

    @GetMapping("/editcar")
    public String editcars(@RequestParam Long id, Model model) {
        model.addAttribute("car", carService.getById(id));
        return "editcar";
    }

    @PutMapping("/editcar")
    public RedirectView editcar(@RequestParam Long id, Car car) {
        carService.save(car);

        return new RedirectView("/");
    }
}