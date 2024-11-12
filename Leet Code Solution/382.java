class Solution {
    private ListNode head;
    private Random random = new Random();

    public Solution(ListNode head) {
        this.head = head;    
    }
    
    public int getRandom() {
        int ans = 0, n = 0;
        for (ListNode node = head; node != null; node = node.next){
            ++n;
            int x = 1 + random.nextInt(n);
            if (n == x) {
                ans = node.val;
            }
        }
        return ans;
    }
}