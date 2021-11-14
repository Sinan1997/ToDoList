package htw.berlin.webtech.ToDoListM1.web;


public class toDo {

    private long id;
    private String nameToDo;
    private String datum;
    private boolean erledigt;

    public toDo(long id, String nameToDo, String datum, boolean erledigt) {
        this.id = id;
        this.nameToDo = nameToDo;
        this.datum = datum;
        this.erledigt = erledigt;
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

    public boolean isErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean elredigt) {
        this.erledigt = erledigt;
    }
}
