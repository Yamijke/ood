package srp.reports.report;

import org.junit.jupiter.api.Test;
import srp.reports.formatter.DateTimeParser;
import srp.reports.formatter.ReportDateTimeParser;
import srp.reports.model.Employee;
import srp.reports.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ITReportTest {
    @Test
    public void whenSalaryConverted() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ITReport(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("Name").append(",")
                .append("Hired").append(",")
                .append("Fired").append(",")
                .append("Salary").append(System.lineSeparator())
                .append(worker.getName()).append(",")
                .append(parser.parse(worker.getHired())).append(",")
                .append(parser.parse(worker.getFired())).append(",")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}