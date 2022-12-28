package dataStructures;

import com.BTreePrinter;

import java.util.Objects;

public class BSTTree extends BinaryTree {

    public enum DelType {
        SUCC, PRED
    }

//    TreeNode root;

    public static void main(String[] args) {

        BSTTree tree = new BSTTree(
//                new int[]{9,19,14,7,12,18,13,16,17,1}
                new int[]{19,12,16,18,15,6,17,13,3,2}
//                new int[]{8,2,4,7,6,1,3,0,5}
//                new int[]{1,4,3,2,5,0,6}
//                new int[]{9,15,4,3,19,5,14,11,19,13}
//                new int[]{7,3,18,1,0,12,13,4,11,19}
//                new int[]{16,17,18,9,6,11,5,8,0,13}
//                new int[]{17,7,12,8,16,3,19,18,5,9}
//                new int[]{2,0,16,10,4,13,14,3,5,11}
//                new int[]{1,5,3,2,0,6,4}
        );
        BTreePrinter.printNode(tree.root);


        DelType delType = DelType.PRED;
        int[] toDel = {3,19,13,17,2};
//
        tree.delete(toDel[0], delType);
        BTreePrinter.printNode(tree.root);
        tree.delete(toDel[1], delType);
        BTreePrinter.printNode(tree.root);
        tree.delete(toDel[2], delType);
        BTreePrinter.printNode(tree.root);
        tree.delete(toDel[3], delType);
        BTreePrinter.printNode(tree.root);
        tree.delete(toDel[4], delType);
        BTreePrinter.printNode(tree.root);

        tree.printPreorder();
        tree.printPostorder();
        tree.printInorder();

        System.out.println(tree.findHeight(tree.root));

    }

    public BSTTree(int[] arr) {
        root = insertArr(root, arr);
    }

    public BSTTree() {}

    public boolean member(TreeNode root, Integer e) {
        while (root != null) {
            if (Objects.equals(root.key, e)) return true;
            else if (root.key > e) root = root.getLeft();
            else root = root.right;
        }
        return false;
    }

    public TreeNode insertArr(TreeNode root, int[] arr) {
        for (int e : arr) {
            root = insert(root, e);
        }
        return root;
    }

    public TreeNode insert(Integer e) {
        return insert(this.root, e);
    }

    public TreeNode insert(TreeNode root, Integer e) {
        TreeNode tmp = root;

        if (root == null) return new TreeNode(e);

        while (true) {
            if (tmp.getKey() == e) return root;
            if (tmp.getKey() > e) {
                if (tmp.getLeft() != null) tmp = tmp.getLeft();
                else {
                    tmp.setLeft(new TreeNode(e));
                    return root;
                }
            } else {
                if (tmp.getRight() != null) tmp = tmp.getRight();
                else {
                    tmp.setRight(new TreeNode(e));
                    return root;
                }
            }
        }
    }

    public void delete(int key, DelType b) {
        // x: usuwany węzeł
        // parent: rodzic usuwanego węzła
        // z: zamiennik usuwanego węzła
        // t: rodzic zamiennika


        TreeNode t, x, parent, z;
        TreeNode[] temp = new TreeNode[]{null};
        x = recSearch(key, root, temp);
//        z = x;
        parent = temp[0];

        if (x!=null) {
            if ((x.left == null) || (x.right == null)) {
                if ((x.left == null) && (x.right == null)) z = null;
                else if (x.left == null) z = x.right;
                else z = x.left;
                if (parent == null) root = z;
                else if (x == parent.left) parent.left = z;
                else parent.right = z;
            } else {
                if (b.equals(DelType.PRED)) {
                    z = x.left;
                    if (z.right == null) x.left = z.left;
                    else {
                        do {
                            t = z;
                            z = z.right;
                        } while (z.right != null);
                        t.right = z.left;
                    }
                } else {
                    z = x.right;
                    if (z.left == null) x.right = z.right;
                    else {
                        do {
                            t = z;
                            z = z.left;
                        } while (z.left != null);
                        t.left = z.right;
                    }
                }
                x.key = z.key;
            }
        }
    }

    public TreeNode recSearch(int key, TreeNode ro, TreeNode[] prev) {
        if (ro == null) return null;
        else
            if (ro.key == key) return ro;
            else {
                prev[0] = ro;
                if (key < ro.key) return recSearch(key, ro.left, prev);
                else return recSearch(key, ro.right, prev);
            }
    }

    private int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.key;
    }

    private int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.key;
    }

}
