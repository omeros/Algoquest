package Algoquest;

public class BoundList {
  BoundNode _head;

  /*************** Constractor **************************************/
  public BoundList()
  /*******************************************************************/
  {
    _head = null;
  }

  /********************************************************************/
  public BoundList(BoundNode b)
  /*********************************************************************/
  {
    _head = b;
  }

  /****************** return the head **********************************/
  public BoundNode getHead()
  /**********************************************************************/
  {
    return _head;
  }

  /***************** combine two lists to one list ***********************/
  public BoundList combine(BoundList other)
  /**********************************************************************/
  {
    if (other != null) {
      BoundNode otherNode = other.getHead();
      while (otherNode.getNext() != null) {
        this.addToList(otherNode); // adding the first Node in the other List  to this list
        otherNode = otherNode.getNext();
      }
      this.addToList(otherNode);
      return this;
    }
    return null;
  }

  /****************** add each node to another in the same list ***********************/
  public void refresh()
  /*******************************************************************************/
  {
    BoundNode p1 = this.getHead();
    BoundNode p2 = this.getHead();
    p2.getNext();
    while ((p1.getNext() != null)) {

      // addToList(p1);
      while (p2 != null) {
        if (p1 != p2) {
          p1.addNode(p2);
        }
        p2 = p2.getNext();
      }
      p2 = this.getHead();
      p1 = p1.getNext();
    }
    // addToList(p1);

  }

  /************* adding other Node to this list ********************************************/
  public void addToList(BoundNode other)
  /**************************************************************************************/
  {
    BoundNode myNode = this.getHead();
    while (myNode.getNext() != null) {

    	myNode.addNode(other);
    	myNode = myNode.getNext();

    }
    myNode.addNode(other);
    if (other.getAd() == 0) {
      BoundNode a = new BoundNode(other);
      myNode.setNext(a);
      other.setAd(1);
    }

  }

  /************* connect this list( last bound) with other list( head bound)********************************************/
  public BoundList unit(BoundList otherList)
  /*******************************************************************************************************************/
  {
    BoundNode myNode = this.getHead();
    while (myNode.getNext() != null) {
    	myNode = myNode.getNext();
    }
    BoundNode otherNode = otherList.getHead();
    // p2.setNext(p1); // part of the answers, - short run time
    myNode.setNext(otherNode); // all the answers, - long run time
    return this;
  }

  /*************** set to zero all the add symbols in the BoundNodes **********************************************************************/
  public void setAddToZero()
  /************************************************************************************************************************************/
  {
    BoundNode p1 = this.getHead();
    while (p1 != null) {
      p1.setAd(0);
      p1 = p1.getNext();
    }

  }
  /**************************************************************************************/
}
