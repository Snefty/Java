package myConnection;

import java.sql.*;

public class RequeteSLQ {
	
	public void requete1(Connection n) throws SQLException {
		Statement st;
		ResultSet rS;
		
		String str = "Select * "
				+ "from produit "
				+ "GROUP BY desiProd";
		st = n.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("refProd") + ", Le nom :" + rS.getString("desiProd"));
		}
	}
	
	public void requete2(Connection n) throws SQLException {
		Statement st;
		ResultSet rS;
		
		String str = "Select * "
				+ "from produit"
				+ "WHERE refProd < 15";
		st = n.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("refProd") + ", Le nom :" + rS.getString("desiProd"));
		}
	}
	
	public void requete3(Connection n) throws SQLException {
		Statement st;
		ResultSet rS;
		
		String str = "Select p.* "
				+ "from produit p JOIN composer c"
				+ "ON p.refProd = c.refProd"
				+ "WHERE p.refProd < 15"
				+ "AND c.nobL >= 15;";
		st = n.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("refProd") + ", Le nom :" + rS.getString("desiProd"));
		}
	}
	
	public void requete4(Connection n) throws SQLException {
		Statement st;
		ResultSet rS;
		
		String str = "Select p.* "
				+ "from produit p JOIN composer c"
				+ "ON p.refProd = c.refProd"
				+ "WHERE p.refProd < 15"
				+ "OR p.refProd BETWEEN 30 AND 40"
				+ "AND c.nobL >= 15;";
		st = n.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("refProd") + ", Le nom :" + rS.getString("desiProd"));
		}
	}
	
	public void requete5(Connection n) throws SQLException {
		Statement st;
		ResultSet rS;
		
		String str = "Select p.* "
				+ "from produit p"
				+ "WHERE p.refProd < 15"
				+ "OR p.refProd BETWEEN 30 AND 40"
				+ "OR c.prefProd >= 70;";
		st = n.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("refProd") + ", Le nom :" + rS.getString("desiProd"));
		}
	}
	
	public void requete6(Connection n) throws SQLException {
		Statement st;
		ResultSet rS;
		
		String str = "Select p.* "
				+ "from produit p"
				+ "WHERE p.desiProd LIKE '%E'";
		st = n.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("refProd") + ", Le nom :" + rS.getString("desiProd"));
		}
	}
	
	public void requete7(Connection n) throws SQLException {
		Statement st;
		ResultSet rS;
		
		String str = "Select p.* "
				+ "from produit p"
				+ "WHERE p.desiProd LIKE 'E%'";
		st = n.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("refProd") + ", Le nom :" + rS.getString("desiProd"));
		}
	}
	
	public void requete8(Connection n) throws SQLException {
		Statement st;
		ResultSet rS;
		
		String str = "Select p.* "
				+ "from produit p"
				+ "WHERE p.desiProd LIKE '%E%'";
		st = n.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("refProd") + ", Le nom :" + rS.getString("desiProd"));
		}
	}
	
	public void requete9(Connection n) throws SQLException {
		Statement st;
		ResultSet rS;
		
		String str = "Select p.* "
				+ "from produit p"
				+ "WHERE p.desiProd LIKE 'E%'";
		st = n.createStatement();
		rS = st.executeQuery(str);
		
		//Parcourir le résultat stocké dans rs
		while(rS.next()) {
			System.out.println("Numéro : " + rS.getInt("refProd") + ", Le nom :" + rS.getString("desiProd"));
		}
	}
}
