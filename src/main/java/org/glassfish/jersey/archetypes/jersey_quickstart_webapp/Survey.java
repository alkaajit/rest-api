package org.glassfish.jersey.archetypes.jersey_quickstart_webapp;

public class Survey {
	   private int id;
	   private String first_name;
	   private String last_name;
	   private String Street_Addr;
	   private String City;
	   private String State;
	   private int ZIP;
	   private int Tel_NO;
	   private String E_Mail;
	   private String Dat;
	   private String Abt_Campus;
	   private String Uni_Ist;
	   private String Recommendation;
	     

	   public Survey() {}
	   public Survey(String first_name, String last_name, String Street_Addr,String City,String State,int ZIP,int Tel_NO,String E_Mail,String Dat,String Abt_Campus,String Uni_Ist,String Recommendation) {
	      this.first_name = first_name;
	      this.last_name = last_name;
	      this.Street_Addr= Street_Addr;
	      this.City = City;
	      this.State = State ;
	      this.ZIP = ZIP;
	      this.Tel_NO=Tel_NO;
	      this.E_Mail = E_Mail;
	      this.Dat = Dat;
	      this.Abt_Campus=Abt_Campus;
	      this.Uni_Ist=Uni_Ist;
	      this.Recommendation=Recommendation;
	   }
	   
	   public int getId() {
	      return id;
	   }
	   
	   public void setId( int id ) {
	      this.id = id;
	   }
	   
	public String getFirst_name() {
	return first_name;
	}
	public void setFirst_name(String first_name) {
	this.first_name = first_name;
	}
	public String getLast_name() {
	return last_name;
	}
	public void setLast_name(String last_name) {
	this.last_name = last_name;
	}
	public String getCity() {
	return City;
	}
	public void setCity(String city) {
	this.City = city;
	}
	public String getStreet_Addr() {
	return Street_Addr;
	}
	public void setStreet_Addr(String street_Addr) {
	this.Street_Addr = street_Addr;
	}
	public String getState() {
	return State;
	}
	public void setState(String state) {
	this.State = state;
	}
	public int getZIP() {
	return ZIP;
	}
	public void setZIP(int zIP) {
	this.ZIP = zIP;
	}
	public int getTel_NO() {
	return Tel_NO;
	}
	public void setTel_NO(int tel_NO) {
	this.Tel_NO = tel_NO;
	}
	public String getE_Mail() {
	return E_Mail;
	}
	public void setE_Mail(String e_Mail) {
	this.E_Mail = e_Mail;
	}
	public String getDat() {
	return Dat;
	}
	public void setDat(String dat) {
	this.Dat = dat;
	}
	public String getAbt_Campus() {
	return Abt_Campus;
	}
	public void setAbt_Campus(String abt_Campus) {
	this.Abt_Campus = abt_Campus;
	}
	public String getUni_Ist() {
	return Uni_Ist;
	}
	public void setUni_Ist(String uni_Ist) {
	this.Uni_Ist = uni_Ist;
	}
	public String getRecommendation() {
	return Recommendation;
	}
	public void setRecommendation(String recommendation) {
	Recommendation = recommendation;
	}
	}
