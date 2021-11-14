package htw.berlin.webtech.ToDoListM1.web;

import htw.berlin.webtech.ToDoListM1.Persistance.ToDoRepository;
import htw.berlin.webtech.ToDoListM1.service.ToDoService;
import htw.berlin.webtech.ToDoListM1.web.api.toDo;
import htw.berlin.webtech.ToDoListM1.web.api.toDoCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping(path = "/api/v1/toDos/{id}")
    public ResponseEntity<toDo> fetchtoDoById(@PathVariable Long id){
        var toDo = toDoService.findById(id);
        return toDo != null? ResponseEntity.ok(toDo) : ResponseEntity.notFound().build();

    }

    @PostMapping(path = "/api/v1/toDos")
    public ResponseEntity<Void> createToDo(@RequestBody toDoCreateRequest request) throws URISyntaxException {
        var toDo = toDoService.create(request);
        URI uri = new URI("/api/v1/toDos/" + toDo.getId());
        return ResponseEntity.created(uri).build();

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

