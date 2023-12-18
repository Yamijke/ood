package srp.reports.report;

import srp.reports.formatter.DateTimeParser;
import srp.reports.model.Employee;
import srp.reports.model.EmployeeWrapper;
import srp.reports.model.Employees;
import srp.reports.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportFormatXml implements Report {
    private Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportFormatXml(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            List<Employee> filteredEmployees = store.findBy(filter);
            List<EmployeeWrapper> employeeWrappers = filteredEmployees.stream()
                    .map(e -> new EmployeeWrapper(e, dateTimeParser))
                    .collect(Collectors.toList());
            Employees employeesWrap = new Employees(employeeWrappers);
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(employeesWrap, writer);
                xml = writer.getBuffer().toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (JAXBException e) {
            throw new RuntimeException("Ошибка сериализации JAXB", e);
        }
        return xml;
    }
}
