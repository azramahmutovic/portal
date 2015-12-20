package portal.mdl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.http.Part;

import portal.dao.KorisnikDAO;
import portal.konekcija.Konekcija;

public class PostModel {

	public void dodajPost(Integer korisnik_id, String kategorija, String tekst, String imgPath){
		 KorisnikDAO dao = new KorisnikDAO();
		 dao.dodajPost(korisnik_id, kategorija, tekst, imgPath);
	 }
	
	public String spasiSliku(Part filePart, Integer korisnik_id){
		
		String fileName = filePart.getSubmittedFileName();
	    
	    String rootPath = "D:" + File.separator + "workspace" + File.separator + "portal" + File.separator +"WebContent"+ File.separator;
		File uploads = new File(rootPath + File.separator + "img" + File.separator + "korisnik-" + korisnik_id );
        if (!uploads.exists())
            uploads.mkdirs();
        
	    File file = new File(uploads, fileName);

	    try (InputStream input = filePart.getInputStream()) {
	        Files.copy(input, file.toPath());
	        return file.getAbsolutePath();
	        
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
