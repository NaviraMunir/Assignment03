import java.util.Stack;

//-----Code from https://www.softwaretestinghelp.com/binary-search-tree-in-java/ -----
class BST_Tree{ 
    //node class that defines BST node
    class Node { 
        String key; 
        int freq;
        Node left, right; 
   
        public Node(String data){
            key = data; 
            freq=0;
            left = right = null; 
        } 
    } 
    // BST root node 
    Node root; 
  
   // Constructor for BST =>initial empty tree
    BST_Tree(){ 
        root = null; 
    }
    // insert a node in BST 
    void insert(String key)  { 
        root = insert_Recursive(root, key); 
    } 
   
    //recursive insert function
    Node insert_Recursive(Node root, String key) { 
          //tree is empty
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        //traverse the tree
        if (key.compareTo(root.key)<0)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key); 
        else if (key.compareTo(root.key)>0)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key); 
          // return pointer
        return root; 
    }
    void inorder() { 
        inorder_Recursive(root); 
    } 
    
    //from https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
    void traverse(InputFilesVectors[] vectors,int n) { 
    	// create an empty stack
        Stack<Node> stack = new Stack<>();
        for(int i=0;i<n;i++)
        {
        	System.out.println("-----------------------------------");
        	System.out.println("File: "+vectors[i].name);
        	System.out.println("-----------------------------------");
        	System.out.println("word"+"\t\t"+"frequency");
	        Node curr = root;
	        while (!stack.empty() || curr != null)
	        {
	        	if (curr != null)
	            {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            else {
	                curr = stack.pop();
	                
	                Word w=new Word(curr.key);
	               
	               
	               // {
	                	
	                	w.findfreq(vectors[i],curr.key);
	                	if(w.freq>0)
	                	{
		                	
		                	System.out.println(w.word+"\t\t"+w.freq);
	                	}
	                		                //}
	         
	                curr = curr.right;
	            	}
	            }
	        System.out.println("-----------------------------------");
        }
    } 
   
    // recursively traverse the BST  
    void inorder_Recursive(Node root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.println( root.key+"  " ); 
            inorder_Recursive(root.right); 
        } 
    }
    
    
}