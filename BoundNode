
public class BoundNode
{
    // instance variables - replace the example below with your own
    private double _size;
    private Bound _bb;
    private BoundNode _next;
    private int _added;

    /**
     * Constructor for objects of class BoundNode
     */
    public BoundNode(Bound bb,BoundNode next)
    {
      _bb=bb;
      _next=next;
      _size=_bb.getSize();
      _added=0;
    }
     public BoundNode(BoundNode other)      
     {
         Bound o=other.getBound();
          _bb=new Bound(o);         
         _next=null;
         _size=other.getSize();
         _added=0;
     }
    
    public double getSize()
    {
        return _size;
    }
    public BoundNode getNext() 
    {
        return _next;
    }
    public void setNext(BoundNode other)
    {
        _next=other;
    }
    public void addSize(int add)
    {
        _size=_size+add;
    }
    public Bound getBound()
    {
        return _bb;
    }
    public void setAd (int x)
    {
        _added=x;
    }
    public int getAd()
    {
        return _added;
    }
    /******** combin "other" BoundNode to "this" BoundNod **********************/
    public void addNode(BoundNode other)
    /*****************************************************************************/
    {
        Bound p1=other.getBound();
        double l1=p1.getLeft();
        double r1=p1.getRight();
        double t1=p1.getTop();
        double b1=p1.getBottom();
        
        double l2=_bb.getLeft();
        double r2=_bb.getRight();
        double t2=_bb.getTop();
        double b2=_bb.getBottom();
       
              /** case 1 */        
        // p1 is above to _bb  and has the same right and left values
        if( (b1==t2) && (l1==l2) && (r1==r2) )
        {
            _bb.setTop(t1);
            
            _size=_bb.getSize();
            other.setAd(1);
            
        }                      
        // p1 is in the bottom of _bb        
        if( (t1==b2) && (l1==l2) && (r1==r2) )
        {
            _bb.setBottom(b1);
            _size=_bb.getSize();
            other.setAd(1);
        }
        // p1 from the right to _bb
        if( (t1==t2) && (b1==b2) && (r2==l1) ) 
        {
            _bb.setRight(r1);
            _size=_bb.getSize();
            other.setAd(1);
        }
        // p1 is at  the left of _bb
        if( (t1==t2) && (b1==b2) && (r1==l2)  )
        {
            _bb.setLeft(l1);
            _size=_bb.getSize();
            other.setAd(1);
        }
                /** case 2 */
                             
      //1.1   // p1 is in the bottom of _bb and the rigt  of other is bigger than the right of _bb is right
         if( (t1==b2) && (l1==l2) && (r1>r2) )
        {
            _bb.setBottom(b1);
            _size=_bb.getSize();
            other.setAd(0);
        }
       //1.2 // p1 is in the bottom of _bb and the left  of other is bigger than the left of _bb is right
         if( (t1==b2) && (l1<l2) && (r1==r2) )
        {
            _bb.setBottom(b1);
            _size=_bb.getSize();
            other.setAd(0);
        }
       //1.3 // p1 is in the bottom of _bb and the left and right of other is bigger than the left and right of _bb is right
         if( (t1==b2) && (l1<l2) && (r1>r2) )
        {
            _bb.setBottom(b1);
            _size=_bb.getSize();
            other.setAd(0);
        }
        //2.1 // p1 from the right to _bb and the top of p1 is higher than the top of _bb 
        if( (t1>t2) && (b1==b2) && (l1==r2) ) 
        {
            _bb.setRight(r1);
            _size=_bb.getSize();
            other.setAd(0);
        }
         //2.2 // p1 from the right to _bb and the bottom of p1 is lower than the bottom of _bb 
        if( (t1==t2) && (b1<b2) && (l1==r2) ) 
        {
            _bb.setRight(r1);
            _size=_bb.getSize();
            other.setAd(0);
        }
          //2.3// p1 from the right to _bb and the bottom of p1 is lower than the bottom of _bb && the top of p1 is higher than the top of _bb
        if( (t1>t2) && (b1<b2) && (l1==r2) ) 
        {
            _bb.setRight(r1);
            _size=_bb.getSize();
            other.setAd(0);
        }
            
       //3.1// p1 is at  the left of _bb and the  top of p1 is higher than the top of _bb
        if( (t1>t2) && (b1==b2) && (r1==l2)  )
        {
            _bb.setLeft(l1);
            _size=_bb.getSize();
            other.setAd(0);
        } 
        //3.2// p1 is at  the left of _bb and the  bottom of p1 is lower than the bottom of _bb
        if( (t1==t2) && (b1<b2) && (r1==l2)  )
        {
            _bb.setLeft(l1);
            _size=_bb.getSize();
            other.setAd(0);            
        }
           //3.3// p1 is at  the left of _bb and the  bottom of p1 is lower than the bottom of _bb &&top of p1 is higher than the top of _bb
        if( (t1>t2) && (b1<b2) && (r1==l2)  )
        {
            _bb.setLeft(l1);
            _size=_bb.getSize();
            other.setAd(0);
        } 
        //4.1 // p1 is above to _bb   and his right value is bigger than p2 is right value
        if( (b1==t2) && (l2==l1) && (r1>r2)  )
        {
            _bb.setTop(t1);
            _size=_bb.getSize();
            other.setAd(0);
        }
        //4.2 // p1 is above to _bb   and his left value is bigger than p2 is left value
        if( (b1==t2) && (r2==r1) && (l1<l2)  )
        {
             _bb.setTop(t1);
             _size=_bb.getSize();
            other.setAd(0);
        }
        //4.3 // p1 is above to _bb   nd his right value is bigger than p2 is right value && his left value is bigger than p2 is left value
        if( (b1==t2) && (l1<l2) && (r1>r2)  )
        {
             _bb.setTop(t1);
             _size=_bb.getSize();
            other.setAd(0);
        }
        /***** case 3 *******/
          if( (t1==t2) && (b1==b2) && (l1==l2)&&(r1==r2)  )
        {             
            other.setAd(1);
            
        }  
        /**** case 4- inside tha Cube *********/
        
        /**4.1**** top and bottom are  diffrent *****/
          if( (t1>=t2) && (b1<=b2) && (l1==l2)&&(r1==r2)  )
        {    
            _bb.setTop(t1);
            _bb.setBottom(b1);
            _size=_bb.getSize();
            other.setAd(1);
            
        }
        /**4.2*** right and left are  diffrent *****/
          if( (t1==t2) && (b1==b2) && (l1<=l2)&&(r1>=r2)  )
        {    
            _bb.setLeft(l1);
            _bb.setRight(r1);
            _size=_bb.getSize();
            other.setAd(1);
            
        }
        
   }
}

