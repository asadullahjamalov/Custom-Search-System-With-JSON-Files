package task.base;

import static task.util.GeneralUtil.idGenerator;

public class Person {
    private String id;
    private String name;
    private String surname;
    private String fatherName;
    private String email;
    private String phoneNumber;

    public Person() {
    }

    public Person(String name, String surname, String fatherName, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = idGenerator();
    }

    public Person(String id, String name, String surname, String fatherName, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return  "Person id: " + id +
                "\t|Name: " + name  +
                "\t\t|Surname: " + surname +
                "\t\t\t\t|FatherName: " + fatherName +
                "\t\t\t\t|Email:" + email+
                "\t\t\t\t|PhoneNumber: " + phoneNumber;
    }
}
