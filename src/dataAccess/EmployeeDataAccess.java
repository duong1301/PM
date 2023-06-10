/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default
 * .txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package dataAccess;

import entities.Employee;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author LA
 */
public class EmployeeDataAccess {
	private static final String EMPLOYEE_PATH = "./src/data/employee.txt";

	private static final File FILE = new File(EMPLOYEE_PATH);

	public static Map<String, Employee> getEmployees() throws IOException {
		FileReader fr = new FileReader(FILE);
		BufferedReader br = new BufferedReader(fr);

		String line;
		TreeMap<String, Employee> employees = new TreeMap<>();
		while ((line = br.readLine()) != null) {
			String[] employeeInfo = line.split("\\|");

			employees.put(employeeInfo[0],
			              new Employee(employeeInfo[0],
			                           employeeInfo[1],
			                           employeeInfo[2],
			                           employeeInfo[3]
			              )
			);
		}

		br.close();
		fr.close();

		return employees;
	}

	public static Employee getEmployee(String id) throws IOException {
		Map<String, Employee> employees = getEmployees();
		return employees.get(id);
	}

	public static void addEmployee(Employee e) throws IOException {
		FileWriter fw = new FileWriter(FILE, true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(e.toString());
		bw.write("\n");

		bw.close();
		fw.close();

	}

	public static void editEmployee(String id, Employee e) throws IOException {
		Map<String, Employee> employees = getEmployees();
		employees.replace(id, e);

		FileWriter fw = new FileWriter(FILE);
		BufferedWriter bw = new BufferedWriter(fw);

		for (Employee employee : employees.values()) {
			bw.write(employee.toString());
			bw.newLine();
		}

		bw.close();
		fw.close();
	}

	public static void deleteEmployee(String id) throws IOException {
		Map<String, Employee> employees = getEmployees();
		employees.remove(id);

		FileWriter fw = new FileWriter(FILE);
		BufferedWriter bw = new BufferedWriter(fw);

		for (Employee employee : employees.values()) {
			bw.write(employee.toString());
			bw.newLine();
		}

		bw.close();
		fw.close();
	}
}
