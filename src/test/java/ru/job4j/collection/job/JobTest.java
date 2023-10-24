package ru.job4j.collection.job;

import org.junit.Test;

import java.util.Comparator;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JobTest {

    @Test
    public void whenCompareAscByName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int result = cmpAscName.compare(
                new Job("Fix bug", 1),
                new Job("Ask", 0)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenCompareDescByName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int result = cmpDescName.compare(
                new Job("Fix bug", 1),
                new Job("Ask", 0)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenCompareAscByPriority() {
        Comparator<Job> cmpAscPriority = new JobAscByPriority();
        int result = cmpAscPriority.compare(
                new Job("Fix bug", 1),
                new Job("Ask", 0)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenCompareDescByPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByPriority();
        int result = cmpDescPriority.compare(
                new Job("Fix bug", 1),
                new Job("Ask", 0)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenCompareByAscNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareByDescNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByAscNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareByAscPriorityAndDeskName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}