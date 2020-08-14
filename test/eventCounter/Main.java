package eventCounter;
import java.util.*;
import java.util.concurrent.*;

class EventCounter {
	ArrayList<Integer> perSecCounter;
	Runnable runnable;
	
	EventCounter (Runnable runnable, int secs) {
		this.runnable = runnable;
		perSecCounter = new ArrayList<>(secs);
	}
    
    List<Integer> getCallsInLastNSeconds(int n) {
    	runnable.run();
    	
    }
    List<Integer> getCallsInLastNSeconds(Callable callable, int n) {
    	
    }
}

class MyClass {
    void myPrinter () {
        System.out.println("myPrinter() called!");
    }
}
public class Main
{
	public static void main(String[] args) {
		MyClass o = new MyClass();
		
	    EventCounter ec = new EventCounter();
	    
	    for (int i=0; i<5; i++) {
	        for (int j=0; j<60; j++) {
	            myMethod();
	            Thread.sleep(1000);
	        }
	        
	    }
	    
	}
}
