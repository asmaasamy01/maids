package com.maids.liberary.manager.data.patron;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Patron {
	
	 @Id 
		@SequenceGenerator(name = "PATRON_GEN", sequenceName = "seq_patron",allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATRON_GEN")
     private Long id;
     private String name;
     private  String dial;
     private  String address;
	
	
	
	
        public Long getId() {
		return id;
	}

        public Patron() {
        	
        }


	public Patron(Long id, String name, String dial, String address) {
			super();
			this.id = id;
			this.name = name;
			this.dial = dial;
			this.address = address;
		}




	public void setId(Long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getDial() {
		return dial;
	}




	public void setDial(String dial) {
		this.dial = dial;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




		public Patron updatePatron(String name,String dial,String address){
              return new Patron(this.id,name,dial,address);
        }
}
