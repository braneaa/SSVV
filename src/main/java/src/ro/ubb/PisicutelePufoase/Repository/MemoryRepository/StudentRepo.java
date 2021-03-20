package src.ro.ubb.PisicutelePufoase.Repository.MemoryRepository;
import src.ro.ubb.PisicutelePufoase.Validator.IValidator;
import src.ro.ubb.PisicutelePufoase.Domain.Student;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}