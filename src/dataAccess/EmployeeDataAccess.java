/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import entities.Employee;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author LA
 */
public class EmployeeDataAccess {
    private static final String EMPLOYEE_PATH = "./src/data/employee.txt";
    
    private static final File FILE = new File(EMPLOYEE_PATH);
    
    public static Map<String,Employee> getEmployees() throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader(FILE);
        BufferedReader br = new BufferedReader(fr);
        
        String line;
        TreeMap<String, Employee> employees = new TreeMap<>();
        while(true){
            line = br.readLine();
            if(line == null){
                break;
            }
            
            String [] empInfor = line.split("\\|");
            
            Employee e = new Employee(empInfor[0], empInfor[1], empInfor[2], empInfor[3]);
            employees.put(e.getId(), e);         
                                
        }
        
        return employees;
    }
    
    public static Employee getEmployee(String id) throws IOException{
        Map<String,Employee> employees = getEmployees();
        Employee e = employees.get(id);
        return e;
    }
    
    public static void addEmployee(Employee e) throws IOException{
        FileWriter fr = new FileWriter(FILE, true);
        BufferedWriter bw = new BufferedWriter(fr);
        
        bw.write(e.toString());
        bw.write("\n");
        
        bw.close();
        fr.close();
        
    }
    
    public static void editEmpoyee(String id, Employee e) throws IOException{
        Map<String,Employee> employees = getEmployees(); 
        
        employees.replace(id, e);
        
        FileWriter fr = new FileWriter(FILE);
        BufferedWriter bw = new BufferedWriter(fr);
        
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            bw.write(val.toString());
            bw.newLine();
            
        }
        
        bw.close();
        fr.close();
        
    }
    
    public static void deleteEmployee(String id) throws IOException{
        Map<String,Employee> employees = getEmployees(); 
        if(employees.containsKey(id)){
            employees.remove(id);
        }
        
        FileWriter fr = new FileWriter(FILE);
        BufferedWriter bw = new BufferedWriter(fr);
        
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            bw.write(val.toString());
            bw.newLine();
            
        }
        
        bw.close();
        fr.close();
    }
}
