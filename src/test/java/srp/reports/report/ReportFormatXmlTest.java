package srp.reports.report;

import org.junit.jupiter.api.Test;
import srp.reports.formatter.DateTimeParser;
import srp.reports.formatter.ReportDateTimeParser;
import srp.reports.model.Employee;
import srp.reports.store.MemStore;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Calendar;

class ReportFormatXmlTest {
    @Test
    public void whenSalaryConverted() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportFormatXml(store, parser);
        String xmlReport = engine.generate(e -> true);
        assertThat(xmlReport, is(notNullValue()));
        assertThat(xmlReport, startsWith("<?xml"));
        assertThat(xmlReport, containsString("Ivan"));
        assertThat(xmlReport, containsString("100000"));
    }
}