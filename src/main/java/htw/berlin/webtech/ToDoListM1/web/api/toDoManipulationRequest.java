package htw.berlin.webtech.ToDoListM1.web.api;


public class toDoManipulationRequest {

    private String nameToDo;
    private String datum;
    private String typeTask;
    private boolean list;

    public toDoManipulationRequest(String nameToDo, String datum, String typeTask, boolean list){
        this.nameToDo = nameToDo;
        this.datum = datum;
        this.typeTask = typeTask;
        this.list = list;
    }

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

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }





}
