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
      _added=0;   // marking if the node was added to other node in some function
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
    public int getAd(){
        return _added;
    }
    /******** combine "other" BoundNode to "this" BoundNod **********************/
    public void addNode(BoundNode other){
    /*****************************************************************************/
        Bound p1 = other.getBound();
        double otherLeft = p1.getLeft();
        double otherRight = p1.getRight();
        double otherTop = p1.getTop();
        double otherBottom = p1.getBottom();
        
        double thisLeft =_bb.getLeft();
        double thisRight=_bb.getRight();
        double thisTop=_bb.getTop();
        double thisBottom=_bb.getBottom(); 

                /** case 2 */
                             
      //1.1   // other bound is in the bottom of _bb and the right and left  of otherBound is bigger or equal than the right and left  of _bb 
         if( (otherLeft<=thisLeft)&&(thisRight<=otherRight)&&(thisBottom==otherTop)&&(otherTop<thisTop))
        {
            _bb.setBottom(otherBottom);
            _size=_bb.getSize();
            other.setAd(0);
        }
         
         //4.3 // p1 is above to _bb and his right and left values is bigger or equal to p2's right&left values.
         if( ( (otherLeft<=thisLeft)&&(thisRight<=otherRight)&&(thisTop==otherBottom)&&(thisTop<otherTop)))
         {
        	 _bb.setTop(otherTop);
        	 _size=_bb.getSize();
        	 other.setAd(0);
         }

          //2.3// p1 from the right to _bb and the bottom of p1 is lower than the bottom of _bb && the top of p1 is higher than the top of _bb
        if( (otherTop>=thisTop) && (otherBottom<=thisBottom) && (otherLeft==thisRight)&&(thisLeft<otherLeft) ) 
        {
            _bb.setRight(otherRight);
            _size=_bb.getSize();
            other.setAd(0);
        }
            
           //3.3// other Bound (p1) is at  the left of  this Bound (_bb) and the  bottom of p1 is lower than the bottom of _bb &&top of p1 is higher than the top of _bb
        if( (otherTop>=thisTop) && (otherBottom<=thisBottom) && (otherRight==thisLeft)&&(otherRight<thisRight)  )
        {
            _bb.setLeft(otherLeft);
            _size=_bb.getSize();
            other.setAd(0);
        } 


        /**** case 4- this Bound (_bb) is inside other bound (p1) *********/
        
        /**4.1**** top and bottom are  different *****/
          if( (otherTop>=thisTop) && (otherBottom<=thisBottom) && (otherLeft<=thisLeft)&&(otherRight>=thisRight)  )
        {    
            _bb.setTop(otherTop);
            _bb.setBottom(otherBottom);
            _bb.setLeft(otherLeft);
            _bb.setRight(otherRight);
            _size=_bb.getSize();
            other.setAd(1);          
        }
      
   }

}

