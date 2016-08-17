package Test1;

public class InnerClass {

    private String runNow()
    {
	
	return "Outer";
    }
    
    static class Inner extends InnerClass
    {
	public String runNow()
	{
	   // super.runNow();
	    return "Inner";
	}
	
    }
    public static void main(String[] args) {
	 InnerClass[] a=new Inner[]{new Inner(),new C()};
	    for(InnerClass aa:a)
	      System.out.print(aa.runNow()+" ");
    }
    
   

}
class C extends InnerClass.Inner{

	  public String runNow(){
	    return "Out";
	  }
}
