package htw.berlin.webtech.ToDoListM1.web;

import htw.berlin.webtech.ToDoListM1.Persistance.ToDoRepository;
import htw.berlin.webtech.ToDoListM1.service.ToDoService;
import htw.berlin.webtech.ToDoListM1.web.api.toDo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class toDoRestController {


    private final ToDoService toDoService;

    public toDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;


    }

    // api ist die öffentliche Schnittstelle unserer Anwendung
    @GetMapping(path = "/api/v1/toDos")
    public ResponseEntity<List<toDo>> fetchtoDos(){
        return ResponseEntity.ok(toDoService.findAll());
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

