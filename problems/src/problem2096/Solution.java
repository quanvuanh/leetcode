package problem2096;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(10);
    root.right.left = new TreeNode(12);
    root.right.right = new TreeNode(13);

    root.right.left.left = new TreeNode(4);
    root.right.left.right = new TreeNode(6);

    root.right.right.right = new TreeNode(15);
    root.right.right.right.right = new TreeNode(2);

    Solution s = new Solution();
    String directions = s.getDirections(root, 6, 15);
    System.out.println(directions);

  }

  public String getDirections(TreeNode root, int startValue, int destValue) {
    String directionsToStart = this.search(root, "", startValue);
    String directionsToDest = this.search(root, "", destValue);

    assert directionsToStart != null;
    assert directionsToDest != null;

    int commonPathLength = 0;
    for (int i = 0; i < Math.min(directionsToStart.length(), directionsToDest.length()); i++) {
      if (directionsToStart.charAt(i) == directionsToDest.charAt(i)) {
        commonPathLength++;
        continue;
      }
      break;
    }

    StringBuilder result = new StringBuilder();
    // go up until we find the last common node
    int amountOfUps = directionsToStart.length() - commonPathLength;
    result.append("U".repeat(amountOfUps));
    // go to the target
    result.append(directionsToDest.substring(commonPathLength));

    return result.toString();
  }

  private String search(TreeNode node, String directions, int target) {
    if (node.val == target) {
      return directions;
    }

    String newDirections;
    if (node.left != null) {
      newDirections = this.search(node.left, directions + 'L', target);

      if (newDirections != null) {
        return newDirections;
      }
    }

    if (node.right != null) {
      return this.search(node.right, directions + 'R', target);
    }

    return null;
  }
}