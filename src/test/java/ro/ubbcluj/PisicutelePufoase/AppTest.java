package ro.ubbcluj.PisicutelePufoase;

import org.junit.Before;
import org.junit.Test;
import src.ro.ubb.PisicutelePufoase.Domain.TemaLab;
import src.ro.ubb.PisicutelePufoase.Exceptions.ValidatorException;
import src.ro.ubb.PisicutelePufoase.Service.TxtFileService.StudentService;
import src.ro.ubb.PisicutelePufoase.Service.TxtFileService.TemaLabService;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AppTest {

    TestBuilder testBuilder = new TestBuilder();
    StudentService service;
    TemaLabService temaLabService;
    @Before
    public void before() throws IOException {
        testBuilder = new TestBuilder();
        service = testBuilder.getService();
        temaLabService = testBuilder.getServiceAssignment();
    }

    @Test
    public void test1() throws ValidatorException {
        String[] student = testBuilder.getStudentData();

        service.add(student);

        assertTrue(service.getById(student[0]).getId()
                .equals(student[0]));
    }

    @Test
    public void test2() throws ValidatorException {
        String[] student = testBuilder.getStudentData();
        String[] studentClone = testBuilder.getStudentData();

        service.add(student);
        service.add(studentClone);



        assertTrue(getStudentsCount().equals(1));
    }

    @Test
    public void test3() {
        String[] student = testBuilder.getFaultyStudent();

        try {
            service.add(student);
        } catch (Exception exception) {
            assertTrue(getStudentsCount().equals(0));
        }
    }

    @Test
    public void test4(){
        testAssignmentWithIdZero();
        testAssignmentWithEmptyDescription();
        testAssignmentWithInvalidDeadline();
        testAssignmentWithInvalidPrimire();
    }

    private void testAssignmentWithInvalidPrimire() {
        try {
            temaLabService.add(testBuilder.getAssignmentWithInvalidPrimire());
        } catch (Exception exception) {
            assertEquals(1, (int) getAssignmentsCount());
        }

    }

    private void testAssignmentWithInvalidDeadline() {
        try {
            temaLabService.add(testBuilder.getAssignmentWithInvalidDeadline());
        } catch (Exception exception) {
            assertEquals(1, (int) getAssignmentsCount());
        }
    }

    private void testAssignmentWithIdZero() {try {
        temaLabService.add(testBuilder.getAssignmentWithIdZero());
    } catch (Exception exception) {
        assertEquals(1, (int) getAssignmentsCount());
    }
    }

    private void testAssignmentWithEmptyDescription() {
        try {
            temaLabService.add(testBuilder.getAssignmentWithEmptyDescription());
        } catch (Exception exception) {
            assertEquals(1, (int) getAssignmentsCount());
        }
    }

    private Integer getStudentsCount() {
        AtomicInteger count = new AtomicInteger();
        service.getAll().forEach(student -> count.addAndGet(1));
        return count.get();
    }

    private Integer getAssignmentsCount() {
        AtomicReference<Integer> count = new AtomicReference<>(0);

        temaLabService.getAll().forEach(assignment -> count.getAndSet(count.get() + 1));

        return count.get();
    }


}
