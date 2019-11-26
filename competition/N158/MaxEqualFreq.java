package N158;

import static org.junit.Assert.assertEquals;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 1224. 最大相等频率
给出一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回其长度
 * 
 * @author lyx 
 * @date 2019年11月1日 上午11:04:16 
 *
 */
public class MaxEqualFreq {

	@Test
	public void maxEqualFreqTest() {
		int[] list = {2,2,1,1,5,3,3,5}; 
		assertEquals(maxEqualFreq(list), 7);
	}
	
    public int maxEqualFreq(int[] nums) {
    	//FIMXE 没明白
    	Map<Integer,Integer> val2Freq=new HashMap<>();// 数字的频率
        Map<Integer,Integer> frq2ffrq=new HashMap<>();// 频率的频率
        int length = 0;
        int val  = 0;
    	for (int i = 0; i < nums.length; i++) {
    		val = nums[i];
    		int newFrq= addMap(val2Freq,val,1);
    		int oldFrq = newFrq -1;
    		// 从原有频率次数map中移除
    		if(oldFrq != 0) {
    			addMap(frq2ffrq, oldFrq, -1);
    		}
    		
			addMap(frq2ffrq,newFrq,1);
			if(frq2ffrq.size() == 2) {
				ArrayList<Integer> vals= new ArrayList<>(frq2ffrq.keySet());
	            int a=vals.get(0);
                int b=vals.get(1);
	            if(a >b) {
	            	int tmp=a;
	                a=b;
	                b=tmp;
	            }
	            if(a == 1 && frq2ffrq.get(a) == 1) {
	            	length = i;
	            }else if (b-a == 1 && frq2ffrq.get(b)==1) {
	            	length = i;
	            }
	
			}else if (frq2ffrq.size()==1) {
				 int key=new ArrayList<>(frq2ffrq.keySet()).get(0);
				 if (key == 1 || frq2ffrq.get(key)==1) {
					 length = i;
				}
			}
		}
		return length+1;
    }
    
    private int addMap(Map<Integer, Integer> val2Freq, int key, int val) {
        if(val2Freq.containsKey(key)){
            val=val2Freq.get(key)+val;
            val2Freq.put(key,val);
        }else {
            val2Freq.put(key,val);
        }
        if(val==0){
            val2Freq.remove(key);
        }
        return val;
    }

}
