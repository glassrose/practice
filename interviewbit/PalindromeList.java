import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class PalindromeList {
    public int lPalin(ListNode A) {
        if (islPalin(A)) return 1; else return 0;
    }
    
    private boolean islPalin(ListNode A) {
        // int len = 0;
        ArrayList<Integer> al = new ArrayList<>();
        while (A!=null) {
            // len++;
            al.add(A.val);
            A = A.next;
        }
        
        int len = al.size();
        boolean isPalin = true;
        for (int i=0; i<len/2; i++) {
            if (al.get(i).equals(al.get(len-1-i))) {
                continue;
            }
            else {
                isPalin = false;
                break;
            }
        }
        
        return isPalin;
        
    }

	public static void main (String args[]) {
		ListNode listHead = new ListNode(1);
		listHead.next = new ListNode(2);
		listHead.next.next = new ListNode(3);
		listHead.next.next.next   = new ListNode(2);
		listHead.next.next.next.next    = new ListNode(1);
		PalindromeList o = new PalindromeList();
		System.out.println (o.lPalin(listHead));
	}

}


class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

