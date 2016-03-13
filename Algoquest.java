
/**
 * The algorithem for Finds the largest Bound in an a given Main Bound .
 * 
 * @author (Omer Golan) 
 * @version (04.01.16)
 */
public class Algoquest
{
    
    
    /**
     * Constructor for objects of class Algoquest
     */
    
    
   
    public Algoquest()
    {
    }
    
    /**
     * the function who finds the max  Bound in The Main Bound
     * 
     *
    
  
    
    
    /** check to see if a givven area is clear of shaps **********************************/
    public boolean ereaIsClear(double l,double r,double t,double b, Bound [] arrayOfShaps)
    /*************************************************************************************/
    {
        int length=arrayOfShaps.length;
        int i;
        for(i=0;i<length;i++)
        {
            double t2=arrayOfShaps[i].getTop();
            double b2=arrayOfShaps[i].getBottom();
            double r2=arrayOfShaps[i].getRight();
            double l2=arrayOfShaps[i].getLeft();
            // case 1
            if( ( (t2<=t)&&(t2>b)&&(r2<=r)&&(r2>l) )|| ( (t2<=t)&&(t2>b)&&(l2>=l)&&(l2<r) ) ){
                return false;
            }
            if( ( (b2>=b)&&(b2<t)&&(r2<=r)&&(r2>l) )|| ( (b2>=b)&&(b2<t)&&(l2>=l)&&(l2<r) ) ){
               return false;
            }
            // case 2
            if( ( (t2<=t)&&(t2>b)&&(r2>r)&&(l2<r) )|| ( (t2<=t)&&(t2>b)&&(l2<l)&&(r2>l) ) ){
                return false;
            }                                                    
            if( ( (b2>=b)&&(b2<t)&&(r2>r)&&(l2<r) )|| ( (b2>=b)&&(b2<t)&&(l2<l)&&(r2>l) ) ){
               return false;
            }
            // case 3
             if( ( (t2>=t)&&(b2<t)&&(r2<=r)&&(r2>l) )|| ( (t2>=t)&&(b2<t)&&(l2>=l)&&(l2<r) ) ){    
                return false;
            }
         //   ( (b2<b)&&(t2>b)&&(l2>=l)&&(l2<r) ) ){
                
            if( ( (t2<=t)&&(t2>b)&&(r2<=r)&&(r2>l) )|| ( (t2<=t)&&(t2>b)&&(l2>=l)&&(l2<r) ) ){
               return false;
            }
            if ( (t2>=t)&&(b2<=b)&&(r2>=r)&&(l2<=l) ){
                return false;
            }
            
        }
        return true;
    }
     /** check to see if the Bound is full of shaps *******************************/
      public boolean ereaIsBlock(double l,double r,double t,double b, Bound [] arrayOfShaps)
    /******************************************************************************/
   {
    if( coordinatesInShap(l,r,t,b,arrayOfShaps) )  //  <=====================
    {
        return true;
    }
    if (ereaIsClear(l,r,t,b,arrayOfShaps ) ) 
    {
        return false;
    }
    return ( ereaIsBlock(l,((r-l)/2)+l,t,((t-b)/2)+b,arrayOfShaps) )&& ( ereaIsBlock(((r-l)/2)+l,r,t,((t-b)/2)+b,arrayOfShaps)) && ( ereaIsBlock(l,((r-l)/2)+l,((t-b)/2)+b,b,arrayOfShaps) )&& ( ereaIsBlock(((r-l)/2)+l,r,((t-b)/2)+b,b,arrayOfShaps) );
    
    }
    
   /******************checking if a given cordinates in a shap Bound**************/
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
            if( (t<=top)&&(b>=botttom)&&(l>=left)&&(r<=right) )
            {
                return true;
            }
        }
        return false;
        
    }
    /** check to see if the Bound is full of shaps *******************************/
   // public boolean ereaIsBlock(int l,int r,int t,int b, Bound [] arrayOfShaps)
    /*****************************************************************************
    {
    
        int min=findTheMininumCut(l,r,t,b,arrayOfShaps);
         if (min==-1)
        {
            return false;
        }
        int NewTop=t-min;;
        boolean LIB=lineIsBloked(l,r,t,b,NewTop,arrayOfShaps);
       
        if( (NewTop<=b)& ( LIB ) )
        {
            return true;
        }                                                                                    
      
        if( LIB  )
        {
            return  ereaIsBlock(l,r,NewTop,b,arrayOfShaps);        
        }
        else{
            return false;
        }
    }
     /*************checking if a line of a given hight and bottom in full of shapes*********/
    // public boolean lineIsBloked(double l,double r,double t,double b,double newTop, Bound [] arrayOfShaps)
      /***********************************************************************************
     {
        double i;
        double j;
        double k;
        double m;
        double n;
        for ( i=0;i<arrayOfShaps.length;i++)
        {
            j=arrayOfShaps[i].getTop();
            k=arrayOfShaps[i].getBottom();
            m=arrayOfShaps[i].getLeft();
            n=arrayOfShaps[i].getRight();
            if( (j>=t)&&(k<=newTop)&&(m<=l)&&(n<r) )
            {
               return lineIsBloked(n,r,t,b,newTop,arrayOfShaps);
            } 
             if( (j>=t)&&(k<=newTop)&&(m<=l)&&(n>=r) )
            {
              return true;
            } 
              
        }            
        return false;                                 
     }
    /************* finding the minimum hight to low the Top erae of the main Bound ********/
    //public int findTheMininumCut(int l,int r,int t,int b, Bound [] arrayOfShaps)
    /*************************************************************************************
    {
        int i;
        int top;
        int bottom;
        int left;
        int right;
        int min=0;
        for(i=0;i<arrayOfShaps.length;i++){
           top=arrayOfShaps[i].getTop(); 
           bottom=arrayOfShaps[i].getBottom(); 
           left=arrayOfShaps[i].getLeft(); 
           right=arrayOfShaps[i].getRight(); 
           if( (top>=t)&&(bottom<t)&&(left<r)&&(right>l) ){
               min=t-bottom;
               break;
            }
        }
        for(i=i ;i<arrayOfShaps.length;i++){
           top=arrayOfShaps[i].getTop(); 
           bottom=arrayOfShaps[i].getBottom(); 
           left=arrayOfShaps[i].getLeft(); 
           right=arrayOfShaps[i].getRight(); 
           if( (top>=t)&&(bottom<t)&&(left<r)&&(right>l) ){
               if(min>t-bottom){
                   min=t-bottom;
                }
            }
        }
        if(min==0){
            return -1;
        }
        else{
           return min;                                                       
        }     
    }
    /************ The Main algorithem   ************************************************/
    public BoundList findMax(double l,double r,double t,double b, Bound []arrayOfShaps)
   /*******************************************************************************/
    {
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
    /***** unit the bounds in 4 diffrents lists of Bounds to one list of bound *************/ 
     public BoundList unitTheGroup(BoundList b1,BoundList b2,BoundList b3,BoundList b4)
    /*************************************************************************************/
     {
         BoundList p1=b1;
         BoundList p2=b2;
         BoundList f1;
         BoundList f2;
         BoundList f3;
         BoundList f4;
         
         if ((b1!=null)&&(b2!=null)&&(b3!=null)&&(b4!=null) ){
          f1=b1.combin(b2);  //combin b1 and b2 to new list- f1
          f2=b2.combin(b1); 
          
          f1=f1.unit(f2);
          
          f1=f1.combin(b3);  //combin f1 and b3 to new list- f1
          f2=b3.combin(f1);
          
          f1=f1.unit(f2);
          
          f1=f1.combin(b4);  //combin f1 and b4 to new list- f1  
          f2=b4.combin(f1);
          
          f1=f1.unit(f2);
          
          return f1;
        }
         // 1 list are null   
        if ((b1!=null)&&(b2!=null)&&(b3!=null)&&(b4==null) ){
           f1=b1.combin(b2);  //combin b1 and b2 to new list- f1
           f2=b2.combin(f1);
           
        //   f1=f1.combin(f2);
        //   f2=f2.combin(f1);
           f2=f2.unit(f1);  
           
           f3=f2.combin(b3);  //combin f1 and b3 to new list- f1
           f4=b3.combin(f3);
          
        //   f4=f4.combin(f3);           
         //  f4=f3.combin(f4);
           f4=f4.unit(f3);           
           return f4;
        }
           
        if ((b1!=null)&&(b2!=null)&&(b3==null)&&(b4!=null) ){
             f1=b1.combin(b2);  //combin b1 and b2 to new list- f1
             f2=b2.combin(b1);
             
             f2=f2.unit(f1);
             
             f2=f2.combin(b4);  //combin f2 and b4 to new list- f1
             f3=b4.combin(f2);
             
             f4=f3.unit(f2);
             
             return f4;
        }
        
        if ((b1!=null)&&(b2==null)&&(b3!=null)&&(b4!=null) ){
             f1=b1.combin(b3);  //combin b1 and b3 to new list- f1
             f2=b3.combin(b1);
             
             f2=f1.unit(f2);
             
             f3=f2.combin(b4);  //combin f2 and b4 to new list- f1
             f4=b4.combin(f3);
             
             f4=f4.unit(f3);
               
             return f4;
             
            }
        if ((b1==null)&&(b2!=null)&&(b3!=null)&&(b4!=null) ){
             f1=b2.combin(b3);  //combin b2 and b3 to new list- f1            
             f2=b3.combin(f1);
            
             f1=f1.unit(f2);
            
            
             
             f3=f1.combin(b4);  //combin f1 and b4 to new list- f1
             f4=b4.combin(f3);
             
             f4=f3.unit(f4);       
             return f4;
            }
            /// 2 lists are null
        if ((b1==null)&&(b2==null)&&(b3!=null)&&(b4!=null) ){
             f1=b3.combin(b4);  //combin b3 and b4 to new list- f1              
             f2=b4.combin(f1);
             
             f2=f2.unit(f1);
             return f2;
            }
          if ((b1!=null)&&(b2==null)&&(b3==null)&&(b4!=null) ){
            f1=b1.combin(b4);  //combin b1 and b4 to new list- f1 
            f2=b4.combin(f1);
             return f2;
            }   
          if ((b1!=null)&&(b2!=null)&&(b3==null)&&(b4==null) ){
             f1=b1.combin(b2);  //combin b1 and b2 to new list- f1     
             f2=b2.combin(f1);
             f2=f2.unit(f1);
             return f2;
            }
          if ((b1!=null)&&(b2==null)&&(b3!=null)&&(b4==null) ){
             f1=b1.combin(b3);  //combin b1 and b3 to new list- f1  
             f2=b3.combin(f1);
             f2=f2.unit(f1);
             return f2;
            }
            
            if ((b1==null)&&(b2!=null)&&(b3!=null)&&(b4==null) ){
             f1=b2.combin(b3);  //combin b2 and b3 to new list- f1   
             f2=b3.combin(f1);
             f2=f2.unit(f1);
             return f2;
            }
            if ((b1==null)&&(b2!=null)&&(b3==null)&&(b4!=null) ){
             f1=b2.combin(b4);  //combin b2 and b4 to new list- f1     
             f2=b4.combin(f1);
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
        double max=0.0;
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

