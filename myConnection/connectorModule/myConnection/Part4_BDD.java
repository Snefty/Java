package myConnection;

import java.sql.*;

public class Part4_BDD {
	
	public static void creerTable(Connection cn) throws SQLException {
		PreparedStatement pS;
		
		String table = "create table IF NOT EXISTS agence(noAg int AUTO_INCREMENT,nomAg VARCHAR(50),primary key (noAg))ENGINE = INNODB;";
		pS = cn.prepareStatement(table);
		
		String table2 = "CREATE TABLE IF NOT EXISTS client("
				+ "coCli int AUTO_INCREMENT,"
				+ "nomCli VARCHAR(50),"
				+ "'rueCli' VARCHAR(50),"
				+ "'villeCli' VARCHAR(50),"
				+ "'noAg' int,"
				+ "PRIMARY KEY ('coCli'),"
				+ "FOREIGN KEY ('noAg') REFERENCES agence('noAg')"
				+ ")ENGINE = INNODB";
		pS = cn.prepareStatement(table2);
		
		String table3 = "CREATE TABLE IF NOT EXISTS commande("
				+ "noBc int AUTO_INCREMENT,"
				+ "dateBc DATE,"
				+ "coCli int,"
				+ "PRIMARY KEY (noBc),"
				+ "FOREIGN KEY (coCli) REFERENCES client(coCli)"
				+ ")ENGINE = INNODB;";
		pS = cn.prepareStatement(table3);
		
		String table4 = "create table IF NOT EXISTS facture("
				+ "noFac int AUTO_INCREMENT,"
				+ "datefac Date,"
				+ "PRIMARY KEY (noFac)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table4);
		
		String table5 = "create table IF NOT EXISTS livraison("
				+ "noBl int AUTO_INCREMENT,"
				+ "dateBl DATE,"
				+ "noBc int,"
				+ "noFac int,"
				+ "PRIMARY KEY (noBl),"
				+ "FOREIGN KEY (noBc) REFERENCES commande(noBc),"
				+ "FOREIGN KEY (noFac) REFERENCES facture(noFac)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table5);
		
		String table6 = "create table IF NOT EXISTS tva("
				+ "codeTva int AUTO_INCREMENT,"
				+ "tauxTva DOUBLE,"
				+ "primary key (codeTva)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table6);
		
		String table7 = "create table IF NOT EXISTS produit("
				+ "refProd int AUTO_INCREMENT,"
				+ "desiProd VARCHAR(50),"
				+ "codeTva int,"
				+ "primary key (refProd),"
				+ "Foreign key (codeTva) references tva(codeTva)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table7);
		
		String table8 = "create table IF NOT EXISTS composer("
				+ "noBl int,"
				+ "refProd int,"
				+ "qtéLiv int,"
				+ "Foreign key (noBl) references livraison(noBl),"
				+ "Foreign key (refProd) references produit(refProd)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table8);
		
		String table9 = "create table IF NOT EXISTS concerner("
				+ "noBC int,"
				+ "refProd int,"
				+ "qteCom int,"
				+ "pUnit int,"
				+ "Foreign key (noBC) REFERENCES commande(noBc),"
				+ "Foreign key (refProd) REFERENCES produit(refProd)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table9);
		pS.execute();
	}
	
	public static void remplirTable(Connection cn) throws SQLException {
		PreparedStatement pS;
		
		String insert1 = "INSERT INTO agence(nomAg) VALUES "
				+ "('Vileo'),"
				+ "('Arkema'),"
				+ "('LilleOplus');";
		pS = cn.prepareStatement(insert1);
		
		String insert2 = "INSERT INTO client(nomCli, rueCli, villeCli, noAg) VALUES "
				+ "('Dupond','775 rue des pommiers','lille',1),"
				+ "('Jamon','89 rue des pommiers','Lyon',2),"
				+ "('Aubert','775 rue des aurbegines','lille',1),"
				+ "('Dupont','775 rue des pommiers',Valence,3);";
		pS = cn.prepareStatement(insert2);
		
		String insert3 = "INSERT INTO commande(dateBc, coCli) VALUES"
				+ "(2018,1),"
				+ "(2019,2),"
				+ "(2019,3);";
		pS = cn.prepareStatement(insert3);
		
		String insert4 = "INSERT INTO tva (tauxTva) VALUES "
				+ "(0.2),"
				+ "(0.5);";
		pS = cn.prepareStatement(insert4);
		
		String insert5 = "INSERT INTO produit(desiProd, codeTva) VALUES"
				+ "('lampe', 1),"
				+ "('Voiture', 2),"
				+ "('jolie petite voiture rouge',1);";
		pS = cn.prepareStatement(insert5);
		
		String insert6 = "INSERT INTO facture(datefac) VALUES "
				+ "(2017),"
				+ "(2018),";
		pS = cn.prepareStatement(insert6);
		
		String insert7 = "INSERT INTO livraison(dateBl, ,noBc, noFac) VALUES "
				+ "(2020,1,1),"
				+ "(2025,2,2);";
		pS = cn.prepareStatement(insert7);
		
		String insert8 = "INSERT INTO composer(noBl, refProd, qtéLiv) VALUES"
				+ "(1,2,1),"
				+ "(2,3,5),";
		pS = cn.prepareStatement(insert8);
		
		String insert9 = "INSERT INTO concerner(noBC, refProd, qteCom, pUnit) VALUES"
				+ "(1,2,5,4),"
				+ "(2,3,45,3);";
		pS = cn.prepareStatement(insert9);
		
		pS.execute();
	}
	
	public static void main(String[] args) throws SQLException {
		CreerConnexion cc = new CreerConnexion();
		Connection cn = cc.myCnx();
		//creerTable(cn);
		remplirTable(cn);
	}
	
}
