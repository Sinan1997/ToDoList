package htw.berlin.webtech.ToDoListM1.web.api;


public class toDo {

    private long id;
    private String nameToDo;
    private String datum;
    private boolean elredigt;

    public toDo(long id, String nameToDo, String datum, boolean elredigt) {
        this.id = id;
        this.nameToDo = nameToDo;
        this.datum = datum;
        this.elredigt = elredigt;
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

    public boolean isElredigt() {
        return elredigt;
    }

    public void setElredigt(boolean elredigt) {
        this.elredigt = elredigt;
    }
}
