package DefiningClassesEx.CompanyRoaster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Department> department = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputInfo = reader.readLine().split("\\s+");
            String dep = inputInfo[3];
            Employee employee = new Employee(inputInfo[0], Double.parseDouble(inputInfo[1]), inputInfo[2]);

            if (inputInfo.length == 6) {
                employee.setEmail(inputInfo[4]);
                employee.setAge(Integer.parseInt(inputInfo[5]));
            } else if (inputInfo.length == 5) {
                if (!inputInfo[4].contains("@")) {
                    employee.setAge(Integer.parseInt(inputInfo[4]));
                } else {
                    employee.setEmail(inputInfo[4]);
                }
            }

            if (!department.containsKey(dep)) {
                department.put(dep, new Department());
            }
            department.get(dep).addEmployee(employee);
        }

        Map.Entry<String, Department> highestSalary = department.entrySet().stream().sorted((a, b) -> {
            int result = 0;

            if (a.getValue().getAverageSalary() > b.getValue().getAverageSalary()) {
                result = -1;
            } else if (a.getValue().getAverageSalary() < b.getValue().getAverageSalary()) {
                result = 1;
            }
            return result;
        }).findFirst().get();

        System.out.println(String.format("Highest Average Salary: %s", highestSalary.getKey()));

        for (Employee employee : highestSalary.getValue().GetEmployees()) {
            System.out.println(employee);
        }
    }
}
