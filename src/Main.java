import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ion", 45, "Facebook", 7500));
        employees.add(new Employee("Andrei", 25, "Facebook", 6000));
        employees.add(new Employee("Ana", 30, "Google", 10000));
        employees.add(new Employee("Marcel", 40, "Microsoft", 9500));

        //3.1
        double specifiedSalary = 7500;
        List<String> salaryMoreThan = extraxtSalaryMoreThan(employees, specifiedSalary);
        System.out.println("Salaries more than " + specifiedSalary + ": " + salaryMoreThan);

        //3.2
        Map<String, List<String>> personsForCompany = personsForCompanyMap(employees);
        System.out.println("Persons for company: " + personsForCompany);

        //3.3
        double totalSalaries = calculatingTotalSalaries(employees);
        System.out.println("Sum of salaries: " + totalSalaries);

        //3.4
        String companyWithBiggestSalary = findCompanyWithBiggestSalary(employees);
        System.out.println("Company that gives the biggest salary is: " + companyWithBiggestSalary);
    }

    private static List<String> extraxtSalaryMoreThan(List<Employee> employees, double specifiedSalary){
        List<String> salaryMoreThan = new ArrayList<>();
        for (Employee employee : employees){
            if(employee.getSalary() > specifiedSalary){
                salaryMoreThan.add(employee.getName());
            }
        }
        return salaryMoreThan;
    }

    private static Map<String, List<String>> personsForCompanyMap(List<Employee> employees) {
        Map<String, List<String>> personsForCompany = new HashMap<>();
        for (Employee employee : employees) {
            String company = employee.getCompany();
            if (!personsForCompany.containsKey(company)) {
                personsForCompany.put(company, new ArrayList<>());
            }
            personsForCompany.get(company).add(employee.getName());
        }
        return personsForCompany;
    }
    private static double calculatingTotalSalaries(List<Employee> employees){
        double totalSalaries = 0;
        for(Employee employee : employees){
            totalSalaries += employee.getSalary();
        }
        return totalSalaries;
    }

    private static String findCompanyWithBiggestSalary(List<Employee> employees){
        Map<String, Double> companyToTotalSalaryMap = new HashMap<>();
        for (Employee employee : employees){
            String company = employee.getCompany();
            double salary = employee.getSalary();
            companyToTotalSalaryMap.put(company, companyToTotalSalaryMap.getOrDefault(company, 0.0) + salary);
        }
        double maxTotalSalary = 0;
        String companyWithBiggestSalary = null;
        for(Map.Entry<String, Double> entry : companyToTotalSalaryMap.entrySet()){
            if(entry.getValue() > maxTotalSalary){
                maxTotalSalary = entry.getValue();
                companyWithBiggestSalary = entry.getKey();
            }
        }
        return companyWithBiggestSalary;
    }

}
