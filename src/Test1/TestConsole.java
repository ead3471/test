package Test1;

import java.io.Console;

public class TestConsole {

    public TestConsole() {
	// TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
	Console cons=System.console();
	System.out.println(cons);
	String readedString=cons.readLine();
	System.out.println("readed:"+readedString);

    }

}
