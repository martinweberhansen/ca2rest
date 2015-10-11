
package facade;

import deploy.DeploymentConfiguration;
import entities.Address;
import entities.CityInfo;
import entities.Company;
import entities.Hobby;
import entities.InfoEntity;
import entities.Person;
import entities.Phone;
import exception.PersonNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Facade {
    
    private EntityManagerFactory emf;
    
    
    public Facade(){
    }
    
    /*****************************************************************
                           facade getters
     *****************************************************************/
    public Person       getPerson(int id)throws PersonNotFoundException{
        
        emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        EntityManager em = emf.createEntityManager();
        if(id<1){
            throw new PersonNotFoundException("person dosn´t exist..");
        }
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        return p;
    }
    
    public Hobby        getHobbyByPerson(Person person){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Hobby hobby = em.find(Hobby.class, person.getId());
        em.getTransaction().commit();
        em.close();
        return hobby;
    }
    
    public InfoEntity   getInfoEntity(int id){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        InfoEntity ie = em.find(InfoEntity.class, id);
        em.close();
        return ie;
    }
    
    public Hobby        getHobbyById(int id){
         emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Hobby hobby = em.find(Hobby.class, id);
        em.getTransaction().commit();
        em.close();
        return hobby;
    }
    
    
    
     
     
     /*****************************************************************
                            facade getters lists
     * @return 
     *****************************************************************/
    public List<Person> getPersons(){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List result  = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
            
        em.getTransaction().commit();
        return result;
    } 
    
    public List<Person> getPersons(String zip){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        
        TypedQuery<Person> query = em.createQuery(
        "SELECT DISTINCT g FROM address p LEFT JOIN a.cityinfo_zipcode g " +
        "WHERE p.id = :user", Person.class);
        query.setParameter("user", zip);
        
        
//        Query query = em.createQuery(
//                    
//                    
//                    "select * from person p join p.address a where p.cityinfo_zipcode like :thezip") 
//                    
                
//                
//                "SELECT a FROM A a "
//    + "INNER JOIN a.b b "
//    + "INNER JOIN b.c "
//
//"SELECT c.b.a FROM C c "
                    
//                    .setParameter("thezip", zip);
      
        //"select * from person p join Address a on p.id = a.id where a.cityinfo_zipcode like :thezip")
//        SELECT c.name, d.rate FROM Customer c JOIN c.discountCode d WHERE d.rate>15 
        
//        Query query = em.createNamedQuery("select * from person   p join Address a on p.id  = a.id where a.cityinfo_zipcode = "+zip);
        List result = query.getResultList();
        em.getTransaction().commit();
        return result;
    }
    
    public List<Person> getPersonsByHobby(Hobby hobby){
         emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createNativeQuery("select * from person p join person_hobby ph  where p.`ID`=ph.`persons_ID` and  ph.hobbies_id="+hobby.getId());
        
        List res = query.getResultList();
        
//        List result = new ArrayList();
//        for (int i = 0; i < tempResult.size(); i++) {
//            Person p = em.find(Person.class,tempResult.get(i));
//            result.add(p);
//        }
        
        em.getTransaction().commit();
        em.close();
        return res;
    }
    
    public List<Person> getPersonsByHobbyId(String id ){
         emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Person> l = em.createNativeQuery("select p.id as id, p.fName as fName, p.lName as lName "
                + "from person p join person_hobby ph  where p.`ID`=ph.`persons_ID` and  ph.hobbies_id="+id,Person.class).getResultList();
        
        em.getTransaction().commit();
        em.close();
        return l;
        
//      List<Author> results = this.em.createNativeQuery("SELECT a.id, a.firstName, a.lastName, a.version FROM Author a", Author.class).getResultList();
//      List<Author> results = this.em.createNativeQuery("SELECT a.id as authorId, a.firstName, a.lastName, a.version FROM Author a", "AuthorMapping").getResultList();

         
     }
        
  
    /*****************************************************************
                            facade delete
     *****************************************************************/
    public void         deletePerson(int id) throws PersonNotFoundException{
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        if(id != p.getId())
            throw new PersonNotFoundException("ERROR!!!!!!!");
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }
    
    
    
    /*****************************************************************
                          facade add single
     *****************************************************************/
    public void         addPerson(Person p){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        Person newPerson = p;
        em.getTransaction().begin();
        em.persist(newPerson);
        em.getTransaction().commit();
        em.close();
    }
    
    public void         addHobby(Hobby hobby){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(hobby);
        em.getTransaction().commit();
        em.close();
    }
    
    
    
    /*****************************************************************
                         facade add to other
     *****************************************************************/
    public void         addAddressToEntity(Address address, InfoEntity ie){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        ie.setAddress(address);
        em.getTransaction().begin();
        em.merge(ie);
        //em.flush();
        em.getTransaction().commit();
        em.close();
    }
    
    public void         addHobbyToPerson(Hobby hobby, Person person){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        person.addHobby(hobby);
        em.getTransaction().commit();
        em.close();
    }
    
    public void         addAddressToCityInfo(Address address,CityInfo cityInfo){
        emf = Persistence.createEntityManagerFactory("CA2_projectPU");
        EntityManager em = emf.createEntityManager();
        
        cityInfo.setAddress(address);
        em.getTransaction().begin();
        em.merge(cityInfo);
        em.getTransaction().commit();
        em.close();
    }
    
    
    
    /*****************************************************************
                           facade update
     *****************************************************************/
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
    
}
