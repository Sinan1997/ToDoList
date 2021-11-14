package htw.berlin.webtech.ToDoListM1.service;

import htw.berlin.webtech.ToDoListM1.Persistance.toDoEntity;
import htw.berlin.webtech.ToDoListM1.Persistance.toDoRepository;
import htw.berlin.webtech.ToDoListM1.web.api.toDo;

import java.util.List;
import java.util.stream.Collectors;

public class ToDoService {

    private final toDoRepository toDoRepository;

   public ToDoService(toDoRepository toDoRepository){
       this.toDoRepository = toDoRepository;
    }

    public List<toDo> findAll(){
       List<toDoEntity> toDos = toDoRepository.findAll();
       return toDos.stream().map(toDoEntity -> new toDo(
               toDoEntity.getId(),
               toDoEntity.getNameToDo(),
               toDoEntity.getDatum(),
               toDoEntity.getComplete()
       ))
               .collect(Collectors.toList());

    }
}
