class Word{
	String word;
	int freq;
	Word(String s)
	{
		word=s;
		freq=0;
	}
	void findfreq(InputFilesVectors v,String s)
    {
		int count=0;
    	for(int i=0;i<v.vector.size();i++)
    	{
    		//System.out.println("vector: "+v.vector.get(i));
    		
    		if(v.vector.get(i).equalsIgnoreCase(s))
    		count++;
    	}
    	if(freq>0)
    	{
        	
        	System.out.println(word+"\t\t"+freq);
    	}
    	freq=count;
    	
    }
}