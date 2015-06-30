import java.util.Date;

public class Person {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private int studentID;
	private Date dateOfBirth;
	private Address address;
	private String major;
	
	
	public Person(){} //Empty constructor
	
	//Overloaded constructor
	public Person(int id, String first, String last, String maj, String email, String phone, Date dob, Address add, int zip)
	{
		setStudentID(id);
		setFirstName(first);
		setLastName(last);
		setMajor(maj);
		setEmail(email);
		setPhoneNumber(phone);
		setDateOfBirth(dob);
		setAddress(add, zip);
	}
	
	
	//Set methods
	public void setStudentID(int id){
		studentID = id;
	}
	
	public void setFirstName(String f){
		firstName = f;
	}
	
	public void setLastName(String l){
		lastName = l;
	}
	
	public void setMajor(String m){
		major = m;
	}
	
	public void setEmail(String e){
		email = e;
	}
	
	public void setPhoneNumber(String p){
		phoneNumber = p;
	}
	
	public void setDateOfBirth(Date d){
		dateOfBirth = d;
	}
	
	public void setAddress(Address a, int z){
		address = a;
		a.setZip(z);
	}
	
		
	//Get methods
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getMajor(){
		return major;
	}
	
	public int getStudentID(){
		return studentID;
	}
	
	public Address getAddress(){
		return address;
	}
	
	public Date getDateOfBirth(){
		return dateOfBirth;
	}

}
