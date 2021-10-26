package htw.berlin.webtech.ToDoListM1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @GetMapping(path = "/")
    public ModelAndView showHelloWorld(){
        return new ModelAndView("helloworld"); // Muss wie das HTML Template heißen in dem Fall helloworl
    }
}
