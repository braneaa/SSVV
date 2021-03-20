package src.ro.ubb.PisicutelePufoase.Service.TxtFileService;

import src.ro.ubb.PisicutelePufoase.Domain.Nota;
import src.ro.ubb.PisicutelePufoase.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer, Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
