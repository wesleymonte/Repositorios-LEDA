package adt.linkedList;

import java.util.Arrays;

import adt.queue.QueueDoubleLinkedListImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;
import adt.stack.StackDoubleLinkedListImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class Main {

	public static void main(String[] args) throws Exception {
        DoubleLinkedListImpl<Integer> k = new DoubleLinkedListImpl<>();
        
        
        System.out.println("metodos sll");
        System.out.print(k.isEmpty() ? "." : "F");
        System.out.print(k.size() == 0 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        k.insert(6);
        System.out.print(k.size() == 1 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(6) == 6 ? "." : "F");
        k.insert(25);
        System.out.print(k.size() == 2 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(25) == 25 ? "." : "F");
        k.insert(3);
        k.insert(7);
        k.insert(3);
        System.out.print(k.size() == 5 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        k.remove(3);
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        // Integer[] array = k.toArray();
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25, 7, 3]") ? "." : "F");
        k.insert(null);
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25, 7, 3]") ? "." : "F");
        k.remove(null);
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25, 7, 3]") ? "." : "F");
        System.out.print(k.search(null) == null ? "." : "F");
        
        
        System.out.println("\nmetodos dll");
        k.insertFirst(9);
        k.insertFirst(17);
        System.out.print(k.size() == 6 ? "." : "F");
        System.out.print(k.search(9) == 9 ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[17, 9, 6, 25, 7, 3]") ? "." : "F");
        //System.out.print(k.search(null) == null ? "." : "F");
        k.removeFirst();
        System.out.print(k.size() == 5 ? "." : "F");
        System.out.print(k.search(17) == null ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[9, 6, 25, 7, 3]") ? "." : "F");
        k.removeLast();
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(3) == null ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[9, 6, 25, 7]") ? "." : "F");
        k.removeFirst();
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25, 7]") ? "." : "F");
        k.removeLast();
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25]") ? "." : "F");
        k.removeFirst();
        System.out.print(Arrays.toString(k.toArray()).equals("[25]") ? "." : "F");
        k.removeLast();
        System.out.print(k.size() == 0 ? "." : "F");
        System.out.print(k.search(25) == null ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[]") ? "." : "F");
        
        QueueDoubleLinkedListImpl<Integer> j = new QueueDoubleLinkedListImpl<Integer>(4);
        
        System.out.println("\nTestes Fila");
        
        j.enqueue(1);
        j.enqueue(2);
        
        System.out.print(!(j.isFull()) ? "." : "F");
        System.out.print(!(j.isEmpty()) ? "." : "F");
        System.out.print(j.head().equals(1) ? "." : "F");
        
        j.enqueue(3);
        j.enqueue(4);
        
        System.out.print(j.isFull() ? "." : "F");
        System.out.print(!j.isEmpty() ? "." : "F");
        
        try {
        	j.enqueue(5);
        	System.out.print("F");
        } catch(QueueOverflowException e) {
        	System.out.print(".");
        }
        
        j.dequeue();
        
        System.out.print(j.head().equals(2) ? "." : "F");
        System.out.print(!j.isFull() ? "." : "F");
        
        j.dequeue();
        j.dequeue();
        j.dequeue();
        
        System.out.print(j.isEmpty() ? "." : "F");
        System.out.print(!j.isFull() ? "." : "F");
        System.out.print(j.head() == null ? "." : "F");
        
        try {
        	j.dequeue();
        	System.out.print("F");
        } catch(QueueUnderflowException e) {
        	System.out.print(".");
        }
        
        StackDoubleLinkedListImpl<Integer> i = new StackDoubleLinkedListImpl<Integer>(4);
        
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
