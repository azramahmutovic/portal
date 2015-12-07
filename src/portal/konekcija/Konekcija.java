package portal.konekcija;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp.BasicDataSource;

public class Konekcija {
	/*
	 * Podaci potrebni za konekciju na MySql bazu podataka
	 */
	
	String korisnik; // Naziv korisnika za onekciju na BP
	String sifra; // Sifra korisnika za konekciju na BP
	String url; // url za jednu konekciju
	
	static String driver = "org.gjt.mm.mysql.Driver"; // Drajver za konekciju na BP
	static String driverOld = "com.mysql.jdbc.Driver"; // Drajver za konekciju - alternativni
	
	//static String url2 = "jdbc:mysql://localhost:3306/urls1"; // drugi URL
	//static String url3 = "jdbc:mysql://localhost:3306/jdbcsotacnew"; // treci URL
	
	// Podaci potrebni za napredni oblik konekcija na BP
	protected int dbConnectionsMinCount = 4; // minimalan broj konekcija na BP
	protected int dbConnectionsMaxCount = 10; // maksimalan broj konekcija na BP
	protected int dbConnectionMaxWait = -1; // Maksimalno vrijeme cekanja za konekciju
	protected BasicDataSource dataSource; // Osobina data source � potrebna za
	// naprednu konekciju na BP
	
	// Osobine potrebne za rad sa bazom podataka
	static Connection konekcija = null; // osobina konekcija za BP
	private Connection connection; // druga konekcija za BP
	static Statement iskaz = null; // osobina naredba za rad sa BP
	static PreparedStatement pripremljeniIskaz = null;
	static ResultSet rezultat = null; // Osobina skup redova rezultata
	static DatabaseMetaData metaPodaci = null; // Osobina meta podataka
	
	public Konekcija(String url, String korisnik, String sifra){
		this.url = url;
		this.korisnik = korisnik;
		this.sifra = sifra;
	}
	
	public synchronized void open(){
		// Using commons-dbcp's BasicDataSource
		try {
		dataSource = new BasicDataSource(); // instanciranje klase BasicDataSource
		dataSource.setDriverClassName(driver); // setovanje naziva driver-a
		dataSource.setUrl(url); // setovanje URL-a
		dataSource.setUsername(korisnik); // setovanje naziva korisnika
		dataSource.setPassword(sifra); // setovanje sifre
		// setovanje minimalnog, maksimalnog broja konekcija kao i vremena �ekanja
		// za uspostavu konekcije
		dataSource.setMaxIdle(dbConnectionsMinCount);
		dataSource.setMaxActive(dbConnectionsMaxCount);
		dataSource.setMaxWait(dbConnectionMaxWait);
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		connection = null;
		try {
		connection = dataSource.getConnection();
		}
		catch (SQLException e) {
		System.out.println("Greska - konekcija");
		}
		return connection;
	}
		
	public void closeConnection() {
		try {
		dataSource.close();
		}
		catch (SQLException e) {
		System.out.println("Greska - konekcija");
		}
	}
	
	public Statement getStatement() {
		try {
		konekcija = this.getConnection();
		// za datu konekciju kreira i vra�a objekat klase Statement
		iskaz = konekcija.createStatement();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return iskaz;
		}
	
	public PreparedStatement prepareStatement(String sql) {
		try {
			konekcija = this.getConnection();
			pripremljeniIskaz = konekcija.prepareStatement(sql);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		return pripremljeniIskaz;
		}

}
