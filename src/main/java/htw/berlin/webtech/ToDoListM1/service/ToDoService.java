package htw.berlin.webtech.ToDoListM1.service;

import htw.berlin.webtech.ToDoListM1.Persistance.ToDoEntity;
import htw.berlin.webtech.ToDoListM1.Persistance.ToDoRepository;
import htw.berlin.webtech.ToDoListM1.web.api.toDo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

   public ToDoService(ToDoRepository toDoRepository){
       this.toDoRepository = toDoRepository;
    }

    public List<toDo> findAll(){
       List<ToDoEntity> toDos = toDoRepository.findAll();
       return toDos.stream()
               .map(toDoEntity -> new toDo(
               toDoEntity.getId(),
               toDoEntity.getNameToDo(),
               toDoEntity.getDatum(),
               toDoEntity.getComplete()
       ))
               .collect(Collectors.toList());

    }
}
