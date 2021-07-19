package Algoquest;

import java.awt.Rectangle;

/**
 * The algorithem for Finds the largest Bound in an a given Main Bound .
 * 
 * @author (Omer Golan) 
 * @version (12.07.21)    //first (04.01.16)
 */
public class Algoquest
{
	int count;
	int counEreaIsBlock;
	int counEreaIsClear;

    
     /* Constructor for objects of class Algoquest */
     
    public Algoquest(){
         count = 0;
         counEreaIsBlock = 0;
         counEreaIsClear = 0;
    }
    
    /******** checking if a given area is clear of shapes   **********************************/
    public boolean ereaIsClear(double l,double r,double t,double b, Bound [] arrayOfShaps)
    /***************************************************************************************/
    {
    	 System.out.println(" ereaIsClear function : "+counEreaIsClear);  
    	 counEreaIsClear++;
        int length=arrayOfShaps.length;
        int i;
        for(i=0;i<length;i++){
        	
            double t2=arrayOfShaps[i].getTop();
            double b2=arrayOfShaps[i].getBottom();
            double r2=arrayOfShaps[i].getRight();
            double l2=arrayOfShaps[i].getLeft();                       
            
            // check if the size of the rectangle is smaller than pixel 1          
            if(((t-b)<=1)&&((r-l)<=1)) {
            	return true;
            }
            
            //               top left                                 top right
            if( ( ( (b<t2)&&(t2<=t)&&(l<=l2)&&(l2<r) )|| (b<t2)&&(t2<=t)&&(l<r2)&&(r2<=r) ) ){      
                return false;
            }
             //            bottom left                                bottom right
            if(  ( (b<=b2)&&(b2<t)&&(l<=l2)&&(l2<r) )|| ( (b<=b2)&&(b2<t)&&(l<r2)&&(r2<=r) ) ){     
               return false;
            }
            // top and bottom of other is in this bound
            if( ( (b<t2)&&(t2<=t)&&(l2<=l)&&(r<=r2) )||( (b<=b2)&&(b2<t)&&(l2<=l)&&(r<=r2) )){
            	return false;
            }
           //  right and left of other is in this bound
            if( ( (b2<=b)&&(t<=t2)&&(l<=l2)&&(l2<r) ) || ( (b2<=b)&&(t<=t2)&&(l<r2)&&(r2<=r) ) ){
            	return false;
            }
           // the array of Bounds is cover the  coordinates
            if(  (b2<=b)&&(t<=t2)&&(l2<=l)&&(r<=r2)  ){
            	return false;
            }
            // the array of Bounds is inside of the  coordinates
            if(  (b<=b2)&&(t2<=t)&&(l<=l2)&&(r2<=r)  ){
            	return false;
            }
            
        }
        return true;
    }
     /** check to see if the Bound is full of shapes *******************************/
      public boolean ereaIsBlock(double l,double r,double t,double b, Bound [] arrayOfShaps)
    /******************************************************************************/
   {
          System.out.println(" ereaIsBlock function : "+counEreaIsBlock);  
          counEreaIsBlock++;
          
     if(((t-b)<=1)&&((r-l)<=1)) {
          	return true;
     }

    if( coordinatesInShap(l,r,t,b,arrayOfShaps) )  
    {
        return true;
    }
    if (ereaIsClear(l,r,t,b,arrayOfShaps ) ) 
    {
        return false;
    }
    
//    if (!ereaIsClear(l,r,t,b,arrayOfShaps ) ) 
//    {
//        return true;
//    }
    
    return ( ereaIsBlock(l,((r-l)/2)+l,t,((t-b)/2)+b,arrayOfShaps) )&& ( ereaIsBlock(((r-l)/2)+l,r,t,((t-b)/2)+b,arrayOfShaps)) && ( ereaIsBlock(l,((r-l)/2)+l,((t-b)/2)+b,b,arrayOfShaps) )&& ( ereaIsBlock(((r-l)/2)+l,r,((t-b)/2)+b,b,arrayOfShaps) );
    
    }
    
   /****************** checking if a given coordinates is in a shape Bound **************/
    public boolean coordinatesInShap(double l,double r,double t,double b, Bound [] arrayOfShaps)
    /*****************************************************************************/
    { 
        int i;
        double top;
        double botttom;
        double left;
        double right;
        for ( i=0;i<arrayOfShaps.length;i++)
        {
            top=arrayOfShaps[i].getTop();
            botttom=arrayOfShaps[i].getBottom();
            left=arrayOfShaps[i].getLeft();
            right=arrayOfShaps[i].getRight();
            if( ((botttom<=b)&&(t<=top)&&(left<=l)&&(r<=right) ))
            {
                return true;
            }
        }
        return false;
        
    }

    /************ The Main algorithm   ************************************************/
    public BoundList findMax(double l,double r,double t,double b, Bound []arrayOfShaps)
   /*******************************************************************************/
    {
        System.out.println(" Main function : "+count);    
        count++;

        if (ereaIsClear(l,r,t,b,arrayOfShaps ) ) 
        {
            Bound newB =new Bound(l,r,t,b);
            BoundNode bn=new BoundNode(newB,null);
            BoundList bl =new BoundList(bn);        
            return bl;
        }
        if(ereaIsBlock(l,r,t,b,arrayOfShaps) )
        {
            return null;
        }
        
          BoundList b1;
          BoundList b2;
          BoundList b3;
          BoundList b4;
          
         b1=findMax(l,((r-l)/2)+l,t,((t-b)/2)+b,arrayOfShaps);    // left top
         b2=findMax(((r-l)/2)+l,r,t,((t-b)/2)+b,arrayOfShaps);    // right top
         b3=findMax(l,((r-l)/2)+l,((t-b)/2)+b,b,arrayOfShaps);    // left bottom
         b4=findMax(((r-l)/2)+l,r,((t-b)/2)+b,b,arrayOfShaps);    // right bottom
         
         BoundList b5=unitTheGroup(b1,b2,b3,b4);
         b1=null;
         b2=null;
         b3=null;
         b4=null;
         return b5;
        
           
    }
    /***** unit the bounds in 4 difference lists of Bounds to one list of bound *************/ 
     public BoundList unitTheGroup(BoundList b1,BoundList b2,BoundList b3,BoundList b4)
    /*************************************************************************************/
     {
         BoundList f1;
         BoundList f2;
         BoundList f3;
         BoundList f4;
         
         if ((b1!=null)&&(b2!=null)&&(b3!=null)&&(b4!=null) ){ 
          f1=b1.combine(b2);  //combine b1 and b2 to new list- f1
          f2=b2.combine(b1); 
         // f1.refresh();
         // f2.refresh();
          
          f1=f1.unit(f2);
          
          f1=f1.combine(b3);  //combine f1 and b3 to new list- f1
          f2=b3.combine(f1);
         // f1.refresh();
        //  f2.refresh();
          
          f1=f1.unit(f2);
          
          f1=f1.combine(b4);  //combine f1 and b4 to new list- f1  
          f2=b4.combine(f1);
         // f1.refresh();
         // f2.refresh();
          
          f1=f1.unit(f2);
          
          return f1;
        }
         // 1 list are null   
        if ((b1!=null)&&(b2!=null)&&(b3!=null)&&(b4==null) ){
           f1=b1.combine(b2);  //combine b1 and b2 to new list- f1
           f2=b2.combine(f1);
           
        //   f1=f1.combine(f2);
        //   f2=f2.combine(f1);
           f2=f2.unit(f1);  
           
           f3=f2.combine(b3);  //combine f1 and b3 to new list- f1
           f4=b3.combine(f3);
          
        //   f4=f4.combine(f3);           
         //  f4=f3.combine(f4);
           f4=f4.unit(f3);           
           return f4;
        }
           
        if ((b1!=null)&&(b2!=null)&&(b3==null)&&(b4!=null) ){
             f1=b1.combine(b2);  //combine b1 and b2 to new list- f1
             f2=b2.combine(b1);
             
             f2=f2.unit(f1);
             
             f2=f2.combine(b4);  //combine f2 and b4 to new list- f1
             f3=b4.combine(f2);
             
             f4=f3.unit(f2);
             
             return f4;
        }
        
        if ((b1!=null)&&(b2==null)&&(b3!=null)&&(b4!=null) ){
             f1=b1.combine(b3);  //combine b1 and b3 to new list- f1
             f2=b3.combine(b1);
             
             f2=f1.unit(f2);
             
             f3=f2.combine(b4);  //combine f2 and b4 to new list- f1
             f4=b4.combine(f3);
             
             f4=f4.unit(f3);
               
             return f4;
             
            }
        if ((b1==null)&&(b2!=null)&&(b3!=null)&&(b4!=null) ){
             f1=b2.combine(b3);  //combine b2 and b3 to new list- f1            
             f2=b3.combine(f1);
            
             f1=f1.unit(f2);
            
            
             
             f3=f1.combine(b4);  //combine f1 and b4 to new list- f1
             f4=b4.combine(f3);
             
             f4=f3.unit(f4);       
             return f4;
            }
            /// 2 lists are null
        if ((b1==null)&&(b2==null)&&(b3!=null)&&(b4!=null) ){
             f1=b3.combine(b4);  //combine b3 and b4 to new list- f1              
             f2=b4.combine(f1);
             
             f2=f2.unit(f1);
             return f2;
            }
          if ((b1!=null)&&(b2==null)&&(b3==null)&&(b4!=null) ){
            f1=b1.combine(b4);  //combine b1 and b4 to new list- f1 
            f2=b4.combine(f1);
             return f2;
            }   
          if ((b1!=null)&&(b2!=null)&&(b3==null)&&(b4==null) ){
             f1=b1.combine(b2);  //combine b1 and b2 to new list- f1     
             f2=b2.combine(f1);
             f2=f2.unit(f1);
             return f2;
            }
          if ((b1!=null)&&(b2==null)&&(b3!=null)&&(b4==null) ){
             f1=b1.combine(b3);  //combine b1 and b3 to new list- f1  
             f2=b3.combine(f1);
             f2=f2.unit(f1);
             return f2;
            }
            
            if ((b1==null)&&(b2!=null)&&(b3!=null)&&(b4==null) ){
             f1=b2.combine(b3);  //combine b2 and b3 to new list- f1   
             f2=b3.combine(f1);
             f2=f2.unit(f1);
             return f2;
            }
            if ((b1==null)&&(b2!=null)&&(b3==null)&&(b4!=null) ){
             f1=b2.combine(b4);  //combine b2 and b4 to new list- f1     
             f2=b4.combine(f1);
             f2=f2.unit(f1);
             return f2;
            }
            // one list is not null
            if ((b1!=null)&&(b2==null)&&(b3==null)&&(b4==null) ){                      
             return b1;
            }
             if ((b1==null)&&(b2!=null)&&(b3==null)&&(b4==null) ){                      
             return b2;
            }
             if ((b1==null)&&(b2==null)&&(b3!=null)&&(b4==null) ){                      
             return b3;
            }
             if ((b1==null)&&(b2==null)&&(b3==null)&&(b4!=null) ){                      
             return b4;
            }                                                                 
        return null;
     }    
    /** find the max Bound in an List of boundsNodes *********************/  
    public Bound findTheMaxBound( BoundList List)
    /*********************************************************************/
    {
       if( List !=null)
       {
        BoundNode p1=List.getHead();
        BoundNode maximal=p1;
        double max=0;
        double s;
        while(p1!=null)
        {
            s=p1.getSize();
            if(max<s)
            {
                max=s;
                maximal=p1;
            }
            p1=p1.getNext();                     
        }
        Bound m=maximal.getBound();
        return m;    
       }
       return null;
    }
     
}

