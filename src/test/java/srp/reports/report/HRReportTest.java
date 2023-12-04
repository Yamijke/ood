package srp.reports.report;

import org.junit.jupiter.api.Test;
import srp.reports.model.Employee;
import srp.reports.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class HRReportTest {
    @Test
    public void whenComparedBySalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 150000);
        Employee worker1 = new Employee("Den", now, now, 100000);
        store.add(worker);
        store.add(worker1);
        Report engine = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";").append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";").append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}