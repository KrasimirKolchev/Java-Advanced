package DefiningClassesEx.CompanyRoaster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> GetEmployees() {
        return this.employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double getAverageSalary() {
        return this.employees.stream().mapToDouble(e -> e.getSalary()).average().getAsDouble();
    }
}
