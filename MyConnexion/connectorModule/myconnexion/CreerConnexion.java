package myconnexion;

import java.sql.*;

public class CreerConnexion {

	public final String URL = "jdbc:mysql://localhost:3306/sql_part4";
	public final String LOGIN = "root";
	public final String MDP = "";
	
	public Connection myCnx() {
		Connection cn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(URL, LOGIN, MDP);
			System.out.println("connexion reussie");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cn;
	}
	
	/*public static void main(String[] args) throws SQLException {
		CreerConnexion cc = new CreerConnexion();
		Connection cn = cc.myCnx();
		
		//Lancer des requêtes
		
		//PreparedStatement (Sans retour)
		String str = "";
		PreparedStatement pS;
		str = "insert into etudiant (nom, prenom, filiere) Values ('Dupon','Charle','Python')";
		pS = cn.prepareStatement(str);
		pS.execute();
		
		//Statement (Avec retour de résultat)
		Statement st;
		ResultSet rS;
		
		str = "Select * from etudiant where nom like 'Dupon'";
		st = cn.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("numero") + ", Le nom :" + rS.getString("nom"));
		}
		
	}*/

}
