package com.iapl.robot.apocalypse.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contamination {
	private @Id @GeneratedValue Long id;
    private String reportedSurvivor, inffectedSurvivor;
    
    Contamination(){}

	public Contamination(String reportedSurvivor, String inffectedSurvivor) {
		super();
		this.reportedSurvivor = reportedSurvivor;
		this.inffectedSurvivor = inffectedSurvivor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReportedSurvivor() {
		return reportedSurvivor;
	}

	public void setReportedSurvivor(String reportedSurvivor) {
		this.reportedSurvivor = reportedSurvivor;
	}

	public String getInffectedSurvivor() {
		return inffectedSurvivor;
	}

	public void setInffectedSurvivor(String inffectedSurvivor) {
		this.inffectedSurvivor = inffectedSurvivor;
	}
    
	
    @Override
    public boolean equals(Object o) {

      if (this == o)
        return true;
      if (!(o instanceof Contamination))
        return false;
      Contamination contamination = (Contamination) o;
      return Objects.equals(this.id, contamination.id) && Objects.equals(this.reportedSurvivor, contamination.reportedSurvivor)
    		  && Objects.equals(this.inffectedSurvivor, contamination.inffectedSurvivor);
    }
    
    @Override 
    public int hashCode() {
      return Objects.hash(this.id, this.reportedSurvivor, this.inffectedSurvivor);
    }

    @Override
    public String toString() {
      return "Survivor{" + "id=" + this.id + ", name='" + this.reportedSurvivor + '\'' + this.inffectedSurvivor +'}';
    }
    


}
