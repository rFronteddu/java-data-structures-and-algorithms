package jdag.structures.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class TreeNode
{
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public void insert (final int value) {
        if (value == data) {
            throw new IllegalArgumentException ("Duplicates are not accepted");
        }

        var treeNode = value > data ? rightChild : leftChild;
        if (treeNode != null) {
            treeNode.insert (value);
            return;
        }

        if (value > data) {
            rightChild = new TreeNode (value, null, null);
        } else {
            leftChild = new TreeNode (value, null, null);
        }
    }

    public TreeNode get (final int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return leftChild.get (value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get (value);
            }
        }
        return null;
    }

    public void traverseInorder () {
        if (leftChild != null) {
            leftChild.traverseInorder ();
        }
        System.out.println ("Data = " + data);
        if (rightChild != null) {
            rightChild.traverseInorder ();
        }
    }

    public int min () {
        if (leftChild == null) {
            return data;
        }
        return leftChild.min ();
    }

    public int max () {
        if (rightChild == null) {
            return data;
        }
        return rightChild.max ();
    }
}
