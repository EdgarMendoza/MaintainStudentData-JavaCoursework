
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries {

	
	private static final String URL = "jdbc:derby:education";
	private static final String USERNAME = "java2hw4";
	private static final String PASSWORD = "java2hw4";
	
	private Connection connection = null;
	private PreparedStatement selectAllPeople = null;
	private PreparedStatement selectPeopleByLastName = null;
	private PreparedStatement insertNewPerson = null;
	
	public PersonQueries(){
		
		try{
			connection = DriverManager.getConnection( URL, USERNAME, PASSWORD);;
			
			selectAllPeople = connection.prepareStatement("SELECT * FROM Student" );
			selectPeopleByLastName = connection.prepareStatement("SELECT * FROM Student WHERE lastName = ?");
			insertNewPerson = connection.prepareStatement(
					"INSERT INTO Student " +
					"( firstName, lastName, Email, Phone )" +
					"VALUES ( ?, ?, ?, ? )" );
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			System.exit(1);
		}
	}
	
	public List<Person> getAllPeople(){
		 List<Person> results = null;
		 ResultSet resultSet = null;
		 
		 try{
			 resultSet = selectAllPeople.executeQuery();
			 results = new ArrayList<Person>();
			 
			 while(resultSet.next()){
				 results.add(new Person(
						 resultSet.getInt("studentID"),
						 resultSet.getString("firstName"),
						 resultSet.getString("lastName"),
						 resultSet.getString("Email"),
						 resultSet.getString("Phone"),
						 resultSet.getString("birthdate"),
						 resultSet.getString("Address"),
						 resultSet.getString("zipCode")));
			 }
		 }catch(SQLException sqle){
			 sqle.printStackTrace();
		 }finally{
			 try{
				 resultSet.close();
			 }catch(SQLException sqle){
				 sqle.printStackTrace();
				 close();
			 }
		 }
		 
		 return results;
	}
	
	public List<Person> getPeopleByLastName(String name){
		
		List<Person> results = null;
		ResultSet resultSet = null;
		
		try{
			selectPeopleByLastName.setString(1, name);
			resultSet =selectPeopleByLastName.executeQuery();
			
			results = new ArrayList<Person>();
			 
			 while(resultSet.next()){
				 results.add(new Person(
						 resultSet.getInt("studentID"),
						 resultSet.getString("firstName"),
						 resultSet.getString("lastName"),
						 resultSet.getString("Email"),
						 resultSet.getString("Phone"),
						 resultSet.getString("birthdate"),
						 resultSet.getString("Address"),
						 resultSet.getString("zipCode")));
			 }
		 }catch(SQLException sqle){
			 sqle.printStackTrace();
		 }finally{
			 try{
				 resultSet.close();
			 }catch(SQLException sqle){
				 sqle.printStackTrace();
				 close();
			 }
		 }
		 
		 return results;
		
	}
	
	public int addPerson(String fName, String lName, String e, String p){
		
		int result = 0;
		
		try{
			insertNewPerson.setString(1, fName);
			insertNewPerson.setString(2, lName);
			insertNewPerson.setString(3, e);
			insertNewPerson.setString(4, p);
			
			result = insertNewPerson.executeUpdate();
		
		}catch(SQLException sqle){
			sqle.printStackTrace();
			close();
		}
		return result;
	}
	
	
	public void close(){
		
		try{
			connection.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
}
