package adt.hashtable.closed;

import java.util.Arrays;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;

public class TestesHashTable {

	public static void main(String[] args) throws Exception {
        HashtableClosedAddressImpl<Integer> k = new HashtableClosedAddressImpl<Integer>(5, HashFunctionClosedAddressMethod.DIVISION);
        
        System.out.print(k.capacity() == 5 ? "." : "F");
        System.out.print(k.getCOLLISIONS() == 0 ? "." : "F");
        System.out.print(k.isEmpty() ? "." : "F");
        System.out.print(!k.isFull() ? "." : "F");
        System.out.print(k.size() == 0 ? "." : "F");
        System.out.print(k.search(-1) == null ? "." : "F");
        System.out.println(k.indexOf(-1) == -1 ? "." : "F");
        
        k.insert(-1);
        k.insert(5);
        k.insert(15);
        k.insert(1);
        k.insert(-1);
        
        System.out.print(k.capacity() == 5 ? "." : "F");
        System.out.print(k.getCOLLISIONS() == 2 ? "." : "F");
        System.out.print(!k.isEmpty() ? "." : "F");
        System.out.print(!k.isFull() ? "." : "F");
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(5) == 5 ? "." : "F");
        System.out.print(k.search(-1) == -1 ? "." : "F");
        System.out.print(k.indexOf(-1) == 1 ? "." : "F");
        System.out.print(k.indexOf(5) == 0 ? "." : "F");
        System.out.print(k.indexOf(15) == 0 ? "." : "F");
        System.out.println(k.indexOf(1) == 1 ? "." : "F");
        
        k.insert(39);
        
        System.out.print(k.capacity() == 5 ? "." : "F");
        System.out.print(k.getCOLLISIONS() == 2 ? "." : "F");
        System.out.print(!k.isEmpty() ? "." : "F");
        System.out.print(k.isFull() ? "." : "F");
        System.out.print(k.size() == 5 ? "." : "F");
        System.out.print(k.search(15) == 15 ? "." : "F");
        System.out.print(k.search(1) == 1 ? "." : "F");
        System.out.print(k.search(39) == 39 ? "." : "F");
        System.out.println(k.indexOf(39) == 4 ? "." : "F");
        
        
    }

}
