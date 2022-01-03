package htw.berlin.webtech.ToDoListM1.Persistance;

import org.aspectj.apache.bcel.generic.Type;

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

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private TypeTask typeTask;





    public ToDoEntity(String nameToDo, String datum,TypeTask typetask) {

        this.nameToDo = nameToDo;
        this.datum = datum;
        this.typeTask = typetask;
    }

    public ToDoEntity() {

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

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

}
