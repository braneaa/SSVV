package ro.ubbcluj.PisicutelePufoase;


import src.ro.ubb.PisicutelePufoase.Repository.TxtFileRepository.StudentFileRepo;
import src.ro.ubb.PisicutelePufoase.Repository.TxtFileRepository.TemaLabFileRepo;
import src.ro.ubb.PisicutelePufoase.Repository.XMLFileRepository.StudentXMLRepo;
import src.ro.ubb.PisicutelePufoase.Service.TxtFileService.StudentService;
import src.ro.ubb.PisicutelePufoase.Service.TxtFileService.TemaLabService;
import src.ro.ubb.PisicutelePufoase.Validator.StudentValidator;
import src.ro.ubb.PisicutelePufoase.Validator.TemaLabValidator;

import java.io.IOException;

public class TestBuilder {
    //student
    public static String DEFAULT_ID = "420";
    public static String DEFAULT_NAME = "nume";
    public static String DEFAULT_GROUP = "932";
    public static String DEFAULT_EMAIL = "email@emabil.ro";
    public static String DEFAULT_INDRUMATOR = "indrumator";


    public static int ID_0 = 0;
    public static String descriere = "Lorem ipsum";
    public static int deadline = 4;
    public static int primire = 1;
    public static int id = 7;
    public static String empty_description = null;
    public static int invalid_deadline = 0;
    public static int invalid_primire = 0;

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

    public String[] getAssignmentWithIdZero() {
        return new String[]{String.valueOf(ID_0), descriere, String.valueOf(deadline), String.valueOf(primire)};
    }

    public String[] getAssignmentWithEmptyDescription() {
        return new String[]{String.valueOf(id), empty_description, String.valueOf(deadline), String.valueOf(primire)};
    }

    public String[] getAssignmentWithInvalidDeadline() {
        return new String[]{String.valueOf(id), descriere, String.valueOf(invalid_deadline), String.valueOf(primire)};
    }

    public String[] getAssignmentWithInvalidPrimire() {
        return new String[]{String.valueOf(id), descriere, String.valueOf(deadline), String.valueOf(invalid_primire)};
    }

    public TemaLabService getServiceAssignment() throws IOException {
        return new TemaLabService(getAssignmentFileRepo());
    }

    private TemaLabValidator getAssignmentValidator() {
        return new TemaLabValidator();
    }

    private TemaLabFileRepo getAssignmentFileRepo() throws IOException {
        return new TemaLabFileRepo(null ,getAssignmentValidator());
    }
}
