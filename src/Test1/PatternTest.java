package Test1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PatternTest {

    public PatternTest() {
	// TODO Auto-generated constructor stub
    }
    public static void main(String[] args) {
	Pattern p=Pattern.compile("a.*b");
	Matcher m=p.matcher("esa1111ba2222ba3ba4b");
	System.out.println(m.matches());
//	System.out.println(p.matcher("a1111ba2222ba3ba4b").matches());
m.find();
System.out.println(m.group());
m.find();
System.out.println(m.group());	
	
    }

}
