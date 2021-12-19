package htw.berlin.webtech.ToDoListM1.web.api;

import java.util.List;

public class Person {


        private long id;
        private String firstName;
        private String lastName;
        private String gender;
        private boolean list;
        private List<Long> toDos;

        public Person(long id, String firstName, String lastName, String gender, boolean list, List<Long> toDos) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.list = list;
            this.toDos = toDos;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public boolean isList() {
            return list;
        }

        public void setList(boolean list) {
            this.list = list;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public List<Long> getToDos() {
            return toDos;
        }

        public void setToDos(List<Long> toDos) {
            this.toDos = toDos;
        }
    }

