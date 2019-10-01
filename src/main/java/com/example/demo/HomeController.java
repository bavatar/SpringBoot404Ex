package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;
    //MessageRepository messageRepository;

    @RequestMapping("/")
    public String listCars(Model model){
        // Notes on Bullhorn
        // public String messageList(model model, String search) {
        //      model.addAttribute("messages", messageRepository.findAll(); // returns all
        //      return "list";
        model.addAttribute("cars", carRepository.findAll());
        return "list";
    }
    // Notes on Bullhorn
    //@GetMapping("/add")
    // public String addMessage(Model model) {
    //  model.addAtribute("message", new Message());
    // return "messageform";

    //@PostMapping("/processSearch")
    //public String searchResult(Model model, String search) {
    //      model.addAttribute("messagesByTitle", carRepository.findByTitle(search));
    //      return "searchlist";
    //}

    // @PostMapping("/processMessage")
    // public String processForm(@ModelAttribute Message message}
    //      messageRepository.save(message);
    //      return "redirect:/"; // to update list
    //}

    @GetMapping("/add")
    public String carForm(Model model){
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Car car, BindingResult result){
        if (result.hasErrors()){
            return "carform";
        }
        carRepository.save(car);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "carform";
    }

    @RequestMapping("/delete/{id}")
    public String delCar(@PathVariable("id") long id){
        carRepository.deleteById(id);
        return "redirect:/";
    }


}
