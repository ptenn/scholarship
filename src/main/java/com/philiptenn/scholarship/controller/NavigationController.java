package com.philiptenn.scholarship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="mailto:ptenn@users.noreply.github.com">Philip Tenn</a>
 */
@Controller
public class NavigationController {

    @RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
