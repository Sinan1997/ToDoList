package htw.berlin.webtech.ToDoListM1.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class toDoRestController {

    private List<toDo> toDos;

    public toDoRestController() {
        toDos = new ArrayList<>();
        toDos.add(new toDo(1, "MAS Hausaufgaben", "30.11.2021", false ));
        toDos.add(new toDo(1, "WebTech Hausaufgaben", "01.12.2021", true));
    }

    // api ist die öffentliche Schnittstelle unserer Anwendung
    @GetMapping(path = "/api/v1/toDos")
    public ResponseEntity<List<toDo>> fetchtoDos(){
        return ResponseEntity.ok(toDos);
    }

}

























/*
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

