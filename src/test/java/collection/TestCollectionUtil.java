package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import weix.collection.CollectionUtil;;

public class TestCollectionUtil {

	public static void main(String[] args) {

		List<Integer> sourceList = new ArrayList<Integer>();
		Collections.addAll(sourceList, 1,2,3,4,5,6,7,8,9);
		List<List<Integer>> newLists = CollectionUtil.splitList(sourceList, 3);
		for(List<Integer> list : newLists){
			System.out.println(list);
		}
		
	}

}
