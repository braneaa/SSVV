package ro.ubbcluj.PisicutelePufoase;


import src.ro.ubb.PisicutelePufoase.Repository.TxtFileRepository.StudentFileRepo;
import src.ro.ubb.PisicutelePufoase.Repository.XMLFileRepository.StudentXMLRepo;
import src.ro.ubb.PisicutelePufoase.Service.TxtFileService.StudentService;
import src.ro.ubb.PisicutelePufoase.Validator.StudentValidator;

import java.io.IOException;

public class TestBuilder {
    //student
    public static String DEFAULT_ID = "420";
    public static String DEFAULT_NAME = "nume";
    public static String DEFAULT_GROUP = "932";
    public static String DEFAULT_EMAIL = "email@emabil.ro";
    public static String DEFAULT_INDRUMATOR = "indrumator";

    //files
    public static String DEFAULT_STUDENT_XML_FILE = "testStudentXMLFile.xml";
    public static String DEFAULT_STUDENT_FILE = "testStudentFile.txt";

    public String[] getStudentData() {
        String[] res = new String[5];
        res[0] = DEFAULT_ID;
        res[1] = DEFAULT_NAME;
        res[2] = DEFAULT_GROUP;
        res[3] = DEFAULT_EMAIL;
        res[4] = DEFAULT_INDRUMATOR;
        return res;
    }

    public String[] getFaultyStudent() {

        String[] res = new String[5];
        res[0] = null;
        res[1] = null;
        res[2] = null;
        res[3] = null;
        res[4] = null;
        return res;
    }

    public StudentValidator getStudentValidator() {
        return new StudentValidator();
    }

    public StudentXMLRepo getStudentXMLRepo() {
        return new StudentXMLRepo(getStudentValidator(),DEFAULT_STUDENT_XML_FILE);
    }

    public StudentFileRepo getStudentFileRepo() throws IOException {
        return new StudentFileRepo(DEFAULT_STUDENT_FILE, getStudentValidator());
    }

    public StudentService getService() throws IOException {
        return new StudentService(getStudentFileRepo());
    }
}
