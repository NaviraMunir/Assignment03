import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
class Vocabularythreads implements Runnable{
	
	 
	 BST_Tree vocabularyTree=new BST_Tree();
	 String filename=new String();
	 Vocabularythreads(BST_Tree voctree,String nfile){
		 vocabularyTree=voctree;
		 filename=nfile;
	 }
	public void run()
    {
		
				// file reading code
				// from https://stackoverflow.com/questions/24924937/read-text-string-into-2d-array
				File file = new File(filename);
		        FileReader fr = null;
				try {
					fr = new FileReader(file);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
		        char temparr[] = new char[(int) file.length()];
		        try {
					fr.read(temparr,0,(int) file.length());
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		        String[] tempstring = (new String(temparr)).split("[ \n,]");
		       
		        for(int i=0 ; i<tempstring.length; i++)
		        {
		        	
		        	tempstring[i] = tempstring[i].replaceAll("[\\n\\t ]", "");
		        		//System.out.println(tempstring[i]);
			        	vocabularyTree.insert(tempstring[i]);
		        	
		            
		        }
		       
		        try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		        //vocabularyTree.inorder();
    }
	
}