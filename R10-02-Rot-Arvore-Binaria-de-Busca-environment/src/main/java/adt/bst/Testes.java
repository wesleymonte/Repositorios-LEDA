package adt.bst;

public class Testes {

	public static void main(String[] args) {
		BSTImpl<Integer> tree = new BSTImpl<Integer>();
		tree.insert(15);
		tree.insert(6);
		tree.insert(18);
		tree.insert(3);
		tree.insert(7);
		tree.insert(17);
		tree.insert(20);
		tree.insert(13);
		tree.insert(2);
		tree.insert(4);
		tree.insert(9);
		
		System.out.println(tree.sucessor(20).isEmpty());

	}

}
