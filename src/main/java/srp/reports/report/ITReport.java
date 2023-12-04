package srp.reports.report;

import srp.reports.formatter.DateTimeParser;
import srp.reports.model.Employee;
import srp.reports.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ITReport implements Report {
    private Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ITReport(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        String separator = ",";
        text.append("Name").append(separator)
                        .append("Hired").append(separator)
                        .append("Fired").append(separator)
                        .append("Salary").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(separator)
                    .append(dateTimeParser.parse(employee.getHired())).append(separator)
                    .append(dateTimeParser.parse(employee.getFired())).append(separator)
                    .append(employee.getSalary()).append(System.lineSeparator());
        }
        return text.toString();
    }
}
