package com.zdatainc.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by demo on 7/21/16.
 */
@Controller
public class WebController {
    @RequestMapping("/")
    String index() {
        return "index";
    }
}
