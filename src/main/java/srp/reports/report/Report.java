package srp.reports.report;

import srp.reports.model.Employee;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
