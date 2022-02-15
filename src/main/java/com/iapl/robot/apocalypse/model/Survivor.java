package com.iapl.robot.apocalypse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Survivor {
	
	
	private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String lastLocationLatitude;
    private String lastLocationLongitude;
    private int survivorStatus;
    
    @Value("#{'${resource}'.split(',')}")
    @ElementCollection
    private List<String> resources;
    
    Survivor() {}
    
    

	public Survivor(String firstName, String lastName, String age, String gender, String lastLocationLatitude,
			String lastLocationLongitude,  List<String> resources) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.lastLocationLatitude = lastLocationLatitude;
		this.lastLocationLongitude = lastLocationLongitude;
		this.resources = resources;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastLocationLatitude() {
		return lastLocationLatitude;
	}

	public void setLastLocationLatitude(String lastLocationLatitude) {
		this.lastLocationLatitude = lastLocationLatitude;
	}

	public String getLastLocationLongitude() {
		return lastLocationLongitude;
	}

	public void setLastLocationLongitude(String lastLocationLongitude) {
		this.lastLocationLongitude = lastLocationLongitude;
	}
	public int getSurvivorStatus() {
		return survivorStatus;
	}

	public void setSurvivorStatus(int survivorStatus) {
		this.survivorStatus = survivorStatus;
	}
	
	
    public List<String> getResources() {
		return resources;
	}

	public void setResources(List<String> resources) {
		this.resources = resources;
	}


	@Override
    public boolean equals(Object o) {

      if (this == o)
        return true;
      if (!(o instanceof Survivor))
        return false;
      Survivor robotSurvivor = (Survivor) o;
      return Objects.equals(this.id, robotSurvivor.id) && Objects.equals(this.firstName, robotSurvivor.firstName)
    		  && Objects.equals(this.lastName, robotSurvivor.lastName) && Objects.equals(this.age, robotSurvivor.age)
    		  && Objects.equals(this.gender, robotSurvivor.gender) && Objects.equals(this.lastLocationLatitude, robotSurvivor.lastLocationLongitude);
    }
    
    @Override 
    public int hashCode() {
      return Objects.hash(this.id, this.firstName, this.lastName, this.age, this.gender, this.lastLocationLatitude, this.lastLocationLongitude, this.survivorStatus);
    }

    @Override
    public String toString() {
      return "Survivor{" + "id=" + this.id + ", name='" + this.firstName + '\'' + this.lastName + '\'' + " age="+ this.age +'\''+ "gender"+ this.gender + '\'' +"last location Lat.="+ this.lastLocationLatitude + '\'' +"last location Long.="+ this.lastLocationLongitude+ '\'' +"survivor status="+ this.survivorStatus+'}';
    }
    


}
