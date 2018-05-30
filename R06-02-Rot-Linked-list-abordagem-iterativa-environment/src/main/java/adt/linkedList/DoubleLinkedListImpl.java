package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

   protected DoubleLinkedListNode<T> last;

   public DoubleLinkedListImpl() {
      head = new DoubleLinkedListNode<T>();
      last = (DoubleLinkedListNode<T>) head;
   }
   
   @Override
   public void insert(T element) {
      if (element != null) {
         DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, null, null);
         newLast.setPrevious(getLast());
         DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>(null, null, newLast);
         newLast.setNext(nil);
         getLast().setNext(newLast);
         if (getLast().isNIL()) {
            setHead(newLast);
         }
         setLast(newLast);
      }
   }
   
   @Override
   public void remove(T element) {
	   if(element != null) {
		   if(getHead().getData().equals(element)) {
			   removeFirst();
		   }
		   else {
			   DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) getHead();
			   while(!aux.isNIL() && !aux.getData().equals(element)) {
				   aux = (DoubleLinkedListNode<T>) aux.getNext();
			   }
			   if(!aux.isNIL()) {
				   aux.getPrevious().setNext(aux.getNext());
				   ((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
			   }
		   }
	   }

   }

   @Override
   public void insertFirst(T element) {
	   if(element != null) {
		   DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, null, null);
		   newHead.setNext(getHead());
	       DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>(null, newHead, null);
		   newHead.setPrevious(nil);
	       ((DoubleLinkedListNode<T>) getHead()).setPrevious(newHead);
	       if (getHead().isNIL()) {
	          setLast(newHead);
	       }
	       setHead(newHead);
	   }
   }

   @Override
   public void removeFirst() {
      if (!getHead().isNIL()) {
         setHead(getHead().getNext());
         if (getHead().isNIL()) {
            setLast((DoubleLinkedListNode<T>) getHead());
         }
         DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>(null, (DoubleLinkedListNode<T>) getHead(), null);
         ((DoubleLinkedListNode<T>) getHead()).setPrevious(nil);
      }
   }

   @Override
   public void removeLast() {
      if (!getLast().isNIL()) {
         setLast(getLast().getPrevious());
         if (getLast().isNIL()) {
            setHead(getLast());
         }
         DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>(null, null, getLast());
         getLast().setNext(nil);
      }
   }

   public DoubleLinkedListNode<T> getLast() {
      return last;
   }

   public void setLast(DoubleLinkedListNode<T> last) {
      this.last = last;
   }
}
