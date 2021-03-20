package src.ro.ubb.PisicutelePufoase;


import src.ro.ubb.PisicutelePufoase.Exceptions.ValidatorException;
import src.ro.ubb.PisicutelePufoase.Repository.XMLFileRepository.NotaXMLRepo;
import src.ro.ubb.PisicutelePufoase.Repository.XMLFileRepository.StudentXMLRepo;
import src.ro.ubb.PisicutelePufoase.Repository.XMLFileRepository.TemaLabXMLRepo;
import src.ro.ubb.PisicutelePufoase.Service.XMLFileService.NotaXMLService;
import src.ro.ubb.PisicutelePufoase.Service.XMLFileService.StudentXMLService;
import src.ro.ubb.PisicutelePufoase.Service.XMLFileService.TemaLabXMLService;

import src.ro.ubb.PisicutelePufoase.UI.ui;
import src.ro.ubb.PisicutelePufoase.Validator.NotaValidator;
import src.ro.ubb.PisicutelePufoase.Validator.StudentValidator;
import src.ro.ubb.PisicutelePufoase.Validator.TemaLabValidator;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}