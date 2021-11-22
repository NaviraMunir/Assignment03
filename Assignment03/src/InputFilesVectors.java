import java.util.Vector;

class InputFilesVectors{
	Vector<String> vector=new Vector<String>(100);
	String name=new String();
	InputFilesVectors()
	{
		
		
	}
	void DisplayVector()
	{
		System.out.println("Displaying Vector for "+name);
		for(int i=0;i<vector.size();i++)
		{
			System.out.println(vector.get(i));
		}
		System.out.println();
	}
	void insert(String word)
	{
		vector.add(word);
	}
	
}