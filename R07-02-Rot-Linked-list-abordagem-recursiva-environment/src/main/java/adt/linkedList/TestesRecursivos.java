package adt.linkedList;

import java.util.Arrays;

import adt.stack.StackOverflowException;
import adt.stack.StackRecursiveDoubleLinkedListImpl;
import adt.stack.StackUnderflowException;

public class TestesRecursivos {

	public static void main(String[] args) throws Exception {
        RecursiveDoubleLinkedListImpl<Integer> k = new RecursiveDoubleLinkedListImpl<Integer>();
        
        
        System.out.println("metodos sll");
        System.out.print(k.isEmpty() ? "." : "F");
        System.out.print(k.size() == 0 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        
        k.remove(4);
        k.insert(null);
        k.insert(6);
        
        System.out.print(k.size() == 1 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(6) == 6 ? "." : "F");
        
        k.remove(6);
        k.insert(25);
        
        System.out.print(k.size() == 1 ? "." : "F");
        System.out.print(k.search(6) == null ? "." : "F");
        System.out.print(k.search(25) == 25 ? "." : "F");
        
        k.insert(3);
        k.insert(7);
        k.insert(3);
        
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        
        k.remove(3);
        
        System.out.print(k.size() == 3 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[25, 7, 3]") ? "." : "F");
        
        k.insert(null);
        
        System.out.print(k.size() == 3 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[25, 7, 3]") ? "." : "F");
        
        k.remove(null);
        
        System.out.print(k.size() == 3 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[25, 7, 3]") ? "." : "F");
        System.out.print(k.search(null) == null ? "." : "F");
        
        StackRecursiveDoubleLinkedListImpl<Integer> i = new StackRecursiveDoubleLinkedListImpl<Integer>(4);
        
        System.out.println("\nTestes Pilha");
        
        System.out.print(i.isEmpty() ? "." : "F");
        System.out.print(!i.isFull() ? "." : "F");
        System.out.print(i.top() == null ? "." : "F");
        
        try {
        	i.pop();
        	System.out.print("F");
        } catch(StackUnderflowException e) {
        	System.out.print(".");
        }
        
        i.push(1);
        i.push(2);
        i.push(3);
        i.push(null);
        
        System.out.print(!i.isEmpty() ? "." : "F");
        System.out.print(!i.isFull() ? "." : "F");
        System.out.print(i.top().equals(3) ? "." : "F");
        
        i.push(4);
        
        System.out.print(!i.isEmpty() ? "." : "F");
        System.out.print(i.isFull() ? "." : "F");
        System.out.print(i.top().equals(4) ? "." : "F");
        
        try {
        	i.push(5);
        	System.out.print("F");
        } catch(StackOverflowException e) {
        	System.out.print(".");
        }
        
    }

}
