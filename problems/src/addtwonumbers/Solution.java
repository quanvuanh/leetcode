package addtwonumbers;

import java.util.Stack;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

/**
 * Definition for singly-linked list.
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode left = l1;
    ListNode right = l2;
    ListNode current = result;
    int carry = 0;
    while (true) {
      int leftValue = left == null ? 0 : left.val;
      int rightValue = right == null ? 0 : right.val;
      int sum = leftValue + rightValue + carry;

      current.val = sum % 10;
      carry = sum > 9 ? 1 : 0;

      if (left != null) {
        left = left.next;
      }
      if (right != null) {
        right = right.next;
      }

      if (left == null && right == null && carry == 0) {
        break;
      }

      current.next = new ListNode();
      current = current.next;
    }

    return result;
  }
}

