package htw.berlin.webtech.ToDoListM1.service;

import htw.berlin.webtech.ToDoListM1.Persistance.ToDoEntity;
import htw.berlin.webtech.ToDoListM1.Persistance.TypeTask;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class ToDoTransformerTest implements WithAssertions {

    private final ToDoTransformer underTest = new ToDoTransformer();

    @Test
    @DisplayName("should transform ToDoEntity to ToDo")
    void should_transform_to_do_entity_to_toDo() {

        var toDoEntity = Mockito.mock(ToDoEntity.class);
        doReturn(100L).when(toDoEntity).getId();
        doReturn("Wäsche waschen").when(toDoEntity).getNameToDo();
        doReturn("10.01.2022").when(toDoEntity).getDatum();
        doReturn(TypeTask.DAILYTASK).when(toDoEntity).getTypeTask();

        var result = underTest.transformEntity(toDoEntity);

        assertThat(result.getId()).isEqualTo(100);
        assertThat(result.getNameToDo()).isEqualTo("Wäsche waschen");
        assertThat(result.getDatum()).isEqualTo("10.01.2022");
        assertThat(result.getTypeTask()).isEqualTo("DAILYTASK");
    }

    @Test
    @DisplayName("should transform ToDoEntity to ToDo")
    void should_transform_to_do_entity_to_toDo2() {

        var toDoEntity = Mockito.mock(ToDoEntity.class);
        doReturn(101L).when(toDoEntity).getId();
        doReturn("10 Minuten Lauf").when(toDoEntity).getNameToDo();
        doReturn("15.01.2022").when(toDoEntity).getDatum();
        doReturn(TypeTask.SPORT).when(toDoEntity).getTypeTask();

        var result = underTest.transformEntity(toDoEntity);

        assertThat(result.getId()).isEqualTo(101);
        assertThat(result.getNameToDo()).isEqualTo("10 Minuten Lauf");
        assertThat(result.getDatum()).isEqualTo("15.01.2022");
        assertThat(result.getTypeTask()).isEqualTo("SPORT");

    }
}
