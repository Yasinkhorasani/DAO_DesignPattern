package de.dernerdhaekelt.backend;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AmigurumiMitDB implements AmigurumiDao {

	private String url = "jdbc:mysql://127.0.0.1:3306/amigurumidb";
	private String user = "root";
	private String passwort = "";
	

	@Override
	public List<Amigurumi> getAllAmigurumis() {
		List<Amigurumi> dieAmigurumi = new ArrayList<>();

		String sql = "SELECT * FROM ammi";

		try (Connection verbindung = DriverManager.getConnection(url, user, passwort);
				Statement verpackung = verbindung.createStatement();
				ResultSet antwort = verpackung.executeQuery(sql)) {
			while (antwort.next()) {

				int primaerschluessel = antwort.getInt("ammiId");
				String name = antwort.getString("name");
				String art = antwort.getString("art");
				boolean kleinkindGeeignet = antwort.getBoolean("kleinKindGeeignet");
				int preis = antwort.getInt("preis");
				LocalDate verfuegbarAb = antwort.getDate("verfuegbarkeit").toLocalDate();

				Amigurumi gelesenerGummi = new Amigurumi(name, art, kleinkindGeeignet, preis, verfuegbarAb);
				gelesenerGummi.setPrimaerSchluessel(primaerschluessel);

				dieAmigurumi.add(gelesenerGummi);
			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}

		return dieAmigurumi;	
	}
	

	@Override
	public void addAmigurumi(Amigurumi speichern) {
		if(speichern.getPrimaerSchluessel() != 0) {
			System.out.println("Es gibt schon Datensatz");
			return;
		} 
		
		String sqlEingabe = "INSERT INTO ammi VALUE(NULL, ?,?,?,?,?)";
		
		try(Connection connect = DriverManager.getConnection(url, user, passwort);
				PreparedStatement statment = connect.prepareStatement(sqlEingabe, Statement.RETURN_GENERATED_KEYS)){

			statment.setString(1, speichern.getName());
			statment.setString(2,speichern.getArt());
			statment.setBoolean(3, speichern.isKleinkindGeeignet());
			statment.setInt(4, speichern.getPreis());
			statment.setDate(5, Date.valueOf(speichern.getVerfuegbarAb()));
			
			statment.execute();
			ResultSet antwort = statment.getGeneratedKeys();
			antwort.next();
			int id = antwort.getInt(1);
			speichern.setPrimaerSchluessel(id);
			
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
	

	@Override
	public void deleteAmigurumi(Amigurumi name) {
		String sqlDelet = "DELETE FROM ammi WHERE art = '" + name+ "'";
		try(Connection connect = DriverManager.getConnection(url, user, passwort);
				Statement statement = connect.createStatement()){
			statement.execute(sqlDelet);
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}

	
	@Override
	public void updateAmigurumi(Amigurumi pet) {
		String sqlupdate = "UPDATE ammi SET name =  'mishi' WHERE ammiId = 1";
		try(Connection connect = DriverManager.getConnection(url, user, passwort);
				Statement statement = connect.createStatement()){
			statement.execute(sqlupdate);
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}

	}

}
