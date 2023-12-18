package srp.reports.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import srp.reports.formatter.DateTimeParser;
import srp.reports.model.Employee;
import srp.reports.store.Store;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportFormatJson implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Gson gson;

    public ReportFormatJson(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        gson = new GsonBuilder().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        JSONArray jsonArray = new JSONArray();
        for (Employee employee : employees) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", employee.getName());
            jsonObject.put("hired", dateTimeParser.parse(employee.getHired()));
            jsonObject.put("fired", dateTimeParser.parse(employee.getFired()));
            jsonObject.put("salary", employee.getSalary());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }
}
