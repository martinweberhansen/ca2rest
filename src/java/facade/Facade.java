
package facade;

import entities.Address;
import entities.CityInfo;
import entities.Company;
import entities.Hobby;
import entities.InfoEntity;
import entities.Person;
import entities.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Facade {
    
    private EntityManagerFactory emf;
    
    public Facade(){
    }
    
    public Person       getPerson(int id){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        return p;
    }
    
    public void         addPerson(Person p){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        
        Person newPerson = p;
        
        em.getTransaction().begin();
        em.persist(newPerson);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Person> getPersons(){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createNamedQuery("SELECT p FROM person p");
        List result = query.getResultList();
        em.getTransaction().commit();
        return result;
    } 
    
    public void         deletePerson(int id){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        
        Person p = em.find(Person.class, id);
        
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Person> getPersons(int zipCode){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createNamedQuery("SELECT p FROM person p where zipcode");
        List result = query.getResultList();
        em.getTransaction().commit();
        return result;
    } 
    
    public InfoEntity   getInfoEntity(int id){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        InfoEntity ie = em.find(InfoEntity.class, id);
        return ie;
    }
    
    public void         updateEmail(int id,String email){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createQuery(
                    "update InfoEntity ie set ie.email = :emailla WHERE ie.id LIKE :theid")
                    .setParameter("theid", id)
                    .setParameter("emailla", email);
        query.executeUpdate();
        
        em.getTransaction().commit();
        em.close();   
    }
    
    public void         addAddressToPerson(Address address, Person person){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        
        
        em.getTransaction().begin();
        
        em.persist(person);
        address.addEntity(person);
        em.flush();
        
       
        em.persist(address);
        
        
        em.getTransaction().commit();
        
         
        em.close();
    }
    
     

    
  
  
//    Company getCompany(String cvr){
//        
//    }
    
}
