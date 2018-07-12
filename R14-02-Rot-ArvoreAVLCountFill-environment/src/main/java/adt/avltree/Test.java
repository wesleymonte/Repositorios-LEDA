package adt.avltree;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		AVLCountAndFill<Integer> tree1 = new AVLCountAndFillImpl<Integer>();
		
		tree1.insert(13);
		
		Integer[] array = new Integer[8];
		
		for(int i = 14; i <= 21; i++) {
			array[i - 14] = i;
		}
		
		tree1.fillWithoutRebalance(array);
		
		System.out.print(tree1.LLcount() == 0 ? "." : "F");
		System.out.print(tree1.LRcount() == 0 ? "." : "F");
		System.out.print(tree1.RRcount() == 0 ? "." : "F");
		System.out.println(tree1.RLcount() == 0 ? "." : "F");
		
		System.out.println(Arrays.toString(tree1.order()));
		System.out.println(Arrays.toString(tree1.preOrder()));
		System.out.println(Arrays.toString(tree1.postOrder()));
		
		AVLCountAndFill<Integer> tree2 = new AVLCountAndFillImpl<Integer>();
		array = new Integer[9];
		
		for(int i = 13; i <= 21; i++) {
			array[i - 13] = i;
		}
		
		tree2.fillWithoutRebalance(array);
		
		System.out.print(tree2.LLcount() == 0 ? "." : "F");
		System.out.print(tree2.LRcount() == 0 ? "." : "F");
		System.out.print(tree2.RRcount() == 0 ? "." : "F");
		System.out.println(tree2.RLcount() == 0 ? "." : "F");
		
		System.out.println(Arrays.toString(tree2.order()));
		System.out.println(Arrays.toString(tree2.preOrder()));
		System.out.println(Arrays.toString(tree2.postOrder()));
		
		AVLCountAndFill<Integer> tree3 = new AVLCountAndFillImpl<Integer>();
		
		Integer[] keys = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
		
		tree3.fillWithoutRebalance(keys);
		
		System.out.print(tree3.LLcount() == 0 ? "." : "F");
		System.out.print(tree3.LRcount() == 0 ? "." : "F");
		System.out.print(tree3.RRcount() == 0 ? "." : "F");
		System.out.println(tree3.RLcount() == 0 ? "." : "F");
		
		System.out.println(Arrays.toString(tree3.order()));
		System.out.println(Arrays.toString(tree3.preOrder()));
		System.out.println(Arrays.toString(tree3.postOrder()));
	}

}
