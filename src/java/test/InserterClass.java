package test;

import entities.Address;
import entities.InfoEntity;
import entities.Person;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InserterClass {
    public static void main(String[] args) {
        
        
//       EntityManagerFactory emf;
//        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
//        EntityManager em = emf.createEntityManager();
        
          // em.getTransaction().begin();
        
     
    Facade facade = new Facade();
        
        
    Address addr = new Address();
    addr.setCityName("Herning");
    addr.setAdditionalInfo("3,th");
    addr.setStreet("HerningVej 13");
    
    Person p = new Person();
    p.setfName("buggy");
    p.setlName("Mayn");
    
    facade.addAddressToPerson(addr, p);
    
//    em.persist(addr);
//    
//    InfoEntity ie = new InfoEntity();
//    
//    em.persist(ie);
//    
//    em.flush();
    


//    Address address = em.find(Address.class, 1);
//    ie = em.find(InfoEntity.class, 1);
//    address.addEntity(ie);
//    
//    
//    Query query = em.createQuery("SELECT e FROM InfoEntity e");
//    List<InfoEntity> list = (List<InfoEntity>) query.getResultList();
//    System.out.println(list);
//    
//    query = em.createQuery("SELECT d FROM Address d");
//    List<Address> dList = (List<Address>) query.getResultList();
//    System.out.println(dList);
    
//    em.getTransaction().commit();
//    em.close();
//    emf.close();
        
        
        
        
        
        //System.out.println(facade.getPerson(2).getfName());
        
        //facade.setEmail(9, "bendsten@jawja"); //HVORFOR KAN JEG IKKE DET!!!!!!!!!!!!!!!!!!
//        System.out.println(facade.getPerson(4).getfName());


        //Person j1 = facade.getPerson(1);
//        Person j2 = facade.getPerson(2);
//        Person j3 = facade.getPerson(3);
        
        //System.out.println("firstname : "+j1.getfName()+", lastName: "+j1.getlName()+", id:"+j1.getId());
//        System.out.println("firstname : "+j2.getfName()+", lastName: "+j2.getlName()+", id:"+j2.getId());
//        System.out.println("firstname : "+j3.getfName()+", lastName: "+j3.getlName()+", id:"+j3.getId());
    }
}