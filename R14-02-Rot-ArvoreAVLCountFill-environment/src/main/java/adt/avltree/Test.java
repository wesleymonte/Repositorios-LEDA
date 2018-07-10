package adt.avltree;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		AVLCountAndFill<Integer> tree1 = new AVLCountAndFillImpl<Integer>();
		AVLCountAndFill<Integer> tree2 = new AVLCountAndFillImpl<Integer>();
		
		/**
		for(int i = 0; i < 10; i++){
			tree1.insert(i);
		}
		
		Integer[] array = new Integer[10];
		for(int i = 10; i < 20; i++){
			array[i - 10] = i;
		}
		*/
		
		tree1.insert(16);
		Integer[] array = new Integer[16];
		for(int i = 0; i < 16; i++){
			array[i] = i;
		}
		
		tree1.fillWithoutRebalance(array);
		System.out.println(Arrays.toString(tree1.order()));
		System.out.println(Arrays.toString(tree1.preOrder()));
		System.out.println(Arrays.toString(tree1.postOrder()));
	}

}
