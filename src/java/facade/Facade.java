
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
    
    public Person getPerson(int id){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        return p;
    }
    
      public void addPerson(Person p){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        
        Person newPerson = p;
        
        em.getTransaction().begin();
        em.persist(newPerson);
        em.getTransaction().commit();
        em.close();
    }
    
    List<Person> getPersons(){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createNamedQuery("SELECT p FROM person p");
        List result = query.getResultList();
        em.getTransaction().commit();
        return result;
    } 
    
    List<Person> getPersons(int zipCode){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createNamedQuery("SELECT p FROM person p where zipcode");
        List result = query.getResultList();
        em.getTransaction().commit();
        return result;
    } 
    
    Company getCompany(String cvr){
        
    }
    
}
