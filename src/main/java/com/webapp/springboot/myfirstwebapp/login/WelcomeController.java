package com.webapp.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

   // private AuthenticationService authenticationService;

    //public WelcomeController(AuthenticationService authenticationService) {
     //   super();
   //     this.authenticationService = authenticationService;
   // }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name",getLoggedInUserName());
        return "welcome";
    }
    private String getLoggedInUserName(){
        Authentication authentication =
        SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


}