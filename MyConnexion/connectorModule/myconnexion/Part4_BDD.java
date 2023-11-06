package myconnexion;

import java.sql.*;

public class Part4_BDD {
	
	public static void creerTable(Connection cn) throws SQLException {
		PreparedStatement pS;
		
		String table = "create table IF NOT EXISTS agence(noAg int AUTO_INCREMENT,nomAg VARCHAR(50),primary key (noAg))ENGINE = INNODB;";
		pS = cn.prepareStatement(table);
		pS.execute();
		
		String table2 = "CREATE TABLE IF NOT EXISTS client("
				+ "coCli int AUTO_INCREMENT,"
				+ "nomCli VARCHAR(50),"
				+ "rueCli VARCHAR(50),"
				+ "villeCli VARCHAR(50),"
				+ "noAg int,"
				+ "PRIMARY KEY (coCli),"
				+ "FOREIGN KEY (noAg) REFERENCES agence(noAg)"
				+ ")ENGINE = INNODB";
		pS = cn.prepareStatement(table2);
		pS.execute();
		
		String table10 = "CREATE TABLE IF NOT EXISTS fournisseur("
				+ "noF int AUTO_INCREMENT,"
				+ "nomF VARCHAR(50),"
				+ "adrF VARCHAR(50),"
				+ "telF VARCHAR(50),"
				+ "PRIMARY KEY (noF)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table10);
		pS.execute();
		
		String table3 = "CREATE TABLE IF NOT EXISTS commande("
				+ "noBc int AUTO_INCREMENT,"
				+ "dateBc DATE,"
				+ "coCli int,"
				+ "noF int,"
				+ "PRIMARY KEY (noBc),"
				+ "FOREIGN KEY (coCli) REFERENCES client(coCli),"
				+ "FOREIGN KEY (noF) REFERENCES fournisseur(noF)"
				+ ")ENGINE = INNODB;";
		pS = cn.prepareStatement(table3);
		pS.execute();
		
		String table4 = "create table IF NOT EXISTS facture("
				+ "noFac int AUTO_INCREMENT,"
				+ "datefac Date,"
				+ "PRIMARY KEY (noFac)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table4);
		pS.execute();
		
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
		pS.execute();
		
		String table6 = "create table IF NOT EXISTS tva("
				+ "codeTva int AUTO_INCREMENT,"
				+ "tauxTva DOUBLE,"
				+ "primary key (codeTva)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table6);
		pS.execute();
		
		String table7 = "create table IF NOT EXISTS produit("
				+ "refProd int AUTO_INCREMENT,"
				+ "desiProd VARCHAR(50),"
				+ "codeTva int,"
				+ "primary key (refProd),"
				+ "FOREIGN KEY (codeTva) REFERENCES tva(codeTva)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table7);
		pS.execute();
		
		String table8 = "create table IF NOT EXISTS composer("
				+ "noBL int,"
				+ "refProd int,"
				+ "qtéLiv int,"
				+ "FOREIGN KEY (noBL) REFERENCES livraison(noBl),"
				+ "FOREIGN KEY (refProd) REFERENCES produit(refProd)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table8);
		pS.execute();
		
		String table9 = "create table IF NOT EXISTS concerner("
				+ "noBC int,"
				+ "refProd int,"
				+ "qteCom int,"
				+ "pUnit int,"
				+ "FOREIGN KEY (noBC) REFERENCES commande(noBc),"
				+ "FOREIGN KEY (refProd) REFERENCES produit(refProd)"
				+ ")ENGINE = INNODB;";
		
		pS = cn.prepareStatement(table9);
		pS.execute();
		
	}
	
	public static void remplirTable(Connection cn) throws SQLException {
		PreparedStatement pS;
		String inserInto = "";
		
		inserInto = "INSERT INTO agence (nomag) VALUES\n"
				+ "('sud-est'),\n"
				+ "('sud-ouest'),\n"
				+ "('sud'),\n"
				+ "('nord'),\n"
				+ "('nord-est'),\n"
				+ "('nord-ouest'),\n"
				+ "('ANTARIA'),\n"
				+ "('ABYSSE');";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
		// table client
		inserInto = "INSERT INTO client (nomcli, ruecli, villecli, noag) VALUES\n"
				+ "('Atef', 'general de gaule', 'Lille', 8),\n"
				+ "('Chloe', 'des braves', 'Cergy', 7);";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
		// table tva
		inserInto = "INSERT INTO tva (tauxtva) VALUES\n"
				+ "(20),\n"
				+ "(10);";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
		// table produit
		inserInto = "INSERT INTO produit (desiprod, codetva) VALUES\n"
				+ "('Ecran', 1),\n"
				+ "('Souris', 1),\n"
				+ "('Tapis', 2),\n"
				+ "('Tableau', 2),\n"
				+ "('Roue', 1),\n"
				+ "('Unite', 1),\n"
				+ "('Chevre', 2),\n"
				+ "('Carabine', 1),\n"
				+ "('Chocolat', 2),\n"
				+ "('Feu de camp', 2);";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
		// table fournisseur
		inserInto = "INSERT INTO fournisseur (nomf, adrf, telf) VALUES\n"
				+ "('OREXAD', 'Bondue', '123456789'),\n"
				+ "('INSY2S', 'Lille', '123456789');";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
		// table facture
		inserInto = "INSERT INTO facture (datefac) VALUES\n"
				+ "('2023-05-01'),\n"
				+ "('2023-04-11'),\n"
				+ "('2022-12-04'),\n"
				+ "('2022-12-13');";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
		// table commande
		inserInto = "INSERT INTO commande (datebc, cocli, nofrs) VALUES\n"
				+ "('2023-05-23', 1, 2),\n"
				+ "('2023-04-29', 2, 1);";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
		// table livraison
		inserInto = "INSERT INTO livraison (datebl, nobc, nofac) VALUES\n"
				+ "('2023-05-23', 1, 1),\n"
				+ "('2023-05-15', 2, 2);";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
		// table composer
		inserInto = "INSERT INTO composer (nobl, refprod, qteliv) VALUES\n"
				+ "(1, 1, 5),\n"
				+ "(1, 2, 7),\n"
				+ "(1, 3, 5),\n"
				+ "(1, 9, 23),\n"
				+ "(2, 7, 3),\n"
				+ "(2, 8, 2);";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
		// table concerner
		inserInto = "INSERT INTO concerner (nobc, refprod, qtecom, punit) VALUES\n"
				+ "(1, 1, 5, 200),\n"
				+ "(1, 2, 7, 9),\n"
				+ "(1, 3, 5, 4),\n"
				+ "(1, 9, 23, 2),\n"
				+ "(2, 7, 3, 120),\n"
				+ "(2, 8, 3, 999);";
		pS = cn.prepareStatement(inserInto);
		pS.execute();
	}
	
	public static void dropTable(Connection cn) throws SQLException {
		PreparedStatement pS;
		String drop1 = "";
		
		
		drop1 = "DROP TABLE IF EXISTS concerner;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
		drop1 = "DROP TABLE IF EXISTS composer;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
		drop1 = "DROP TABLE IF EXISTS produit;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
		drop1 = "DROP TABLE IF EXISTS tva;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
		drop1 = "DROP TABLE IF EXISTS livraison;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
		drop1 = "DROP TABLE IF EXISTS facture;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
		drop1 = "DROP TABLE IF EXISTS commande;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
		drop1 = "DROP TABLE IF EXISTS fournisseur;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
		drop1 = "DROP TABLE IF EXISTS client;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
		drop1 = "DROP TABLE IF EXISTS agence;";
		pS = cn.prepareStatement(drop1);
		pS.execute();
	}
	
	public static void main(String[] args) throws SQLException {
		CreerConnexion cc = new CreerConnexion();
		Connection cn = cc.myCnx();
		
		/*dropTable(cn);
		creerTable(cn);
		remplirTable(cn);
		*/
		
		RequeteSLQ rSQL = new RequeteSLQ();
		//rSQL.requete1(cn);
		//rSQL.requete2(cn);
		//rSQL.requete3(cn);
		//rSQL.requete4(cn);
		//rSQL.requete5(cn);
		//rSQL.requete6(cn);
		//rSQL.requete7(cn);
		//rSQL.requete8(cn);
		//rSQL.requete9(cn);
		rSQL.requete10(cn);
	}
	
}
