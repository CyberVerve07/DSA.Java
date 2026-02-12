//Given a Binary Search Tree (BST) aur ek value val,
//agar node exist karti hai → us subtree ka root return karo,
//warna → null.
// Tree node definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// Solution class
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {

            if (root.val == val) {
                return root;
            }

            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }
}

// Main class (entry point)
public class Main {
    public static void main(String[] args) {

        // BST bana rahe hain
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution sol = new Solution();
        TreeNode result = sol.searchBST(root, 2);

        if (result != null) {
            System.out.println("Found node with value: " + result.val);
        } else {
            System.out.println("Value not found");
        }
    }
}

