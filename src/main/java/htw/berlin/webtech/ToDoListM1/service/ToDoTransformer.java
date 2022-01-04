package htw.berlin.webtech.ToDoListM1.service;

import htw.berlin.webtech.ToDoListM1.Persistance.ToDoEntity;
import htw.berlin.webtech.ToDoListM1.Persistance.TypeTask;
import htw.berlin.webtech.ToDoListM1.web.api.ToDo;
import org.springframework.stereotype.Service;

@Service
public class ToDoTransformer {

    public ToDo transformEntity(ToDoEntity toDoEntity) {
        var typeTask = toDoEntity.getTypeTask() != null ? toDoEntity.getTypeTask().name() : TypeTask.UNKNOWN.name();
        return new ToDo(
                toDoEntity.getId(),
                toDoEntity.getNameToDo(),
                toDoEntity.getDatum(),
                typeTask);
    }

}
