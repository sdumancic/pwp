package com.blueprints.controllers;

import com.blueprints.converter.YearConverter;
import com.blueprints.form.Professional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = { "profStatusSess", "professionalSess"})
@RequestMapping("/pwp/professional_update")
public class ProfessionalUpdateController {

    @Autowired
    Validator professionalValidator;

    @InitBinder("professionalForm")
    public void initBinder(WebDataBinder binder){
        binder.setValidator(professionalValidator);
        binder.registerCustomEditor(Integer.class, "years", new YearConverter());
    }

    @RequestMapping(method= RequestMethod.GET)
    public String initForm(Model model){
        Professional professionalForm = new Professional();
        model.addAttribute("professionalForm", professionalForm);
        references(model);
        return "professional_update";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String submitForm(Model model, @ModelAttribute("professionalForm") @Validated Professional professionalForm, BindingResult binding){
        model.addAttribute("professionalForm", professionalForm);
        String returnVal = "professional";
        if(binding.hasErrors()) {
            references(model);
            returnVal = "professional_update";
        } else{
            model.addAttribute("professionalSess", professionalForm);
            model.addAttribute("profStatusSess", "undefault");
        }
        return returnVal;
    }



    public void references(Model model){
        List<String> skillSetsList = new ArrayList<String>();
        skillSetsList.add("Computer Hacking");
        skillSetsList.add("Chatting");
        skillSetsList.add("Training");
        skillSetsList.add("Selling");
        skillSetsList.add("Debating");
        skillSetsList.add("Lecturing");
        model.addAttribute("skillSetsList", skillSetsList);

        List<String> prevJobsList = new ArrayList<String>();
        prevJobsList.add("Janitor");
        prevJobsList.add("Rocketer");
        prevJobsList.add("Freelancer");
        prevJobsList.add("Dancer");
        model.addAttribute("prevJobsList", prevJobsList);

        List<String> locationList = new ArrayList<String>();
        locationList.add("Asia/Oceania");
        locationList.add("Africa");
        locationList.add("America");
        locationList.add("Europe");
        model.addAttribute("locationList", locationList);


    }
}
