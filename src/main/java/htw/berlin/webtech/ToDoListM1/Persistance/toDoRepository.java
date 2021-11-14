package htw.berlin.webtech.ToDoListM1.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface toDoRepository  extends JpaRepository<toDoEntity, Long> {

    List<toDoEntity> findAllByNameToDo(String nameToDo);

}
