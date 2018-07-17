package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBTree<T> {

   public RBTreeImpl() {
      this.root = new RBNode<T>();
   }

   protected int blackHeight() {
      return blackHeight(castNode(this.root));
   }

   private int blackHeight(RBNode<T> node) {
      int blackHeight = 0;
      if (!node.isEmpty()) {
         if (node.getColour() == Colour.BLACK) {
            int left = 1 + blackHeight(castNode(node.getLeft()));
            int right = 1 + blackHeight(castNode(node.getRight()));
            blackHeight = Math.max(left, right);
         } else {
            int left = blackHeight(castNode(node.getLeft()));
            int right = blackHeight(castNode(node.getRight()));
            blackHeight = Math.max(left, right);
         }
      }
      return blackHeight;
   }

   protected boolean verifyProperties() {
      boolean resp = verifyNodesColour() && verifyNILNodeColour() && verifyRootColour() && verifyChildrenOfRedNodes()
            && verifyBlackHeight();

      return resp;
   }

   /**
    * The colour of each node of a RB tree is black or red. This is guaranteed
    * by the type Colour.
    */
   private boolean verifyNodesColour() {
      return true; // already implemented
   }

   /**
    * The colour of the root must be black.
    */
   private boolean verifyRootColour() {
      return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
      // implemented
   }

   /**
    * This is guaranteed by the constructor.
    */
   private boolean verifyNILNodeColour() {
      return true; // already implemented
   }

   /**
    * Verifies the property for all RED nodes: the children of a red node must
    * be BLACK.
    */
   private boolean verifyChildrenOfRedNodes() {
      return verifyChildrenOfRedNodes(castNode(this.root));
   }

   private boolean verifyChildrenOfRedNodes(RBNode<T> node) {
      boolean valid = true;
      if (!node.isEmpty()) {
         if (node.getColour() == Colour.RED) {
            if (castNode(node.getLeft()).getColour() == Colour.RED
                  || castNode(node.getRight()).getColour() == Colour.RED) {
               valid = false;
            } else {
               valid = verifyChildrenOfRedNodes(castNode(node.getLeft()));
               valid = verifyChildrenOfRedNodes(castNode(node.getRight()));
            }
         } else {
            valid = verifyChildrenOfRedNodes(castNode(node.getLeft()));
            valid = verifyChildrenOfRedNodes(castNode(node.getRight()));
         }
      }
      return valid;
   }

   /**
    * Verifies the black-height property from the root. The method blackHeight
    * returns an exception if the black heights are different.
    */
   private boolean verifyBlackHeight() {
      return vbh((RBNode<T>) root);
   }

   private boolean vbh(RBNode<T> node) {
      int left = 0;
      int right = 0;
      boolean validLeft = true;
      boolean validRight = true;
      if (!node.isEmpty()) {
         validLeft = vbh((RBNode<T>) node.getLeft());
         left = blackHeight((RBNode<T>) node.getLeft());
      }
      if (!node.isEmpty()) {
         validRight = vbh((RBNode<T>) node.getRight());
         right = blackHeight((RBNode<T>) node.getRight());
      }
      return left == right && validLeft && validRight;
   }

   @Override
   public void insert(T element) {
      if (element != null) {
         if (this.isEmpty()) {
            this.getRoot().setData(element);
            this.getRoot().setLeft(new RBNode<T>());
            this.getRoot().setRight(new RBNode<T>());
         } else {
            insert(null, castNode(getRoot()), element);
         }
      }
   }

   private void insert(RBNode<T> previous, RBNode<T> node, T element) {
      if (node.isEmpty()) {
         node.setData(element);
         node.setLeft(new RBNode<T>());
         node.setRight(new RBNode<T>());
         node.setParent(previous);
         node.setColour(Colour.RED);
         fixUpCase1(node);
      } else {
         if (node.getData().compareTo(element) < 0) {
            insert(node, castNode(node.getRight()), element);
         } else if (node.getData().compareTo(element) > 0) {
            insert(node, castNode(node.getLeft()), element);
         }
      }
   }

   @Override
   public RBNode<T>[] rbPreOrder() {
      RBNode<T>[] array = new RBNode[size()];
      preOrder(castNode(getRoot()), array);
      return array;
   }

   private void preOrder(RBNode<T> node, RBNode<T>[] array) {
      if (!node.isEmpty()) {
         addInArray(node, array);
         preOrder(castNode(node.getLeft()), array);
         preOrder(castNode(node.getRight()), array);
      }
   }

   protected void addInArray(RBNode<T> node, RBNode<T>[] array) {
      int count = 0;
      while (count < array.length && array[count] != null) {
         count++;
      }
      if (count < array.length) {
         array[count] = node;
      }
   }

   // FIXUP methods
   protected void fixUpCase1(RBNode<T> node) {
      if (node.getParent() == null) {
         node.setColour(Colour.BLACK);
      } else {
         fixUpCase2(node);
      }
   }

   protected void fixUpCase2(RBNode<T> node) {
      if (castNode(node.getParent()).getColour() == Colour.RED) {
         fixUpCase3(node);
      }
   }

   protected void fixUpCase3(RBNode<T> node) {
      if (getUncle(node).getColour() == Colour.RED) {
         castNode(node.getParent()).setColour(Colour.BLACK);
         getUncle(node).setColour(Colour.BLACK);
         castNode(node.getParent().getParent()).setColour(Colour.RED);
         fixUpCase1(castNode(node.getParent().getParent()));
      } else {
         fixUpCase4(node);
      }
   }

   protected void fixUpCase4(RBNode<T> node) {
      RBNode<T> next = node;
      RBNode<T> father = castNode(node.getParent());
      if (isRightChild(node) && isLeftChild(father)) {
         Util.leftRotation(father);
         next = castNode(node.getLeft());
      } else if (isLeftChild(node) && isRightChild(father)) {
         Util.rightRotation(father);
         next = castNode(node.getRight());
      }

      fixUpCase5(next);
   }

   protected void fixUpCase5(RBNode<T> node) {
      castNode(node.getParent()).setColour(Colour.BLACK);
      castNode(node.getParent().getParent()).setColour(Colour.RED);
      if (isLeftChild(node)) {
         Util.rightRotation(castNode(node.getParent().getParent()));
      } else {
         Util.leftRotation(castNode(node.getParent().getParent()));
      }
   }

   private RBNode<T> getUncle(RBNode<T> node) {
      RBNode<T> uncle = new RBNode<T>();
      RBNode<T> father = castNode(node.getParent());
      RBNode<T> grandfather = castNode(father.getParent());
      if (grandfather.getLeft().equals(father)) {
         uncle = castNode(grandfather.getRight());
      } else {
         uncle = castNode(grandfather.getLeft());
      }
      return uncle;
   }

   private boolean isRightChild(RBNode<T> node) {
      boolean isRightChild = false;
      if (node.getParent() != null && castNode(node.getParent().getRight()).equals(node)) {
         isRightChild = true;
      }
      return isRightChild;
   }

   private boolean isLeftChild(RBNode<T> node) {
      boolean isLeftChild = false;
      if (node.getParent() != null && castNode(node.getParent().getLeft()).equals(node)) {
         isLeftChild = true;
      }
      return isLeftChild;
   }

   protected RBNode<T> castNode(Object object) {
      RBNode<T> node = null;
      if (object instanceof RBNode<?>) {
         node = (RBNode<T>) object;
      }
      return node;
   }

}
