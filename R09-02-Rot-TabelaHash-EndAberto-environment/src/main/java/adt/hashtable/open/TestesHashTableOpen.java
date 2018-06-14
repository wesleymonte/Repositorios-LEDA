package adt.hashtable.open;


import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;

public class TestesHashTableOpen {

	public static void main(String[] args) throws Exception {
        HashtableOpenAddressLinearProbingImpl<HashtableElement> k = new HashtableOpenAddressLinearProbingImpl<HashtableElement>(5, HashFunctionClosedAddressMethod.DIVISION);
        
        System.out.print(k.capacity() == 5 ? "." : "F");
        System.out.print(k.getCOLLISIONS() == 0 ? "." : "F");
        System.out.print(k.isEmpty() ? "." : "F");
        System.out.print(!k.isFull() ? "." : "F");
        System.out.print(k.size() == 0 ? "." : "F");
        System.out.print(k.search(new HashtableElement(-1)) == null ? "." : "F");
        System.out.println(k.indexOf(new HashtableElement(-1)) == -1 ? "." : "F");
        
        k.insert(new HashtableElement(-1));
        k.insert(new HashtableElement(5));
        k.insert(new HashtableElement(15));
        k.insert(new HashtableElement(1));
        k.insert(new HashtableElement(-1));
        
        /*
        	9
        0 5
        1 -1
        2 15
        3 1
        4 
        5
        */
        
        System.out.print(k.capacity() == 5 ? "." : "F");
        System.out.print(k.getCOLLISIONS() == 4 ? "." : "F");
        System.out.print(!k.isEmpty() ? "." : "F");
        System.out.print(!k.isFull() ? "." : "F");
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(new HashtableElement(5)).equals(new HashtableElement(5)) ? "." : "F");
        System.out.print(k.search(new HashtableElement(-1)).equals(new HashtableElement(-1)) ? "." : "F");
        System.out.print(k.indexOf(new HashtableElement(-1)) == 1 ? "." : "F");
        System.out.print(k.indexOf(new HashtableElement(5)) == 0 ? "." : "F");
        System.out.print(k.indexOf(new HashtableElement(15)) == 2 ? "." : "F");
        System.out.println(k.indexOf(new HashtableElement(1)) == 3 ? "." : "F");
        
        k.insert(new HashtableElement(39));
        
        System.out.print(k.capacity() == 5 ? "." : "F");
        System.out.print(k.getCOLLISIONS() == 4 ? "." : "F");
        System.out.print(!k.isEmpty() ? "." : "F");
        System.out.print(k.isFull() ? "." : "F");
        System.out.print(k.size() == 5 ? "." : "F");
        System.out.print(k.search(new HashtableElement(15)).equals(new HashtableElement(15)) ? "." : "F");
        System.out.print(k.search(new HashtableElement(1)).equals(new HashtableElement(1)) ? "." : "F");
        System.out.print(k.search(new HashtableElement(39)).equals(new HashtableElement(39)) ? "." : "F");
        System.out.println(k.indexOf(new HashtableElement(39)) == 4 ? "." : "F");
        
        
    }

}
