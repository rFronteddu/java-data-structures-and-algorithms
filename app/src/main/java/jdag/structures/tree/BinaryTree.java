package jdag.structures.tree;

public class BinaryTree
{
    private TreeNode root;

    public void insert (final int value) {
        if (root == null) {
            root = new TreeNode (value, null, null);
        } else {
            root.insert (value);
        }
    }

    public void delete (final int value) {
        // three cases: node is a leaf, node has one child, node has two children
        root = delete (root, value);
    }

    public TreeNode get (final int value) {
        if (root == null) {
            return null;
        }
        return root.get (value);
    }

    public int min () {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return root.min ();
    }

    public int max () {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return root.max ();
    }

    public void traverseInorder () {
        if (root != null) {
            root.traverseInorder ();
        }
    }

    private TreeNode delete (final TreeNode subtreeRoot, final int value) {
        if (subtreeRoot == null) {
            return null;
        }

        if (value < subtreeRoot.getData ()) {
            subtreeRoot.setLeftChild (delete (subtreeRoot.getLeftChild (), value));
        } else if (value > subtreeRoot.getData ()) {
            subtreeRoot.setRightChild (delete (subtreeRoot.getRightChild (), value));
        } else {
            // 0 or 1 child
            if (subtreeRoot.getLeftChild () == null) {
                // either it has no child, or the leaf will become the right child
                return subtreeRoot.getRightChild ();
            } else if (subtreeRoot.getRightChild () == null) {
                // either it has no child, or the leaf will become the left child
                return subtreeRoot.getLeftChild ();
            }

            // node to delete has 2 children
            // replace subtree value with the smallest value in the right subtree, then remove the value from the subtree
            subtreeRoot.setData (subtreeRoot.getRightChild ().min ());
            subtreeRoot.setRightChild (delete(subtreeRoot.getRightChild (), subtreeRoot.getData ()));
        }
        // No children
        return subtreeRoot;
    }
}
