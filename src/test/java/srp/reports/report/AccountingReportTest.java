package srp.reports.report;

import org.junit.jupiter.api.Test;
import srp.reports.currency.Currency;
import srp.reports.currency.CurrencyConverter;
import srp.reports.currency.InMemoryCurrencyConverter;
import srp.reports.formatter.DateTimeParser;
import srp.reports.formatter.ReportDateTimeParser;
import srp.reports.model.Employee;
import srp.reports.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class AccountingReportTest {
    @Test
    public void whenSalaryConverted() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        CurrencyConverter cc = new InMemoryCurrencyConverter();
        store.add(worker);
        Report engine = new AccountingReport(store, parser, cc);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(cc.convert(Currency.RUB, worker.getSalary(), Currency.USD))
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}