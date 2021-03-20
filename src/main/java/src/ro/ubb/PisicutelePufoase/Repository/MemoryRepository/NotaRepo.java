package src.ro.ubb.PisicutelePufoase.Repository.MemoryRepository;
import src.ro.ubb.PisicutelePufoase.Validator.IValidator;
import src.ro.ubb.PisicutelePufoase.Domain.Nota;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}