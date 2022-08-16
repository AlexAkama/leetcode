package leetcode.solution.ready;

import leetcode.utils.TreeNode;

//
// Собрать бинарное дерево из массивов прямого обхода и неупорядоченного
// Важно!!! По условию значения уникальны, массивы гарантированно правильные
//
public class Solution0105 {

    private int pos = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createNode(preorder, inorder, 0, preorder.length - 1);
    }

    //Runtime: 3 ms, faster than 88.47% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    //Memory Usage: 42.1 MB, less than 88.53% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    private TreeNode createNode(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[pos]);
        for (int i = left; i < right + 1; i++) {
            if (preorder[pos] == inorder[i]) {
                pos++;
                node.left = createNode(preorder, inorder, left, i - 1);
                node.right = createNode(preorder, inorder, i + 1, right);
                break;
            }
        }
        return node;
    }

}
