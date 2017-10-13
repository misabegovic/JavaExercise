import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
//import org.apache.commons.codec.binary.Base64;

public class Fetch {
	protected ArrayList<String> listOfBase64Encoded;
	
	public Fetch(){
		this.listOfBase64Encoded = new ArrayList<String>();
	}

	public ArrayList<String> getBase64List(){
		return this.listOfBase64Encoded;
	}

	public void fetchData(String link) throws Exception{
		URL oracle = new URL(link);
	    URLConnection yc = oracle.openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	    StringBuilder aBuilder = new StringBuilder();
		
	    String inputLine;
	    while ((inputLine = in.readLine()) != null) {
	       aBuilder.append(inputLine);
	    }
	    in.close();
	    
	    MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(aBuilder.toString().getBytes());

        byte[] byteData = md.digest();
        String encoded = Base64.getEncoder().encodeToString(byteData);
	    System.out.println(encoded);
	    
	}
}
