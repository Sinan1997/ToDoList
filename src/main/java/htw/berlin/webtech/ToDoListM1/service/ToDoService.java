package htw.berlin.webtech.ToDoListM1.service;

import htw.berlin.webtech.ToDoListM1.Persistance.ToDoEntity;
import htw.berlin.webtech.ToDoListM1.Persistance.ToDoRepository;
import htw.berlin.webtech.ToDoListM1.Persistance.TypeTask;
import htw.berlin.webtech.ToDoListM1.web.api.toDo;
import htw.berlin.webtech.ToDoListM1.web.api.toDoManipulationRequest;
import org.aspectj.apache.bcel.generic.Type;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final toDoTransformer toDoTransformer;

    public ToDoService(ToDoRepository toDoRepository, toDoTransformer toDoTransformer) {
        this.toDoRepository = toDoRepository;
        this.toDoTransformer = toDoTransformer;
    }

    public List<toDo> findAll() {
        List<ToDoEntity> toDos = toDoRepository.findAll();
        return toDos.stream()
                .map(toDoTransformer::transformEntity)
                .collect(Collectors.toList());

    }

    public toDo findById(Long id) {
        var toDoEntity = toDoRepository.findById(id);
        return toDoEntity.map(toDoTransformer::transformEntity).orElse(null);
    }

    public toDo create(toDoManipulationRequest request) {
        var typeTask =TypeTask.valueOf(request.getTypeTask());
        var toDoEntity = new ToDoEntity(request.getNameToDo(), request.getDatum(), request.isComplete(),typeTask);
        toDoEntity = toDoRepository.save(toDoEntity);
        return toDoTransformer.transformEntity(toDoEntity);
    }

    public toDo update(Long id, toDoManipulationRequest request) {
        var toDoEntityOptional = toDoRepository.findById(id);
        if (toDoEntityOptional.isEmpty()) {
            return null;
        }

        var toDoEntity = toDoEntityOptional.get();
        toDoEntity.setNameToDo(request.getNameToDo());
        toDoEntity.setDatum(request.getDatum());
        toDoEntity.setComplete(request.isComplete());
        toDoEntity.setTypeTask(TypeTask.valueOf(request.getTypeTask()));
        toDoEntity = toDoRepository.save(toDoEntity);
        return toDoTransformer.transformEntity(toDoEntity);
    }

    public boolean deleteById(Long id) {
        if (!toDoRepository.existsById(id)) {
            return false;
        }

        toDoRepository.deleteById(id);
        return true;
    }



}
