package infectedbinarytree;

import java.util.*;

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

  @Override
  public String toString() {
    return String.valueOf(this.val);
  }
}

class Node {
  List<Node> neighbours;
  int val;

  Node(int val, List<Node> children) {
    this.val = val;
    this.neighbours = children;
  }

  Node(int val) {
    this(val, new ArrayList<>());
  }

  void addNeighbour(Node child) {
    this.neighbours.add(child);
  }
}

class Pair<K, V> {
  K key;
  V depth;

  Pair(K key, V depth) {
    this.key = key;
    this.depth = depth;
  }
}

/**
 * Definition for a binary tree node.
 */
class Solution {
  public int amountOfTime(TreeNode root, int start) {
    Node graph = new Node(root.val);
    Node startNode = this.constructGraph(root, graph, start);

    int depth = 0;
    Queue<Pair<Node, Integer>> queue = new ArrayDeque<>();
    queue.add(new Pair<>(startNode, 0));
    Set<Integer> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      Pair<Node, Integer> current = queue.poll();
      if (visited.contains(current.key.val)) {
        continue;
      }

      visited.add(current.key.val);
      for (Node child : current.key.neighbours) {
        queue.add(new Pair<>(child, current.depth+1));
      }
      depth = Math.max(depth, current.depth);
    }

    return depth;
  }

  private Node constructGraph(TreeNode node, Node graphNode, int start) {
    Node startNode = null;
    if (node.left != null) {
      Node neighbour = new Node(node.left.val);

      // add in both directions -> undirected graph
      graphNode.addNeighbour(neighbour);
      neighbour.addNeighbour(graphNode);

      startNode = this.constructGraph(node.left, neighbour, start);
    }

    if (node.right != null) {
      Node neighbour = new Node(node.right.val);

      // add in both directions -> undirected graph
      graphNode.addNeighbour(neighbour);
      neighbour.addNeighbour(graphNode);

      Node n = this.constructGraph(node.right, neighbour, start);
      startNode = startNode != null ? startNode : n;
    }

    return graphNode.val == start ? graphNode : startNode;
  }

  public static void main(String[] args) {
    TreeNode leaf2 = new TreeNode(5);
    TreeNode leaf1 = new TreeNode(4);
    TreeNode n3 = new TreeNode(3, leaf2, null);
    TreeNode n2 = new TreeNode(2, leaf1, null);
    TreeNode n1 = new TreeNode(1, n2, n3);
    TreeNode root = new TreeNode(0, n1, null);

    Solution s = new Solution();
    int d = s.amountOfTime(root, 4);
    System.out.println(d);
  }
}