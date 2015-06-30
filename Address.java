public class Address {

	//Private variables to hold address information
	private String street;
	private String city;
	private String state;
	private int zip;
	
	//Default constructor
	public Address(){
		this("","","",0);
	}
	
	public Address(String s, String c, String st){
		setStreet(s);
		setCity(c);
		setState(st);
		setZip(0);
	}
	
	//Overloaded constructor
	public Address(String s, String c, String st, int z){
		setStreet(s);
		setCity(c);
		setState(st);
		setZip(z);
	}
	
	//Set methods
	public void setStreet(String s){
		street = s;
	}
	
	public void setCity(String c){
		city = c;
	}
	
	public void setState(String s){
		state = s;
	}
	
	public void setZip(int z){
		zip = z;
	}
	
	//Get methods
	public String getStreet(){
		return street;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getState(){
		return state;
	}
	
	public int getZip(){
		return zip;
	}
	
	//Overridden toString method
	@Override
	public String toString(){
		return String.format("%s, %s, %s  %d", getStreet(), getCity(), getState(), getZip());
	}
}

