package src.ro.ubb.PisicutelePufoase.Validator;
import src.ro.ubb.PisicutelePufoase.Exceptions.ValidatorException;

public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}