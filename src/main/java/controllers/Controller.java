package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping(value = "/form")
    public String getForm() {
        return "form";
    }


    @RequestMapping(value = "/checkEmail")
    public ModelAndView checkEmail(
            @RequestParam String email
    ) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Matcher matcher = pattern.matcher(email);
        boolean isValid = matcher.matches();
        if (isValid) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("result");
            modelAndView.addObject("message", "Email is valid");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("result");
            modelAndView.addObject("message", "Email is invalid");
            return modelAndView;
        }
    }
}
