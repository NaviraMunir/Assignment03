import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
class InputFilthreads extends Thread{

	InputFilesVectors vector=new InputFilesVectors();
	 InputFilthreads(InputFilesVectors v,String nfile){
		 vector=v;
		 // for input files
		 vector.name=nfile;
		 
		 
	 }
	public void run()
    {
		String path="C:\\Users\\bbl\\eclipse-workspace\\Assignment03"
				+ "\\src\\\\";
		
		String p1=path+vector.name;
		File file = new File(p1);
        FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        char temparr[] = new char[(int) file.length()];
        try {
			fr.read(temparr,0,(int) file.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String[] tempstring = (new String(temparr)).split("[ \n]");
       
        for(int i=0 ; i<tempstring.length; i++)
        {
        	
        	tempstring[i] = tempstring[i].replaceAll("[\\n\\t]", "");
	        	vector.insert(tempstring[i]);
 
        }
      
    }
	
}