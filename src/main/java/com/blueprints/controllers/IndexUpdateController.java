package com.blueprints.controllers;

import com.blueprints.form.Home;
import com.blueprints.form.PostMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes(value={"statusSess", "homeSess"})
@RequestMapping("/pwp/index_update")
public class IndexUpdateController {

    @Autowired
    private Validator indexValidator;

    @InitBinder("homeForm")
    public void initBinder(WebDataBinder binder){
        binder.setValidator(indexValidator);
    }


    @RequestMapping(method= RequestMethod.GET)
    public String initForm(Model model){
        Home homeForm = new Home();
        model.addAttribute("homeForm", homeForm);
        return "index_update";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String submitForm(Model model, @ModelAttribute("homeForm") @Validated Home homeForm,
                             BindingResult binding){
        model.addAttribute("homeForm", homeForm);
        String returnVal = "index";
        if(binding.hasErrors()) {
            returnVal = "index_update";
        } else{
            model.addAttribute("homeSess", homeForm);
            model.addAttribute("statusSess", "undefault");
        }
        return returnVal;

    }
}
