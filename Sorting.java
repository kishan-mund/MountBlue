import java.util.*;
public class Sorting {
	public static void main(String[] args) {
		int array[] = { 2,3,1, 4, 2, 2,3,5,3,2,7,7,8, 1, 6, 7, 5 };
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> outputArray = new ArrayList<>();
		for (int current : array) {
			int count = map.getOrDefault(current, 0);
			map.put(current, count + 1);
			outputArray.add(current);
		}
		SortComparator comp = new SortComparator(map);
		Collections.sort(outputArray, comp);
		for (Integer i : outputArray) {
			System.out.print(i + " ");
		}
	}
}
class SortComparator implements Comparator<Integer> {
	private final Map<Integer, Integer> freqMap;
	SortComparator(Map<Integer, Integer> tFreqMap) {
		this.freqMap = tFreqMap;
	}
	@Override
	public int compare(Integer k1, Integer k2) {

		int freqCompare = freqMap.get(k1).compareTo(freqMap.get(k2));
		int valueCompare = k1.compareTo(k2);
		if (freqCompare == 0)
			return valueCompare;
		else
			return freqCompare;
	}
}
