//143. Reorder List - https://leetcode.com/problems/reorder-list/
// time = mid - O(n/2) + reverse O(n/2) + merge O(n) - O(n)
// space = O(n/2)
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){this.next = next;}
}

class solution{
    public void reorderList(ListNode head){
        ListNode mid = getMid(head);
        ListNode reverseList = getReverseList(mid);
        merge(head, reverseList);
    }

    private void merge(ListNode list1, ListNode list2){
        ListNode temp;
        while(list2.next != null){
            temp = list1.next;
            list1.next = list2;
            list1 = temp;

            temp = list2.next;
            list2.next = list1;
            list2 = temp;
        }
    }

    private ListNode getReverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode tail = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tail;
        }
        return prev;
    }

    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
