package htw.berlin.webtech.ToDoListM1.service;

import htw.berlin.webtech.ToDoListM1.Persistance.ToDoEntity;
import htw.berlin.webtech.ToDoListM1.Persistance.ToDoRepository;
import htw.berlin.webtech.ToDoListM1.web.api.toDo;
import htw.berlin.webtech.ToDoListM1.web.api.toDoCreateUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<toDo> findAll() {
        List<ToDoEntity> toDos = toDoRepository.findAll();
        return toDos.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public toDo findById(Long id) {
        var toDoEntity = toDoRepository.findById(id);
        return toDoEntity.map(this::transformEntity).orElse(null);
    }

    public toDo create(toDoCreateUpdateRequest request) {
        var toDoEntity = new ToDoEntity(request.getNameToDo(), request.getDatum(), request.isComplete());
        toDoEntity = toDoRepository.save(toDoEntity);
        return transformEntity(toDoEntity);
    }

    public toDo update(Long id, toDoCreateUpdateRequest request) {
        var toDoEntityOptional = toDoRepository.findById(id);
        if (toDoEntityOptional.isEmpty()) {
            return null;
        }

        var toDoEntity = toDoEntityOptional.get();
        toDoEntity.setNameToDo(request.getNameToDo());
        toDoEntity.setDatum(request.getDatum());
        toDoEntity.setComplete(request.isComplete());
        toDoEntity = toDoRepository.save(toDoEntity);
        return transformEntity(toDoEntity);
    }

    private toDo transformEntity(ToDoEntity toDoEntity) {
        return new toDo(
                toDoEntity.getId(),
                toDoEntity.getNameToDo(),
                toDoEntity.getDatum(),
                toDoEntity.getComplete())
                ;
    }


}
