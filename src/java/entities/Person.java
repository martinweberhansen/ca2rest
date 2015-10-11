
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Person extends InfoEntity implements Serializable  {
    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Hobby> hobbies;
    
   
    private String fName;
    private String lName;

    public Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }
    
    public Person(){
    }
    
    public String   getfName() {
        return fName;
    }

    public void     setfName(String fName) {
        this.fName = fName;
    }

    public String   getlName() {
        return lName;
    }

    public void     setlName(String lName) {
        this.lName = lName;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void     setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public void     addHobby(Hobby hobby){
        hobbies.add(hobby);
    }
    
}
