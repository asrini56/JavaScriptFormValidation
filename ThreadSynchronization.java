class Print{
    public void pc(){
        try{
            for(int i = 5;i>0;i--){
                System.out.println(i);
            }
            }catch(Exception e){
                System.out.println("Thread Exception");
            }
    }
}

class ThreadExample extends Thread{
   private Thread t;
   private String threadName;
   Print  PD;

   ThreadExample( String name,  Print pd) {
      threadName = name;
      PD = pd;
   }
   
   public void run() {
      synchronized(PD) {
         PD.pc();
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }

   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
public class Main
{
	public static void main(String[] args) {
		Print p = new Print();
		ThreadExample t1 = new ThreadExample("THREAD1",p);
		ThreadExample t2 = new ThreadExample("THREAD2",p);
		t1.start();
		t2.start();
		try{
		    t1.join();
		    t2.join();
		}catch ( Exception e) {
         System.out.println("Interrupted");
      }
	}
}
