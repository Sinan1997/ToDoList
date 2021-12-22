package htw.berlin.webtech.ToDoListM1.web.api;


public class toDo {

    private long id;
    private String nameToDo;
    private String datum;
    private String typeTask;
    private boolean complete;


    public toDo(long id, String nameToDo, String datum, String typeTask, boolean complete) {
        this.id = id;
        this.nameToDo = nameToDo;
        this.datum = datum;
        this.typeTask = typeTask;
        this.complete = complete;

    }
    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTypeTask(){
        return typeTask;
    }

    public void setTypeTask(){
        this.typeTask = typeTask;
    }

}
