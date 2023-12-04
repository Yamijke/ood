package srp.reports.report;

import srp.reports.model.Employee;
import srp.reports.store.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class HRReport implements Report{
    private HashMap<String, Double> salary = new HashMap<>();
    private Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            salary.put(employee.getName(), employee.getSalary());
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(salary.entrySet());
        list.sort(Map.Entry.<String, Double>comparingByValue().reversed());
        for (Map.Entry<String, Double> entry : list) {
            text.append(entry.getKey())
                    .append("; ")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
