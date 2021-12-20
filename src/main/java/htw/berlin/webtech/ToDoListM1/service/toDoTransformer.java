package htw.berlin.webtech.ToDoListM1.service;

import htw.berlin.webtech.ToDoListM1.Persistance.ToDoEntity;
import htw.berlin.webtech.ToDoListM1.Persistance.TypeTask;
import htw.berlin.webtech.ToDoListM1.web.api.toDo;
import org.aspectj.apache.bcel.generic.Type;
import org.springframework.stereotype.Service;

@Service
public class toDoTransformer {

    public toDo transformEntity(ToDoEntity toDoEntity) {
        var typeTask = toDoEntity.getTypeTask() != null ? toDoEntity.getTypeTask().name() : TypeTask.UNKNOWN.name();
        return new toDo(
                toDoEntity.getId(),
                toDoEntity.getNameToDo(),
                toDoEntity.getDatum(),
                typeTask,
                toDoEntity.getList());


    }

}
