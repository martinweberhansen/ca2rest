package test;

import deploy.DeploymentConfiguration;
import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.InfoEntity;
import entities.Person;
import exception.PersonNotFoundException;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InserterClass {
    public static void main(String[] args) throws PersonNotFoundException {
        
        Facade facade = new Facade();
        
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        EntityManager em = emf.createEntityManager();
        
    em.getTransaction().begin();
    
        
    List<Person> l = facade.getPersons();
//        for (Person p : l) {
//            System.out.println(p.getfName()+" : fName");
//            System.out.println(p.getlName()+": lName");
//            System.out.println(p.getEmail()+" :EMAIL");
//            System.out.println(p.getId()+" : ID");
//        }
    
//       List<Person> list = facade.getPersonsByHobbyId("1");
    
//        System.out.println(list.get(1).getfName());
        
//         for (Person p : list){
//             System.out.println(p.getfName()+" : name");
//        }

       
       
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }
    
//    Hobby hobby = new Hobby();
//    hobby.setDescription("spilles med fjer..");
//    hobby.setName("badminton");
//    em.persist(hobby);
    
//        System.out.println(facade.getHobbyById(1).getName()+"NAME!!!!!!!!!");
//    System.out.println(facade.getHobbyById(1).getId()+"   ID:::::");
//    Address addr = em.find(Address.class, 3);
//    CityInfo ci = em.find(CityInfo.class, 2800);
//        System.out.println(addr.getCityName()+"thins is address");
//     System.out.println(ci.getCity());
//     
//     facade.addAddressToCityInfo(addr, ci);
     
     
     
        
//    Person p1 = new Person( "peterf1", "peterl1");
//    Person p2 = new Person( "peterf2", "peterl2");
//    Person p3 = new Person( "peterf3", "peterl3");                        
//    
//    em.persist(p1);
//    em.persist(p2);
//    em.persist(p3);
        
        
//    Address addr = new Address();            
//    addr.setCityName("lyngby");
//    addr.setAdditionalInfo("stuen,th");
//    addr.setStreet("Lyngby Hovedgade 15");    
//    em.persist(addr);

        
//        EntityManagerFactory emf;
//        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
//        EntityManager em = emf.createEntityManager();
//    
//        em.getTransaction().begin();
//
//            Address addr = em.find(Address.class, 1);
//            InfoEntity ie = em.find(InfoEntity.class, 1);
//
//    
//    facade.addAddressToEntity(addr, ie);
//    
    em.getTransaction().commit();
    em.close();
    emf.close();
    
   
    
    
     //     System.out.println(addr.getId());
//        System.out.println(person.getId());
    
    
//        Address addr = new Address();
//    addr.setCityName("Herning");
//    addr.setAdditionalInfo("3,th");
//    addr.setStreet("HerningVej 13");
//    
//    em.persist(addr);
//      
//    
//    Person p1 = new Person( "peter1", "peter1");
//    Person p2 = new Person( "peter2", "peter2");
//    Person p3 = new Person( "peter3", "peter3");
//    
//    em.persist(p1);
//    em.persist(p2);
//    em.persist(p3);
//    
//    

//        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        

       
    
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
    
    
    
    
        
//        System.out.println(facade.getPerson(2).getfName());
//        
//        facade.setEmail(9, "bendsten@jawja"); //HVORFOR KAN JEG IKKE DET!!!!!!!!!!!!!!!!!!
//        System.out.println(facade.getPerson(4).getfName());


       // Person j1 = facade.getPerson(1);
//        Person j2 = facade.getPerson(2);
//        Person j3 = facade.getPerson(3);
        
        //System.out.println("firstname : "+j1.getfName()+", lastName: "+j1.getlName()+", id:"+j1.getId());
//        System.out.println("firstname : "+j2.getfName()+", lastName: "+j2.getlName()+", id:"+j2.getId());
//        System.out.println("firstname : "+j3.getfName()+", lastName: "+j3.getlName()+", id:"+j3.getId());
    }
}