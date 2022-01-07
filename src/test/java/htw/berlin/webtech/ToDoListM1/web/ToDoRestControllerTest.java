package htw.berlin.webtech.ToDoListM1.web;

import htw.berlin.webtech.ToDoListM1.service.ToDoService;
import htw.berlin.webtech.ToDoListM1.web.api.ToDo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(toDoRestController.class)
public class ToDoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Test
    @DisplayName("sollte die gefundene toDo vom toDoService zurückgeben")
    void sollte_die_gefundene_toDo_vom_toDoService_zurückgeben() throws Exception{
        //gegeben
        var toDos = List.of(
                new ToDo(1,"Backen","28.01.2022","DAILYTASK"),
                new ToDo(2,"Aufräumen","29.01.2022", "DAILYTASK")
        );
        doReturn(toDos).when(toDoService).findAll();

        //wenn
        mockMvc.perform(get("/api/v1/toDos"))
                //dann
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nameToDo").value("Backen"))
                .andExpect(jsonPath("$[0].datum").value("28.01.2022"))
                .andExpect(jsonPath("$[0].typeTask").value("DAILYTASK"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nameToDo").value("Aufräumen"))
                .andExpect(jsonPath("$[1].datum").value("29.01.2022"))
                .andExpect(jsonPath("$[1].typeTask").value("DAILYTASK"));
    }

    @Test
    @DisplayName("sollte 404 zurückgeben falls toDo nicht gefunden wird")
    void sollte_404_zurückgeben_falls_toDo_nicht_gefunden_wird() throws Exception{
        //gegeben
        doReturn(null).when(toDoService).findById(anyLong());

        //wenn
        mockMvc.perform(get("/api/v1/toDos/1907"))
                //dann
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("sollte 201 http status und location header zurückgeben when ein toDo erstellt wird")
    void sollte_201_http_status_und_location_header_zurückgeben_when_ein_zoDo_erstellt_wird() throws  Exception{
        //gegeben
        String toDoCreateAsJson = "{\"nameToDo\": \"Backen\", \"datum\": \"28.01.2022\", \"typeTask\": \"DAILYTASK\"}";
        var toDo = new ToDo(1907,"null","null","null");
        doReturn(toDo).when(toDoService).create(any());

        //wenn
        mockMvc.perform(
                post("/api/v1/toDos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toDoCreateAsJson)
        )
                //dann
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/toDos/" + toDo.getId()))));
    }

    @Test
    @DisplayName("sollte erstellung eines toDos validieren")
    void sollte_erstellung_eines_toDos_validieren() throws Exception{
        //gegeben
        String toDoCreateAsJson = "{\"nameToDo\": \"Z\", \"datum\": \"\", \"typeTask\": \"DAILYTASK\"}";

        //wenn
        //wenn
        mockMvc.perform(
                post("/api/v1/toDos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toDoCreateAsJson)
        )
                //dann
                .andExpect(status().isBadRequest());
    }

}

