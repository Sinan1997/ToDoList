/*
package m2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class toDoController {

    @Autowired
    toDoService service;

    @PostMapping("/todo")
    public toDo createtoDo(@RequestBody toDo todo){
        return service.save(todo);
    }

    @GetMapping("/things/{id}")
    public toDo gettoDo(@PathVariable String id) {
        Long toDoId = Long.parseLong(id);
        return service.get(toDoId);
    }
}
*/