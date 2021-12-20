package htw.berlin.webtech.ToDoListM1.web.api;

public class toDoCreateUpdateRequest {

    private String nameToDo;
    private String datum;
    private boolean list;
    private boolean complete;

    public toDoCreateUpdateRequest(String nameToDo, String datum, boolean list, boolean complete) {
        this.nameToDo = nameToDo;
        this.datum = datum;
        this.list = list;
        this.complete = complete;
    }

    public toDoCreateUpdateRequest(){

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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isList(){
        return list;
    }

    public void setList(boolean list){
        this.list = list;
    }
}
