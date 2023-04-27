package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("worker", 1));
        jobs.add(new Job("economist", 2));
        jobs.add(new Job("sportsmen", 3));
        jobs.sort(new JobAscByName());
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("economist", 2));
        expected.add(new Job("sportsmen", 3));
        expected.add(new Job("worker", 1));
        assertEquals(expected, jobs);
    }

    @Test
    public void whenDescByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("worker", 1));
        jobs.add(new Job("economist", 2));
        jobs.add(new Job("sportsmen", 3));
        jobs.sort(new JobDescByName());
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("worker", 1));
        expected.add(new Job("sportsmen", 3));
        expected.add(new Job("economist", 2));
        assertEquals(expected, jobs);
    }

    @Test
    public void whenAscByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("sportsmen", 3));
        jobs.add(new Job("economist", 2));
        jobs.add(new Job("worker", 1));
        jobs.sort(new JobAscByPriority());
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("worker", 1));
        expected.add(new Job("economist", 2));
        expected.add(new Job("sportsmen", 3));
        assertEquals(expected, jobs);
    }

    @Test
    public void whenDescByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("worker", 1));
        jobs.add(new Job("economist", 2));
        jobs.add(new Job("sportsmen", 3));
        jobs.sort(new JobDescByPriority());
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("sportsmen", 3));
        expected.add(new Job("economist", 2));
        expected.add(new Job("worker", 1));
        assertEquals(expected, jobs);
    }

    @Test
    public void whenCompatorByProrityAndName() {
        Comparator<Job> cmpPriorityName = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isLessThan(0);
    }
}