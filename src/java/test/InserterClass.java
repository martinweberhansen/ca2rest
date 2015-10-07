package test;

import entities.Person;
import facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InserterClass {
    public static void main(String[] args) {
        Persistence.generateSchema("CA2_projectPU", null);
        
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        Facade facade = new Facade();
        
//        
//        final Person p1 = new Person("jens1","jensen1");
//        final Person p2 = new Person("jens2","jensen2");
//        final Person p3 = new Person("jens3","jensen3");
//
//        
//         
//        facade.addPerson(p1);
//        facade.addPerson(p2);
//        facade.addPerson(p3);
//        
        Person j1 = facade.getPerson(1);
        Person j2 = facade.getPerson(2);
        Person j3 = facade.getPerson(3);
        
        System.out.println("firstname : "+j1.getfName()+", lastName: "+j1.getlName()+", id:"+j1.getId());
        System.out.println("firstname : "+j2.getfName()+", lastName: "+j2.getlName()+", id:"+j2.getId());
        System.out.println("firstname : "+j3.getfName()+", lastName: "+j3.getlName()+", id:"+j3.getId());
}
