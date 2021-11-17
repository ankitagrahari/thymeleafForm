package com.dynamicallyblunt.tech.thymeleafform.controller;

import com.dynamicallyblunt.tech.thymeleafform.beans.Controls;
import com.dynamicallyblunt.tech.thymeleafform.beans.EvaluateArgument;
import com.dynamicallyblunt.tech.thymeleafform.beans.RemediateArgument;
import com.dynamicallyblunt.tech.thymeleafform.beans.Script;
import com.dynamicallyblunt.tech.thymeleafform.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    Utility utility;

    @GetMapping("/")
    public String getForm(Controls controls){
        return "registration";
    }

    @PostMapping("/saveControls")
    public String saveControl(Controls controls, Errors errors, Model model){
        if(null!=errors && errors.getErrorCount()>0){
            errors.getAllErrors().forEach(a -> System.out.println(a.getDefaultMessage()));
            return "registration";
        } else {
            System.out.println(controls);
            model.addAttribute("successMsg", "Control Saved Successfully");
            return "success";
        }
    }

    @PostMapping(value = "/saveControls", params = {"addEvaluateArgs"})
    public String addEvaluateArgument(Controls controls, BindingResult bindingResult){
        if(null!=controls){
            if(null==controls.getEvaluateArguments()){
                List<EvaluateArgument> evArgList = new ArrayList<>();
                evArgList.add(new EvaluateArgument());
                controls.setEvaluateArguments(evArgList);
            } else {
                controls.getEvaluateArguments().add(new EvaluateArgument());
            }
        }
        return "registration";
    }

    @PostMapping(value = "/saveControls", params = {"removeEvaluateArgs"})
    public String removeEvaluateArgument(Controls controls, BindingResult bindingResult, HttpServletRequest request){
        controls.getEvaluateArguments().remove(Integer.parseInt(request.getParameter("removeEvaluateArgs")));
        return "registration";
    }

    @PostMapping(value = "/saveControls", params = {"addRemediateArgs"})
    public String addRemediateArgument(Controls controls, BindingResult bindingResult){
        if(null!=controls){
            if(null==controls.getRemediateArguments()){
                List<RemediateArgument> remArgList = new ArrayList<>();
                remArgList.add(new RemediateArgument());
                controls.setRemediateArguments(remArgList);
            } else {
                controls.getRemediateArguments().add(new RemediateArgument());
            }
        }
        return "registration";
    }

    @PostMapping(value = "/saveControls", params = {"removeRemediateArgs"})
    public String removeRemediateArgument(Controls controls, BindingResult bindingResult, HttpServletRequest request){
        controls.getRemediateArguments().remove(Integer.parseInt(request.getParameter("removeRemediateArgs")));
        return "registration";
    }

    @PostMapping(value = "/saveControls", params = {"addScript"})
    public String addScript(Controls controls, BindingResult bindingResult){
        if(null!=controls){
            if(null==controls.getScripts()){
                List<Script> scriptList = new ArrayList<>();
                scriptList.add(new Script());
                controls.setScripts(scriptList);
            } else {
                controls.getScripts().add(new Script());
            }
        }
        return "registration";
    }

    @PostMapping(value = "/saveControls", params = {"removeScript"})
    public String removeScript(Controls controls, BindingResult bindingResult, HttpServletRequest request){
        controls.getScripts().remove(Integer.parseInt(request.getParameter("removeScript")));
        return "registration";
    }

}
