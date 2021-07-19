package Algoquest;
/**
 * Write a description of class mainalgo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainalgo
{
   

    /**
     * Constructor for objects of class mainalgo
     */
    public mainalgo()
    {
       
    }

    public static void main (String[]  args)
   {
    /**   Bound bo1=new Bound(0,8,8,0);
       BoundNode h1=new BoundNode(bo1,null);;
       BoundList list3=new BoundList(h1);
       //BoundNode h1=list.getHead();
       
       
       
       Bound bo2=new Bound(4,16,16,8);
       BoundNode h2=new BoundNode(bo2,null);  
       
       Bound bo3=new Bound(8,16,16,8);
       BoundNode h3=new BoundNode(bo3,null);
       
       Bound bo4=new Bound(4,16,16,8);
       BoundNode h4=new BoundNode(bo4,null);
       
       Bound bo5=new Bound(8,16,16,8);
       BoundNode h5=new BoundNode(bo5,null);
       
       Bound bo6=new Bound(0,8,8,0);
       BoundNode h6=new BoundNode(bo6,null);
       
       h1.setNext(h2);
       h2.setNext(h3);
       h3.setNext(h4);
       h4.setNext(h5);
       h5.setNext(h6);
       
       Algoquest a= new Algoquest();
       Bound out2=a.findTheMaxBound(list3);
       
       System.out.println(" The MAX result is: ");
       double qqq=out2.getSize();
       
       double tttt=out2.getTop();
       double bbbb=out2.getBottom();
       double rrrr=out2.getRight();
       double llll=out2.getLeft();
       
       System.out.println(llll +","+ rrrr+ ","+ tttt+ ","+ bbbb + ", and size is :" + qqq);
       
       
       
       System.out.println(" All BoundNodes of List3 is: ");
       BoundNode p2=list3.getHead();
       while(p2!=null)
       {
          Bound o2=p2.getBound();
          double ttt=o2.getTop();
          double bbb=o2.getBottom();
          double rrr=o2.getRight();
          double lll=o2.getLeft();  
          double sizeee=o2.getSize();
          System.out.println(lll +","+ rrr+ ","+ ttt+ ","+ bbb+" ,The size is :" +sizeee);
            
            p2=p2.getNext();
        }
       
       System.out.println(" ********************** ");
       System.out.println("  "); */
       
       
       
       /****************************************************************/
       Bound mainb=new Bound (100,1000,50,500);//(0,16,16,0); // (l,r,t,b)
       
		/* Bound b2=new Bound(500,1000,50,500); */ //(2,4,12,8);       //  top  left 
     //  Bound b5=new Bound (12,19,15,11);   //   top right
     //  Bound b4=new Bound (4,8,5,1);      //    botton  left
     //  Bound b3=new Bound (12,15,10,4);  //     botton right
    
       
       
      // BoundNode Node2=new BoundNode(b2,null);
       BoundList list2;//=new BoundList();
       Bound out;
       
       Bound b2=new Bound(400,1000,500,50);
       Bound [] array=new Bound [1];
       array [0]=b2;
     //  array [1]=b3;
      // array [2]=b4;
      // array [3]=b5;
       
       Algoquest a= new Algoquest();
       boolean ans1=a.ereaIsBlock(500,1000,500,50,array);   //(0,8,8,0,array);
       boolean ans2=a.ereaIsClear(100,500,500,50,array);  //(0,8,16,8,array);
       boolean ans3=a.ereaIsBlock(8,16,8,0,array);
       boolean ans4=a.ereaIsClear(8,16,16,8,array);
       boolean ans5=a.ereaIsBlock(0,8,16,8,array); 
       
         if(ans1){
       System.out.println( " erea (500,1000,500,50) is Block ");
       }
       else{
           System.out.println(" erea (100,500,500,50) is NOT Block");                 
    }
         
         if(ans2){
       System.out.println( " erea (100,500,500,50) is clear ");
       }
       else{
           System.out.println(" erea (500,1000,500,50) is NOT clear");                 
    }
       
       list2=a.findMax(0,1000,500,50,array);//0,16,16,0,array);       /** <==============================*/
       out=a.findTheMaxBound(list2);
       
  /**   if(ans1){
       System.out.println( " erea (0,8,8,0) is Block ");
       }
       else{
           System.out.println(" erea (0,8,8,0) is NOT Block");                 
    }
      if(  ans2){    
       System.out.println( "erea (0,8,16,8) is clear ");
       }
       else{
           System.out.println("erea (0,8,16,8) is NOT clear");
        
       } 
       if(ans3){
       System.out.println( " erea (8,16,8,0) is block ");
       }
       else{
           System.out.println(" erea (8,16,8,0) is NOT block");                 
    }
      if(  ans4){    
       System.out.println( "erea (8,16,16,8) is clear");
       }
       else{
           System.out.println("erea (8,16,16,8) is NOT clear");
        
       } 
       if(  ans4){    
       System.out.println( "erea (0,8,16,8) is Block");
       }
       else{
           System.out.println("erea (0,8-,16,8) is NOT Block");
        
       } */
       System.out.println(" ********************** ");
       System.out.println("  ");
       double q=out.getSize();
       System.out.println(" The MAX result is: ");
       
       double t=out.getTop();
       double b=out.getBottom();
       double r=out.getRight();
       double l=out.getLeft();
       
       System.out.println(l +","+ r+ ","+ t+ ","+ b + ", and size is :" + q);
       System.out.println(" ");
       
       
    /**   System.out.println(" All List results of List2 is: ");
       BoundNode p=list2.getHead();
       while(p!=null)
       {
          Bound o=p.getBound();
          double tt=o.getTop();
          double bb=o.getBottom();
          double rr=o.getRight();
          double ll=o.getLeft();  
          double size=o.getSize();
          System.out.println(ll +","+ rr+ ","+ tt+ ","+ bb+" ,The size is :" +size);
            
            p=p.getNext();
        }
  /**      System.out.println(" ************************************************* ");
       System.out.println(" ");
     
     System.out.println(" second print of list: ");
       BoundNode u=list2.getHead();
       while(u!=null)
       {
          Bound v=u.getBound();
          double f1=v.getTop();
          double f2=v.getBottom();
          double f3=v.getRight();
          double f4=v.getLeft();  
          double f5=v.getSize();
          System.out.println(f4 +","+ f3+ ","+ f1+ ","+ f2+" ,The size is :" + f5);
            
            u=u.getNext();
        }
     /**  Bound d=a.findTheMaxBound(list2);   /*** <==================================== */
      /** System.out.println(" The MAX result again is: ");
       
       double e1=d.getTop();
       double e2=d.getBottom();
       double e3=d.getRight();
       double e4=d.getLeft();
       double w=d.getSize();
       
       System.out.println(e4 +","+ e3+ ","+ e1+ ","+ e2 + ", and size is :" + w);
       System.out.println(" ");
    
    
        BoundNode p1=list2.getHead();
        BoundNode maximal=p1;
        double max=0.0;
        double s;
        while(p1!=null)
        {
            s=p1.getSize();
            System.out.println("s num " +s);
            if(max<s)
            {
                max=s;
                maximal=p1;
                System.out.println("max num " +max);
            }
            p1=p1.getNext();                     
        }
        Bound m=maximal.getBound();
            
       }*/
}
}
