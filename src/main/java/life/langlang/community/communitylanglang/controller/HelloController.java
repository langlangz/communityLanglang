package life.langlang.community.communitylanglang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-02 15:07
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "index";

    }
}
