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
	protected ArrayList<String> listOfChecksumString;
	protected int numOfLinks = 0;
	
	public Fetch(){
		this.listOfBase64Encoded = new ArrayList<String>();
		this.listOfChecksumString = new ArrayList<String>();
	}
	
	public int getNumOfLinks(){
		return this.numOfLinks;
	}
	
	public ArrayList<String> getBase64List(){
		return this.listOfBase64Encoded;
	}
	
	public ArrayList<String> getChecksumList(){
		return this.listOfChecksumString;
	}

	public void fetchData(String link) throws Exception{
		URL oracle = new URL(link);
	    URLConnection yc = oracle.openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	    StringBuilder aBuilder = new StringBuilder();
	
	
	    //String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(in);
	
	    String inputLine;
	    while ((inputLine = in.readLine()) != null) {
	       aBuilder.append(inputLine);
	     }
	     in.close();
	    //System.out.println(getMD5Checksum(aBuilder.toString()));
	    //baseEncoder(aBuilder.toString());
	    //checksumEncoderFromBase(aBuilder.toString());
	    //File aFile = new File("Link"+(this.numOfLinks+1));
	    BufferedWriter bw = null;
		FileWriter fw = null; 
		
		try {
			this.numOfLinks++;
			fw = new FileWriter("Link"+this.numOfLinks);
			
			PrintWriter writer = new PrintWriter("Link"+this.numOfLinks);
			writer.print("");
			writer.close();
			
			bw = new BufferedWriter(fw);
			bw.write(aBuilder.toString());
			
			bw.close();
			fw.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

   public byte[] createChecksum(String filename) throws Exception {
     InputStream fis =  new FileInputStream(filename);

     byte[] buffer = new byte[1024];
     MessageDigest complete = MessageDigest.getInstance("MD5");
     int numRead;

     do {
         numRead = fis.read(buffer);
         if (numRead > 0) {
             complete.update(buffer, 0, numRead);
         }
     } while (numRead != -1);

     fis.close();
     //return Base64.getEncoder().encode(complete.digest());
     return complete.digest();
   }

   public String getMD5Checksum(String filename) throws Exception {
       byte[] b = createChecksum(filename);
       //String result = "";

       //for (int i=0; i < b.length; i++) {
         // result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
       //}
       
       byte[] authBytes = b.toString().getBytes(StandardCharsets.UTF_8);
       String encoded = Base64.getEncoder().encodeToString(authBytes);
       
       //byte[] encodedBuilder = Base64.getEncoder().encode(b);
       //return encodedBuilder.toString();
       return encoded;
   }
}
