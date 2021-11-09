/*
package m2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class toDoService {

    @Autowired
    ThingRepository repo;

    public toDo save (toDo todo){
        return repo.save(todo);
    }

    public toDo get(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
*/