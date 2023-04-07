package si.um.feri.jee.sample.vao;


import java.io.Serializable;
public class Doctor implements Serializable {

    private int id;
    private String name;
    private String surname;
    private String email;
    private int maxNumberOfPatients;

    public Doctor (String name, String surname, String email, int maxNumberOfPatients) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.maxNumberOfPatients = maxNumberOfPatients;
    }

    public Doctor() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaxNumberOfPatients() {
        return maxNumberOfPatients;
    }

    public void setMaxNumberOfPatients(int maxNumberOfPatients) {
        this.maxNumberOfPatients = maxNumberOfPatients;
    }

    @Override
    public String toString() {
        return "Dr. " + name + ' ' + surname;
    }
}
