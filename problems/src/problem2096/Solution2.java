package problem2096;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(10);
    root.right.left = new TreeNode(12);
    root.right.right = new TreeNode(13);

    root.right.left.left = new TreeNode(4);
    root.right.left.right = new TreeNode(6);

    root.right.right.right = new TreeNode(15);
    root.right.right.right.right = new TreeNode(2);

    Solution2 s = new Solution2();
    String directions = s.getDirections(root, 6, 15);
    System.out.println(directions);

  }

  public String getDirections(TreeNode root, int startValue, int destValue) {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    this.buildParentMap(root, null, parentMap);

    TreeNode startNode = this.search(root, startValue);
    TreeNode destNode = this.search(root, destValue);

    String directionsToStart = this.getPath(root, startNode, parentMap);
    String directionsToDest = this.getPath(root, destNode, parentMap);

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

  private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
    if (node != null) {
      parentMap.put(node, parent);
      this.buildParentMap(node.left, node, parentMap);
      this.buildParentMap(node.right, node, parentMap);
    }
  }

  private TreeNode search(TreeNode node, int target) {
    if (node == null || node.val == target) {
      return node;
    }
    TreeNode leftResult = this.search(node.left, target);
    if (leftResult != null) {
      return leftResult;
    }
    return this.search(node.right, target);
  }

  private String getPath(TreeNode root, TreeNode node, Map<TreeNode, TreeNode> parentMap) {
    StringBuilder path = new StringBuilder();
    while (node != root) {
      TreeNode parent = parentMap.get(node);
      if (parent.left == node) {
        path.insert(0, 'L');
      } else {
        path.insert(0, 'R');
      }
      node = parent;
    }
    return path.toString();
  }
}