package practice;


//}


//Java program to illustrate 
//Instance Initialization Block 
class InstanceInitializationBlocks
{ 
	// Instance Initialization Block 
	{ 
		System.out.println("IIB block"); 
	} 
	
	// Constructor of GfG class 
	InstanceInitializationBlocks() 
	{ 
		System.out.println("Constructor Called"); 
	} 
	
	{ 
		System.out.println("IIB block 2"); 
	}
	public static void main(String[] args) 
	{ 
		InstanceInitializationBlocks a = new InstanceInitializationBlocks(); 
	} 
} 
