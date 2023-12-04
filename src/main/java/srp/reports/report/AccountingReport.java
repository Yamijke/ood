package srp.reports.report;

import srp.reports.currency.Currency;
import srp.reports.currency.CurrencyConverter;
import srp.reports.formatter.DateTimeParser;
import srp.reports.model.Employee;
import srp.reports.store.Store;
import java.util.Calendar;
import java.util.function.Predicate;

public class AccountingReport implements Report {
    private Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private CurrencyConverter currencyConverter;

    public AccountingReport(Store store, DateTimeParser<Calendar> dateTimeParser, CurrencyConverter currencyConverter) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.currencyConverter = currencyConverter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(currencyConverter.convert(Currency.RUB, employee.getSalary(), Currency.USD))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
