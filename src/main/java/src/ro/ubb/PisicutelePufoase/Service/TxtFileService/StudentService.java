package src.ro.ubb.PisicutelePufoase.Service.TxtFileService;

import src.ro.ubb.PisicutelePufoase.Domain.Student;
import src.ro.ubb.PisicutelePufoase.Repository.TxtFileRepository.StudentFileRepo;

public class StudentService extends AbstractService<String, Student> {
    //StudentFileRepo stdRepo;
    public StudentService(StudentFileRepo stdRepo){
        super(stdRepo);
    }
    /*
    @Override
    public Student extractEntity(String[] info){
        return new Student("","",2,"","");
    }
    */
}


