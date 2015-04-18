package com.philiptenn.scholarship;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="mailto:ptenn@users.noreply.github.com">Philip Tenn</a>
 */
@Controller
@RequestMapping("/goodbye")
public class GoodbyeController
{
    @RequestMapping(method = RequestMethod.GET)
    public String printGoodbye(ModelMap model) {
        model.addAttribute("message", "Goodbye Spring MVC Framework!");
        return "goodbye";
    }

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public String printWorld(ModelMap model) {
        model.addAttribute("message", "Goodbye world");
        return "goodbye";
    }



}
