package htw.berlin.webtech.ToDoListM1.Persistance;

import javax.persistence.*;

@Entity(name = "toDos")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_toDo", nullable = false)
    private String nameToDo;

    @Column(name = "datum", nullable = false)
    private String datum;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "list", nullable = false)
    private boolean list;

    @Column(name = "complete")
    private boolean complete;

    public ToDoEntity(String nameToDo, String datum, boolean list, boolean complete) {

        this.nameToDo = nameToDo;
        this.datum = datum;
        this.list = list;
        this.complete = complete;
    }

    protected ToDoEntity() {
    }

    public Long getId() {
        return id;
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

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
    public boolean getList() {
        return list;
    }

    public void setList(boolean list){
        this.list = list;
    }


}
