/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to simplify edge cases, especially when the head itself needs to be swapped.
        // The dummy node will always point to the actual head of the list (or null if the list is empty).
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 'prev' pointer will track the node immediately before the pair we are currently swapping.
        // Initially, it points to the dummy node.
        ListNode prev = dummy;

        // We need at least two nodes to form a pair and swap them.
        // The loop continues as long as 'prev.next' (the first node of the potential pair) is not null,
        // AND 'prev.next.next' (the second node of the potential pair) is not null.
        while (prev.next != null && prev.next.next != null) {
            // Identify the two nodes that form the current pair to be swapped.
            ListNode firstNode = prev.next;         // The first node in the pair (e.g., node 1 in 1->2->3->4)
            ListNode secondNode = prev.next.next;   // The second node in the pair (e.g., node 2 in 1->2->3->4)

            // Store the node that comes immediately after the 'secondNode'.
            // This will be the starting point of the next pair, or null if this is the last pair.
            ListNode nextPairHead = secondNode.next; // (e.g., node 3 in 1->2->3->4)

            // Perform the swap by re-linking the pointers:

            // 1. The 'secondNode' (which will become the first of the swapped pair)
            //    should now point to the 'firstNode'.
            secondNode.next = firstNode;

            // 2. The 'firstNode' (which will become the second of the swapped pair)
            //    should now point to the 'nextPairHead' (the rest of the list).
            firstNode.next = nextPairHead;

            // 3. The 'prev' node (the node before the current pair)
            //    should now point to the 'secondNode' (which is the new head of the swapped pair).
            prev.next = secondNode;

            // Move the 'prev' pointer forward by two steps for the next iteration.
            // 'firstNode' is now the *last* node of the just-swapped pair,
            // and it correctly serves as the 'prev' for the *next* potential pair.
            prev = firstNode;
        }

        // After the loop finishes, the dummy node's next pointer will point to the head of the fully swapped list.
        return dummy.next;
    }
}