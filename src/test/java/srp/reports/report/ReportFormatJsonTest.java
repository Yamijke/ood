package srp.reports.report;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import srp.reports.formatter.DateTimeParser;
import srp.reports.formatter.ReportDateTimeParser;
import srp.reports.model.Employee;
import srp.reports.store.MemStore;

import java.util.Calendar;

import static org.hamcrest.Matchers.containsString;

class ReportFormatJsonTest {
    @Test
    public void whenSalaryConverted() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportFormatJson(store, parser);
        String jsonReport = engine.generate(e -> true);
        MatcherAssert.assertThat(jsonReport, containsString("Ivan"));
        MatcherAssert.assertThat(jsonReport, containsString("100000"));
    }
}