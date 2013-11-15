import java.sql.*;
import java.util.ArrayList;

public class m_connect {


//Connexion base de données	
public static Connection connect() {
	Connection connexion = null;
     try {
			Class.forName("com.mysql.jdbc.Driver");
		connexion = DriverManager.getConnection("jdbc:mysql://localhost/carnet", "root", "");
			
     } catch(ClassNotFoundException erreur) {
			System.out.println("Driver non chargé !" + erreur);
		
		
     }catch (SQLException erreur){
    		System.out.print (erreur);
     }
     return connexion ;
}
	
// permet de récuperer l'ensemble des contacts
     public static  <contact> ArrayList<contact>  afficheContact() throws SQLException {
    	ArrayList<contact> lesContacts = new ArrayList <contact> ();
		/*Statement st = connect().createStatement() ;
		ResultSet rs = st.executeQuery("select * from contact ");
		return lesContacts ;*/
		
		PreparedStatement statement = connect().prepareStatement("SELECT * FROM Contact ");
		ResultSet res = statement.executeQuery();
		return lesContacts ;

     }		
// permet de récupérer le nombre de contacts
     public static ResultSet  nbContact() throws SQLException {
		Statement ts = connect().createStatement();
		ResultSet sr = ts.executeQuery ( "select count" );
		return sr;
		
     }
		
// permet d'insérer un nouveau contact
    public static int  nvContact(String nom,String prenom,String email) 
     {
     int nbLignes = 0 ;
     try {
    	 Statement st = connect().createStatement() ;
		 //sr = st.executeUpdate("Insert into contact (nom,prenom,email) Values ('"+nom+"','"+prenom+"','"+email+"');");}
    	 PreparedStatement statement =  connect().prepareStatement("INSERT INTO Contact(nom, prenom, email) values (?, ?, ?)");
    	 statement.setString(1, nom);
    	 statement.setString(2, prenom);
    	 statement.setString(3, email);
    	 nbLignes = statement.executeUpdate();
     }

     catch (SQLException erreur){
 		System.out.print (erreur);
  }
	return nbLignes ;
     }

}
