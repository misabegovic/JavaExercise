import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;

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
