/**
 * 
 */
package algorithm.code;

import org.junit.Test;

/**
 * @author lyx
 * @date 2019年5月28日
 *   
 */
public class LinkedTwoNumberSum {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		System.out.println(addTwoNumbers2(l1, l2));
		System.out.println(l1);
		System.out.println(l2);
	}
	
	@Test
	public void addTwoNumbers(){
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		System.out.println(addTwoNumbers(l1, l2));
	}
	
	@Test
	public void addTwoNumbers2(){
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		System.out.println(addTwoNumbers(l1, l2));
		
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int a,b,sum,c = 0;//c:进位
		ListNode l11 = l1, l22 = l2, l3 = null, l33 = null;
		do {
			a=0;b=0;
			if (l11 != null) {
				a = l11.val;
			}
			if (l22 != null) {
				b = l22.val;
			}
			sum = a+b+c;
			c = sum/10;
			if (l3 == null) {
				l33 = new ListNode(sum%10);
				l3 = l33;
			}else {
				l33.next = new ListNode(sum%10);
				l33 = l33.next;
			}
			
			if (l11 != null ) {
				l11 =l11.next;
			}
			if (l22 != null ) {
				l22 =l22.next;
			}
			
		} while (l11 != null || l22 != null || c != 0);
		return l3;    
	}
	
	/**
	 * 官方解法 原理是链表
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		int a,b,sum;
		int c = 0;//c:进位
		ListNode l11 = l1, l22 = l2;
		
		ListNode l3 = new ListNode(0);//设置初始值，保证不为空，最终返回的链表
		ListNode l33 = l3;//设置next使用的节点
		while (l11 != null || l22 != null) {
			a=0;b=0;
			if (l11 != null) {
				a = l11.val;
			}
			if (l22 != null) {
				b = l22.val;
			}
			sum = a+b+c;
			c = sum/10;
			l33.next = new ListNode(sum%10);//设置下个节点的值
			l33 = l33.next;//将下一个节点设置为当前节点
			if (l11 != null ) {
				l11 =l11.next;
			}
			if (l22 != null ) {
				l22 =l22.next;
			}
		}
		if (c > 0) {
			l33.next = new ListNode(c);//判断进位是否大于1
	    }
		return l3.next;    //抛弃掉第一个0值
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = "";
		ListNode l1 = this;
		do {
			string += l1.val +",";
		} while ((l1 = l1.next) != null);
		
	
		return string;
	}
}
