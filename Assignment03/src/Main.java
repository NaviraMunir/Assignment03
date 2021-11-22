import java.util.Scanner;

class Main{
	static void Findfreq(BST_Tree tree,InputFilesVectors[] vector,int n)
	{
		
		
		tree.traverse(vector, n);
		
    }
	static void Findinputfreq(InputFilesVectors[] v,int n,String s)
	{
		
		for(int i=0;i<n;i++)
        {
        	System.out.println("-----------------------------------");
        	System.out.println("File: "+v[i].name);
        	System.out.println("-----------------------------------");
        	System.out.println("word"+"\t\t"+"frequency");
        	Word w=new Word(s);
        	w.findfreq(v[i],s);
        
            	System.out.println(w.word+"\t\t"+w.freq);
        	
        	System.out.println("-----------------------------------");
        }
		
    }
	
	public static void main(String args[]) throws InterruptedException 
	{
		
		 int threadsno=args.length-3;
		 int files=threadsno+1;
		 System.out.println("-----------------------------------\n"
				 +"Total Files: "+files+"\nInput Files Number: "+threadsno
				 +"\nVocabulary File:\n\t\t"+args[2]+"\nInput Files Names: ");
		 for(int i=3;i<args.length;i++)
		 {
			 System.out.println("\t\t"+args[i]);
		 }
		 System.out.println("-----------------------------------\n");
		BST_Tree voctree=new BST_Tree();
		String path="C:\\Users\\bbl\\eclipse-workspace\\Assignment03"
				+ "\\src\\\\";
		
		String p1=path+args[2];// for vocabulary
		
		Thread vocabulary = new Thread(new Vocabularythreads(voctree,p1));
		   vocabulary.start();
		   vocabulary.setName(args[2]);
		   
		   
		   /// for input files
		  
		  InputFilesVectors[] vector=new InputFilesVectors[threadsno];
		   int k=3;
		   for(int i=0;i<threadsno;i++)
			  {
				  vector[i]=new InputFilesVectors();
				  
				  
			  }
		   Thread[] inputthread=new Thread[threadsno]; 
		  for(int i=0;i<threadsno;i++)
		  {
	
			  inputthread[i] = new Thread(new InputFilthreads(vector[i],args[k+i]));
			  inputthread[i].start();
			  inputthread[i].setName(args[k+i]);
			  
		  } 
		  
		 
		  
		  // all threads should be executed
		   try {
	            vocabulary.join(); 
	            for(int i=0;i<threadsno;i++)
		  		  {
		  			  inputthread[i].join();
		  			  
		  		  }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 
		while(true)
		{
			   // Displaying Menu
			   int choice=0;
			   System.out.println("\n----------------------MENU----------------------\n"
			   		+ "1) Displaying BST build from Vocabulary File.\r\n"
			   		+ "2) Displaying Vectors build from Input files.\r\n"
			   		+ "3) Viewing Match words and its frequency\r\n"
			   		+ "4) Searching a query\r\n"
			   		+ "5) Enter 5 for Exiting");
			   @SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			   System.out.println("Enter your Choice: ");
			   choice=sc.nextInt();
			   System.out.println("--------------------------------------------\n");
			   switch(choice)
			   {
				   case 1:
					  
					   System.out.println("Printing IN ORDER: ");
					   voctree.inorder();
					   break;
				   case 2:
					   for(int i=0;i<threadsno;i++)
						  {
							  vector[i].DisplayVector();
							  
						  }
					   break;
				   case 3:
					   Findfreq(voctree,vector,threadsno);
					   break;
				   case 4:
					   String str = null;
					   System.out.println("Enter Query? ");
					   str=sc.next();
					   Findinputfreq(vector,threadsno,str);
					   break;
				   case 5:
					   System.out.println("!! PROGRAM EXITING !!");
					   System.exit(0);
					   break;
			   }
		}
		   
		   
	} 
}