package htw.berlin.webtech.ToDoListM1.web;

import htw.berlin.webtech.ToDoListM1.service.ToDoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(toDoRestController.class)
public class ToDoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Test
    @DisplayName("Sollte die gefundene ToDo vom ToDoService zurückgeben")
    void should_return_found_todo_from_todo_serice() throws Exception {

    }
}
