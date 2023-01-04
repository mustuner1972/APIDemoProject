package pojo;

public class Employee {

    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private double salary;
    private boolean married;

    public pojo.Courses2 getCourses2() {
        return Courses2;
    }

    public void setCourses2(pojo.Courses2 courses2) {
        Courses2 = courses2;
    }

    private Courses2 Courses2;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}
