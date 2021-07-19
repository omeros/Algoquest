package Algoquest;


public class BoundList
{
   BoundNode _head;
    /*************** Constractor  **************************************/
    public BoundList()
    /*******************************************************************/
    {
       _head=null;
    }
    /********************************************************************/
    public BoundList(BoundNode b)
    /*********************************************************************/
    {
      /**  if(b==null)
        {
            return;
        }*/
        _head=b;
    }
    /****************** return the head **********************************/
    public BoundNode getHead()
    /**********************************************************************/
    {
        return _head;
    }
     /***************** combine two lists to one list  ***********************/
     public BoundList combine(BoundList b)
     /**********************************************************************/ 
     {
        if(b!=null)
       {
         BoundNode p1=b.getHead(); 
         while(p1.getNext()!=null)
         {
            this.addToList(p1); // adding the first Node in the List b to this list
            p1=p1.getNext();
         }
         this.addToList(p1);
         return this;
       }
        return null;
      }
     
     /***************** add each node to another in the same list  ***********************/
     public void refresh()
     /*******************************************************************************/ 
     {
    	   BoundNode p1=this.getHead();
    	   BoundNode p2=this.getHead();
    	   p2.getNext();
    	    while( (p1.getNext()!=null))
            {
    	    	
    	//    	addToList(p1);
	           while(p2!=null)
	           {
	        	   if (p1!=p2)
	        	   {
	        		   p1.addNode(p2); 
	        	   }
	        	   p2=p2.getNext();
	           }
	           p2=this.getHead();
	           p1=p1.getNext();
            }
    	//	addToList(p1);
    	 
     }
    
   /************ adding  p1  Node to the list ********************************************/    
         public void addToList(BoundNode p1)    
   /**************************************************************************************/        
     {
         BoundNode p2=this.getHead();
         while(p2.getNext()!=null)
         {
        	
	             p2.addNode(p1);
	             p2=p2.getNext();
        	 
         }
         p2.addNode(p1);
         if(p1.getAd()==0)
         {
            BoundNode a=new BoundNode(p1);
             p2.setNext(a);
           //  p1.setAd(1);
         }
         
     }
   /************ connect this list( last bound) with other list( head bound) ********************************************/    
         public BoundList unit (BoundList other)    
   /*******************************************************************************************************************/
    { 
         BoundNode p1=this.getHead();
         while(p1.getNext()!=null)
         {            
             p1=p1.getNext();
         }
         BoundNode p2=other.getHead();
         //p2.setNext(p1);
          p1.setNext(p2);
         
         return this;    

    }
    /**************set to zero all the add symbols in the BoundNodes **********************************************************************/
    public void setAddToZero()
    /************************************************************************************************************************************/
    {
        BoundNode p1=this.getHead();
         while(p1!=null)
         {      
             p1.setAd(0);
             p1=p1.getNext();
         }
        
    }
    /**************************************************************************************/
}
