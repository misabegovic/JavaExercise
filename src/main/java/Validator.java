import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {
	protected String regex;
    protected ArrayList<String> validLinks;

    public Validator() {
      this.regex = "((http|https):/{2})*(([0-9a-z+&@#/%?=~\\-_|!.,;]*[0-9a-z+&@#/%?=~\\-_|!.,;])(.com|.org|.at))((\\/([~0-9a-zA-Z+&@/%~\\-_|!,;]+))?([0-9a-zA-Z+&@/%~\\-_|!,;]+)?)?";
      this.validLinks = new ArrayList<String>();
    }

    public void validateString(String element) {
      if (isMatch(element, this.regex)){
        this.validLinks.add(element);
      }
    }

    public ArrayList<String> getList(){
      return this.validLinks;
    }

    private boolean isMatch(String s, String pattern) {
      try {
        Pattern patt = Pattern.compile(pattern);
        Matcher matcher = patt.matcher(s);
        return matcher.matches();
      } catch (Exception e) {
        return false;
      }
    }
}
