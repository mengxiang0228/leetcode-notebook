package N159;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 1233. 删除子文件夹
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * @author lyx 
 * @date 2019年11月26日 上午11:05:12 
 *
 */
public class Q1233 {
	@Test
	public void test() {
//		String[] coordinates = {"/a/b","/a","/c/d","/c/d/e","/c/f"};
		String[] coordinates =  {"/a/b/c","/a/b/d","/a/b/ca"};
		System.out.println(removeSubfolders(coordinates));
		assertEquals(removeSubfolders(coordinates).size(), 3);
	}
	
	public List<String> removeSubfolders(String[] folder) {
		Arrays.sort(folder);
		for (int i = 0; i < folder.length; i++) {
			String string = folder[i];
			if(string != null) {
				getSubFolder(folder, string+"/", i+1);
			}
		}
		List<String> list = new ArrayList<String>();
		for (String string : folder) {
			if(string != null) {
				list.add(string);
			}
		}
		return list;
    }
	
	/**
	 * 获取子文件夹，并将子文件夹置null
	 * @param folder
	 * @param compareString
	 */
	public void getSubFolder(String[] folder, String compareString, int startIndex) {
		for (int i = startIndex; i < folder.length; i++) {
			String string = folder[i]+"/";
			if(string != null && string.startsWith(compareString)) {
				folder[i] = null;
			}else {
				return;
			}
		}
		
	}
}
