package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample
{
	public static void getMap(Map<Integer, String> map)
	{
		Set<Integer> set = map.keySet();
		Iterator<Integer> iterator=set.iterator();
		while(iterator.hasNext())
		{
			Integer num = iterator.next();
			
			if(num >= 80) {
				String value = map.get(num);
				System.out.println(value);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Map<Integer, String> scores = new HashMap<>();
		scores.put(90, "Hong");
		scores.put(80, "Tong");
		scores.put(70, "Yong");
		scores.put(60, "Jong");
		scores.put(50, "Kong");
		System.out.println("80 이상인 사람");
		System.out.println("=============");
		getMap(scores);
		System.out.println("=============");
		
		
		List<String> list = new ArrayList<>();
		list.add("Hong");
		list.add("Hwang");

		Set<String> set = new HashSet<>();
		set.add("Hong");
		set.add("Hwang");
		Iterator<String> iterator = set.iterator(); // 반복자(iterator)
		while (iterator.hasNext()) // iterator에 set되있는걸 체크하는 hasnext
		{
			String str = iterator.next();
			System.out.println(str.toString());
		}

		Map<String, Integer> map = new HashMap<>();
		// key:value -> Map.Entry
		map.put("Hong", 98); // (key(String), value(Integer))
		map.put("Hwang", 90);
		map.put("Son", 70);
		map.put("Hong", 80); // 키값에 같은 hong을 넣게되면 밸류값이 덮어져버림 뒤에 쓰는걸로
		// 키값만 가지고오는
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while (keyIterator.hasNext())
		{
			String key = keyIterator.next();
			Integer value = map.get(key); // key에  해당되는 value값을 리턴해줌
			System.out.println("key :"+key+" value: "+value);
		}
		
		
		Set<Entry<String, Integer>> entrySet =  map.entrySet();
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext())
		{
			Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key :"+key+" value: "+value);
		}
	}
}
