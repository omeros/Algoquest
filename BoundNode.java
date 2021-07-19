package Algoquest;
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
    /******** combine "other" BoundNode to "this" BoundNod **********************/
    public void addNode(BoundNode other)
    /*****************************************************************************/
    {
        Bound p1 = other.getBound();
        double otherLeft = p1.getLeft();
        double otherRight = p1.getRight();
        double otherTop = p1.getTop();
        double otheBottom = p1.getBottom();
        
        double thisLeft =_bb.getLeft();
        double thisRight=_bb.getRight();
        double thisTop=_bb.getTop();
        double thisBottom=_bb.getBottom();
       
              /** case 1 */        
        // p1 is above to _bb  and has the same right and left values
//        if( (b1==thisTop) && (otherLeft==l2) && (r1==thisRight) )
//        {
//            _bb.setTop(otherTop);
//            
//            _size=_bb.getSize();
//            other.setAd(1);
//            
//        }                      
        // p1 is in the bottom of _bb        
//        if( (otherTop==thisBottom) && (l1==l2) && (r1==thisRight) )
//        {
//            _bb.setBottom(b1);
//            _size=_bb.getSize();
//            other.setAd(1);
//        }
//        // p1 from the right to _bb
//        if( (otherTop==thisTop) && (b1==thisBottom) && (thisRight==otherLeft) ) 
//        {
//            _bb.setRight(r1);
//            _size=_bb.getSize();
//            other.setAd(1);
//        }
        // p1 is at  the left of _bb
//        if( (otherTop==thisTop) && (b1==thisBottom) && (otherRight==thisLeft)  )
//        {
//            _bb.setLeft(otherLeft);
//            _size=_bb.getSize();
//            other.setAd(1);
//        }
                /** case 2 */
                             
      //1.1   // p1 is in the bottom of _bb and the right  of p1 is bigger than the right of _bb is right
         if( (otherLeft<=thisLeft) && (otherTop==thisBottom) && (thisRight<=otherRight) )
        {
            _bb.setBottom(otheBottom);
            _size=_bb.getSize();
            other.setAd(0);
        }
       //1.2 // p1 is in the bottom of _bb and the left  of p1 is bigger than the left of _bb is right
//         if( (otherTop==b2) && (otherLeft<l2) && (r1==r2) )
//        {
//            _bb.setBottom(otheBottom);
//            _size=_bb.getSize();
//            other.setAd(0);
//        }
       //1.3 // p1 is in the bottom of _bb and the left and right of p1 is bigger than the left and right of _bb is right
//         if( (otherTop==thisBottom) && (otherLeft<thisLeft) && (r1>thisRight) )
//        {
//            _bb.setBottom(otheBottom);
//            _size=_bb.getSize();
//            other.setAd(0);
//        }
        //2.1 // p1 from the right to _bb and the top of p1 is higher than the top of _bb 
//        if( (otherTop>t2) && (otheBottom==thisBottom) && (otherLeft==thisRight) ) 
//        {
//            _bb.setRight(r1);
//            _size=_bb.getSize();
//            other.setAd(0);
//        }
//         //2.2 // p1 from the right to _bb and the bottom of p1 is lower than the bottom of _bb 
//        if( (otherTop==t2) && (otheBottom<b2) && (otherLeft==thisRight) ) 
//        {
//            _bb.setRight(r1);
//            _size=_bb.getSize();
//            other.setAd(0);
//        }
          //2.3// p1 from the right to _bb and the bottom of p1 is lower than the bottom of _bb && the top of p1 is higher than the top of _bb
        if( (otherTop>=thisTop) && (otheBottom<=thisBottom) && (otherLeft==thisRight) ) 
        {
            _bb.setRight(otherRight);
            _size=_bb.getSize();
            other.setAd(0);
        }
            
       //3.1// p1 is at  the left of _bb and the  top of p1 is higher than the top of _bb
//        if( (otherTop>t2) && (b1==b2) && (r1==thisLeft)  )
//        {
//            _bb.setLeft(otherLeft);
//            _size=_bb.getSize();
//            other.setAd(0);
//        } 
//        //3.2// p1 is at  the left of _bb and the  bottom of p1 is lower than the bottom of _bb
//        if( (otherTop==t2) && (otheBottom<b2) && (r1==thisLeft)  )
//        {
//            _bb.setLeft(otherLeft);
//            _size=_bb.getSize();
//            other.setAd(0);            
//        }
           //3.3// p1 is at  the left of _bb and the  bottom of p1 is lower than the bottom of _bb &&top of p1 is higher than the top of _bb
        if( (otherTop>=thisTop) && (otheBottom<=thisBottom) && (otherRight==thisLeft)  )
        {
            _bb.setLeft(otherLeft);
            _size=_bb.getSize();
            other.setAd(0);
        } 
        //4.1 // p1 is above to _bb   and his right value is bigger than p2 is right value
//        if( (otheBottom==t2) && (l2==otherLeft) && (r1>thisRight)  )
//        {
//            _bb.setTop(t1);
//            _size=_bb.getSize();
//            other.setAd(0);
//        }
//        //4.2 // p1 is above to _bb   and his left value is bigger than p2 is left value
//        if( (otheBottom==thisTop) && (thisRight==r1) && (otherLeft<thisLeft)  )
//        {
//             _bb.setTop(otherTop);
//             _size=_bb.getSize();
//            other.setAd(0);
//        }
        //4.3 // p1 is above to _bb and his right and left values is bigger or equal to p2's right&left values.
        if( ( (otherLeft<=thisLeft) && thisTop==otheBottom) &&(thisRight<=otherRight)  )
        {
        	
             _bb.setTop(otherTop);
             _size=_bb.getSize();
             other.setAd(0);
        }
        /***** case 3 *******/
//          if( (otherTop==t2) && (b1==thisBottom) && (otherLeft==thisLeft)&&(r1==thisRight)  )
//        {             
//            other.setAd(1);
//            
//        }  
        /**** case 4- p1 is inside the Cube *********/
        
        /**4.1**** top and bottom are  different *****/
          if( (otherTop>=thisTop) && (otheBottom<=thisBottom) && (otherLeft<=thisLeft)&&(otherRight>=thisRight)  )
        {    
            _bb.setTop(otherTop);
            _bb.setBottom(otheBottom);
            _bb.setLeft(otherLeft);
            _bb.setRight(otherRight);
            _size=_bb.getSize();
            other.setAd(1);
            
        }
//        /**4.2*** right and left are  different *****/
//          if( (otherTop==t2) && (otheBottom==thisBottom) && (otherLeft<=thisLeft)&&(r1>=r2)  )
//        {    
//            _bb.setLeft(otherLeft);
//            _bb.setRight(r1);
//            _size=_bb.getSize();
//            other.setAd(1);
//            
//        }
//        
   }
//    public boolean equals( Object other)
//    {
//    	return;
//    }
}

