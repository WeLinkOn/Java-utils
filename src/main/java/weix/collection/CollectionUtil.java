package weix.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 一些关于Java Collection 操作的工具类
 * @author Liu.Weibing
 * @date 2017年10月6日
 */
public class CollectionUtil {

	/**
	 * 将给定的源List<T>按顺序分割为相等的n个新List<T>，并放入新的List&lt;List<T>&gt;中返回。
	 * 注意：该方法会将源List<T>进行等分，如果传入的参数n不能整除List<T>的长度，则抛出异常
	 * @param <T>			满足泛型
	 * @param sourceList	源List<T>
	 * @param n				要分割为新List<T>的个数，
	 * @return				存储等分后子List<T>的List
	 * @throws RuntimeException	如果n不是正整数或n不能整除List<T>的长度时抛出运行时异常
	 */
	public static  <T> List<List<T>> splitList(List<T> sourceList, int n) throws RuntimeException{
		
		int unitSize = 0;	//等分后的每个新List的长度
		
		if(sourceList.size() == 0){
			throw new RuntimeException("源List<T>元素不能为空") ;
		} else if(n <= 0){
			throw new RuntimeException("份数n必须为正整数") ;
		} else if(sourceList.size() < n){
			throw new RuntimeException("源List<T>长度不能小于份数n") ;
		} else if(sourceList.size() % n != 0){
			throw new RuntimeException(sourceList.getClass().getName() + ": 不能被等分为" + n + "个List") ;
		} else {
			unitSize = sourceList.size() / n;
		}
		
		//分割后装入该列表后返回
		List<List<T>> newLists = new ArrayList<List<T>>();
		
		for(int i = 0; i < n; i++){
			
			List<T> newList = new ArrayList<T>();
			
			//从源列表的第一个元素开始遍历分割，每单元长度的元素放入新列表
			for(int j = i*unitSize; j < (i+1)*unitSize; j++){
				newList.add(sourceList.get(j));
			}
			
			newLists.add(newList);
		}
		
		return newLists;
	}

	/**
	 * 利用Set的元素“不可重复性”去除一个List<T>中的重复元素，并返回去重后的新List<T>
	 * 为保证去重后的元素顺序与源List<T>保持一直，该方法使用TreeSet
	 * @param sourList	源List<T>
	 * @return			去重后的新List<T>
	 */
	public static <T> List<T> removeDuplicate(List<T> sourList){
		return new ArrayList<T>(new TreeSet<T>(sourList));
	}
	//Some other simple but useful utils of Java basic operations
}
