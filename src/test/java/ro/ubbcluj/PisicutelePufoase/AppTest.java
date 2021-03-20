package ro.ubbcluj.PisicutelePufoase;

import org.junit.Before;
import org.junit.Test;
import src.ro.ubb.PisicutelePufoase.Exceptions.ValidatorException;
import src.ro.ubb.PisicutelePufoase.Service.TxtFileService.StudentService;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.TestCase.assertTrue;

public class AppTest {

    TestBuilder testBuilder = new TestBuilder();
    StudentService service;
    @Before
    public void before() throws IOException {
        testBuilder = new TestBuilder();
        service = testBuilder.getService();
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

    private Integer getStudentsCount() {
        AtomicInteger count = new AtomicInteger();
        service.getAll().forEach(student -> {
            count.addAndGet(1);});
        return count.get();
    }


}
