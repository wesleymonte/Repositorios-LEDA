package adt.avltree;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		AVLCountAndFill<Integer> tree1 = new AVLCountAndFillImpl<Integer>();
		AVLCountAndFill<Integer> tree2 = new AVLCountAndFillImpl<Integer>();
		for (int i = 0; i < 10; i++) {
			tree1.insert(i);
			tree2.insert(10 - i);
		}
		Integer[] array = new Integer[10];
		for(int i = 20; i > 10; i--) {
			array[20 - i] = i;
		}
		tree1.fillWithoutRebalance(array);
		System.out.println(Arrays.toString(tree1.order()));
	}

}
