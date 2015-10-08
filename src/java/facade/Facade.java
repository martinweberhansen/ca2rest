
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
    
    private final Person person;
    private final Hobby hobby;
    private final Address address;
    private final CityInfo cityInfo;
    private final Company company;
    private final InfoEntity infoEntity;
    private final Phone phone;
    
    private EntityManagerFactory emf;
    
    public Facade(){
        person = new Person();
        hobby = new Hobby();
        address = new Address();
        cityInfo = new CityInfo();
        company = new Company();
        infoEntity = new InfoEntity();
        phone = new Phone();
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
    
    public Person editPerson(Person p){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
       
        Person edited = em.find(Person.class, p.getId());
        
    }
    
    public void         setEmail(int id,String email){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        Person edited = em.find(Person.class, id);
        em.getTransaction().begin();
        Query query = em.createQuery(
                    "update InfoEntity ie set ie.email = "+email+" WHERE ie.id LIKE :theid")
                    .setParameter("theid", id);
        query.getSingleResult();
        //    .setParameter("emailla", email);
        
        em.getTransaction().commit();
        em.close();
        
    }
    
//    UPDATE Player p
//SET p.status = 'inactive'
//WHERE p.lastPlayed < :inactiveThresholdDate
//    
//    
//public List findWithName(String name) {
//return em.createQuery(
//    "SELECT c FROM Customer c WHERE c.name LIKE :custName")
//    .setParameter("custName", name)
//    .setMaxResults(10)
//    .getResultList();
//}
  
  
  
//    Company getCompany(String cvr){
//        
//    }
    
}
