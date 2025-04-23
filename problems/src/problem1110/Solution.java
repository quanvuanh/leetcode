package problem1110;

import common.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class Solution {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

//    root.left.left = new TreeNode(4);
//    root.left.right = new TreeNode(5);
//
//    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(4);

    Solution s = new Solution();
    List<TreeNode> roots = s.delNodes(root, new int[]{2, 1});

    System.out.println(roots);
  }

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> nodesToDelete = new HashSet<>();
    for (int e : to_delete) {
      nodesToDelete.add(e);
    }
    List<TreeNode> result = new ArrayList<>();
    if (!nodesToDelete.contains(root.val)) {
      result.add(root);
    }

    this.traverse(root, nodesToDelete, result);

    return result;
  }

  private TreeNode traverse(
    TreeNode node,
    Set<Integer> toDelete,
    List<TreeNode> result
  ) {
    if (node.left != null) {
      node.left = this.traverse(node.left, toDelete, result);
    }

    if (node.right != null) {
      node.right = this.traverse(node.right, toDelete, result);
    }

    if (toDelete.contains(node.val)) {
      // add new roots to result
      if (node.left != null) {
          result.add(node.left);
      }
      if (node.right != null) {
        result.add(node.right);
      }

      return null;
    }

    return node;
  }
}
