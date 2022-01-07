package htw.berlin.webtech.ToDoListM1.service;

import htw.berlin.webtech.ToDoListM1.Persistance.ToDoRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ToDoServiceTest implements WithAssertions {

    @Mock
    private ToDoRepository repository;

    @InjectMocks
    private ToDoService underTest;

    @Test
    @DisplayName("Sollte true zurückgeben wenn das Löschen erfolgreich war")
    void should_return_true_if_delete_was_successful(){

        Long givenId = 100L;
        doReturn(true).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Sollte false zurückgeben wenn man eine ToDo löschen will die nicht existiert")
    void should_return_false_if_todo_to_delete_does_not_exist(){

        Long givenId = 100L;
        doReturn(false).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}
