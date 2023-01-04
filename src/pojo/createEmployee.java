package pojo;


import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class createEmployee {
    @Test
    public void createEmployeefromPojo() {

        // converting Java to Json -deserialization
        Employee employee = new Employee();
        employee.setFirstName("Ali");
        employee.setLastName("Oz");
        employee.setAge(29);
        employee.setGender("Male");
        employee.setMarried(true);
        employee.setSalary(123456);
        //employee.setCourses2({"sada",21}, );
        Gson gson = new Gson();
        String employeeJson = gson.toJson(employee);
        System.out.println("employeeJson = " + employeeJson);
       //employeeJson = {"firstName":"Ali","lastName":"Oz","gender":"Male","age":29,"salary":123456.0,"married":true};
            }
            @Test
public void childrenPojo(){
        Application app = new Application();
        app.setChildren(true);
        app.setId(12);
        app.setTitle("Java");
        Gson gson =new Gson();
    System.out.println("gson.toJson(app) = " + gson.toJson(app));
}
@Test
public void arrayList(){
        String[] newArr = {"as", "ggs","sfsa"};
        List<String> newList = Arrays.asList(newArr);
    System.out.println("newArr = " + newArr);
    System.out.println("newArr.toString() = " + newArr.toString());
    System.out.println("newList = " + newList);
    for (int i=0; i<newArr.length; i++){
        System.out.println("newArr[i] = " + newArr[i]);
    }
}
}


