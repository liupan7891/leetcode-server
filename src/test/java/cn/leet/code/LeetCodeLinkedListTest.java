package cn.leet.code;

import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;


/**
 * 双向链表倒置功能单元测试
 * @author pan
 * @date 2019-02-21
 * 
 */
public class LeetCodeLinkedListTest {

	/**
	* @param str
	* @return
	* @throws ParseException
	*/
	@Test
	public void testReverse() {
		 //初始化双向链表1,2,3
		LeetCodeLinkedList<Integer> dlist = new LeetCodeLinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);

        }};
        
		System.out.println("双向链表倒置前: "+result( dlist));
		dlist.reverse();
		
		String res = result(dlist);
		System.out.println("双向链表倒置后: "+res);
		
		//断言结果是输入结果的倒置顺序
		Assert.assertTrue(res.trim().equals("3 2 1"));
	}
	
	/**
	*循环打印结果
	* @param plist
	* @return String
	*/
	public static String result(LeetCodeLinkedList plist) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = plist.iterator();
        
        // 3. 循环显示
        while(it.hasNext()) {
            sb.append(String.format("%s ", it.next()));
        }
        return sb.toString();
    }

}
