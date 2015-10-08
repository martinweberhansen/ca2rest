package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    private List<InfoEntity> infoEntitys;
    
    
//    @OneToMany(mappedBy = "article", cascade = CascadeType.PERSIST)
//private List someOrAllHeaderFields = new ArrayList<>();
    
    
    
    
    @Id
    private int id;
    private String street;
    private String additionalInfo;
    private String cityName;

    public Address(int id, String street, String additionalInfo, String cityName) {
        this.id = id;
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.cityName = cityName;
    }
    
    public Address(){
        //infoEntitys = new ArrayList<>();
    }
    
    

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public void addEntity(InfoEntity ie) {
//        if (!getEntity().contains(ie)) {
            infoEntitys.add(ie);
//        }
     }
        
      public List<InfoEntity> getEntity() {
        return infoEntitys;
    }
}
