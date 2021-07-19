package Algoquest;
/**
 * a Bound class.
 * 
 * @author (omer) 
 * @version (04.01.16)
 */
public class Bound
{
    // instance variables 
    private double _L;
    private double _R;
    private double _T;
    private double _B;
   
    /**
     * Constructor for objects of class Bound
     */
    public Bound(double L, double R, double T, double B)
    {
       _L=L;
       _R=R;
       _T=T;
       _B=B;
    }
    public Bound(Bound other)
    {
       _T=other.getTop();
       _B=other.getBottom();
       _L=other.getLeft();
       _R=other.getRight();
    }
    
    public double getSize()
    {
        double s=(_T-_B)*(_R-_L);
        return s;
    }
    
    
    public double getTop()
    {
        return _T;
    }
    
    public double getBottom()
    {
        return _B;
    }
    
    public double getLeft()
    { 
       return _L;
    }
    public double getRight()
    { 
        return _R;
    }
    
      
    public void setTop(double t)
    {
         _T=t;
    }
    
    public void setBottom(double b)
    {
        _B=b;
    }
    
    public void setLeft(double l)
    { 
        _L=l;
    }
    public void setRight(double r)
    { 
         _R=r;
    }
    public String  toString() 
    {
    	Double  L=_L;
    	Double  R=_R;
    	Double  T=_T;
    	Double  B=_B;
    	String ans = "  L :"+L+ "  R : " +R+ "  T :" +T+" B :"+B; 
    	return  ans;   	
    }
       
}

