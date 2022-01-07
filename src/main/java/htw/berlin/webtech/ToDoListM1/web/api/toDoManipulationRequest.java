package htw.berlin.webtech.ToDoListM1.web.api;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class toDoManipulationRequest {

    @Size(min = 4, message = "Bitte seien Sie sicher, dass Ihre To-Do mindestens 4 Zeichen hat.")
    private String nameToDo;

    @NotBlank(message= "Das Datum darf nicht leer sein.")
    private String datum;

    @Pattern(
            regexp = "PROGRAMMING|DAILYTASK|WORK|SPORT|SONSTIGES|UNKNOWN",
            message = "Bitte wählen Sie 'PROGRAMMING','DAILYTASK','WORK', 'SPORT', 'SONSTIGES', oder 'UNKNOWN' für den Aufgabentyp aus "
    )
    private String typeTask;


    public toDoManipulationRequest() {

    }
    public String getNameToDo() {
        return nameToDo;
    }

    public void setNameToDo(String nameToDo) {
        this.nameToDo = nameToDo;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(String typeTask) {
        this.typeTask = typeTask;
    }


}
