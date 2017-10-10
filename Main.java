import java.io.*;
import java.util.ArrayList;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

  public static void main(String[] args) {
  	File aFile = new File("./README.md");

   	Validator aCheck = new Validator();

   	String regex = "((http|https):/{2})+(([0-9a-z+&@#/%?=~\\-_|!.,;]*[0-9a-z+&@#/%?=~\\-_|!.,;])(.com|.org|.at))?((\\/([~0-9a-zA-Z+&@/%~\\-_|!,;]+))?([0-9a-zA-Z+&@/%~\\-_|!,;]+)?)?";
   	Pattern patt = Pattern.compile(regex);

    try(BufferedReader br = new BufferedReader(new FileReader(aFile))) {
      for(String line; (line = br.readLine()) != null; ) {

      	try {
	          Matcher matcher = patt.matcher(line);
	          if (matcher.find())
						{
						 	aCheck.validateString(matcher.group());
						}
	      } catch (Exception e) {
	      }
      }
    }catch(Exception e){
    }

    System.out.println(aCheck.getList());
  }
}
