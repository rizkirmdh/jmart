package com.RizkiRamadhanJmartPK;

import java.util.*;
import java.lang.Iterable;

/**
 * Class ini berfungsi untuk melakukan perhitungan sesuai algoritma
 * seperti count, find, findIndex, collect, paginate, exists,
 * max, dan min
 */

public class Algorithm
{
	private Algorithm() {}

	public static <T> int count(T[] array, T value)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return count(it, value);
	}
	public static <T> int count(Iterable<T> iterable, T value)
	{
		final Iterator<T> it = iterable.iterator();
		return count(it, value);
	}
	public static <T> int count(Iterator<T> iterator, T value)
	{
		final Predicate<T> pred = value::equals;
		return count(iterator, pred);
	}
	public static <T> int count(T[] array, Predicate<T> pred)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return count(it, pred);
	}
	public static <T> int count(Iterable<T> iterable, Predicate<T> pred)
	{
		final Iterator<T> it = iterable.iterator();
		return count(it, pred);
	}
	public static <T> int count(Iterator<T> iterator, Predicate<T> pred)
	{
		int count = 0;
		while (iterator.hasNext())
			if (pred.predicate(iterator.next()))
				++count;
		return count;
	}

	public static <T> T find(T[] array, T value)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return find(it, value);
	}
	public static <T> T find(Iterable<T> iterable, T value)
	{
		final Iterator<T> it = iterable.iterator();
		return find(it, value);
	}
	public static <T> T find(Iterator<T> iterator, T value)
	{
		final Predicate<T> pred = value::equals;
		return find(iterator, pred);
	}
	public static <T> T find(T[] array, Predicate<T> pred)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return find(it, pred);
	}
	public static <T> T find(Iterable<T> iterable, Predicate<T> pred)
	{
		final Iterator<T> it = iterable.iterator();
		return find(it, pred);
	}
	public static <T> T find(Iterator<T> iterator, Predicate<T> pred)
	{
		while (iterator.hasNext())
		{
			T current = iterator.next();
			if (pred.predicate(current))
				return current;
		}
		return null;
	}

	public static <T> int findIndex(T[] array, T value)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return findIndex(it, value);
	}
	public static <T> int findIndex(Iterable<T> iterable, T value)
	{
		final Iterator<T> it = iterable.iterator();
		return findIndex(it, value);
	}
	public static <T> int findIndex(Iterator<T> iterator, T value)
	{
		final Predicate<T> pred = value::equals;
		return findIndex(iterator, pred);
	}
	public static <T> int findIndex(T[] array, Predicate<T> pred)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return findIndex(it, pred);
	}
	public static <T> int findIndex(Iterable<T> iterable, Predicate<T> pred)
	{
		final Iterator<T> it = iterable.iterator();
		return findIndex(it, pred);
	}
	public static <T> int findIndex(Iterator<T> iterator, Predicate<T> pred)
	{
		for (int i = 0; iterator.hasNext(); ++i)
			if (pred.predicate(iterator.next()))
				return i;
		return -1;
	}

	public static <T> List<T> collect(T[] array, T value)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return collect(it, value);
	}
	public static <T> List<T> collect(Iterable<T> iterable, T value)
	{
		final Iterator<T> it = iterable.iterator();
		return collect(it, value);
	}
	public static <T> List<T> collect(Iterator<T> iterator, T value)
	{
		final Predicate<T> pred = value::equals;
		return collect(iterator, pred);
	}
	public static <T> List<T> collect(T[] array, Predicate<T> pred)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return collect(it, pred);
	}
	public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
	{
		final Iterator<T> it = iterable.iterator();
		return collect(it, pred);
	}
	public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
	{
		ArrayList<T> list = new ArrayList<>();
		while (iterator.hasNext())
		{
			T current = iterator.next();
			if (pred.predicate(current))
				list.add(current);
		}
		return list;
	}

	public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return paginate(it, page, pageSize, pred);
	}
	public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred)
	{
		final Iterator<T> it = iterable.iterator();
		return paginate(it, page, pageSize, pred);
	}
	public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred)
	{
		int occurences = 0;
		int startingIdx = page * pageSize;
		List<T> pageList = new ArrayList<>(pageSize);
		// skip first occurrences of element
		while (iterator.hasNext() && occurences < startingIdx)
		{
			T obj = iterator.next();
			if (pred.predicate(obj))
				++occurences;
		}
		// get the next occurrences of element
		while (iterator.hasNext() && pageList.size() < pageSize)
		{
			T obj = iterator.next();
			if (pred.predicate(obj))
				pageList.add(obj);
		}
		return pageList;
	}


	public static <T> boolean exists(T[] array, T value)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return exists(it, value);
	}
	public static <T> boolean exists(Iterable<T> iterable, T value)
	{
		final Iterator<T> it = iterable.iterator();
		return exists(it, value);
	}
	public static <T> boolean exists(Iterator<T> iterator, T value)
	{
		final Predicate<T> pred = value::equals;
		return exists(iterator, pred);
	}
	public static <T> boolean exists(T[] array, Predicate<T> pred)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return exists(it, pred);
	}
	public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred)
	{
		final Iterator<T> it = iterable.iterator();
		return exists(it, pred);
	}
	public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred)
	{
		while (iterator.hasNext())
		{
			T current = iterator.next();
			if (pred.predicate(current))
				return true;
		}
		return false;
	}

	public static <T extends Comparable<? super T>> T max(T first, T second)
	{
		if (first.compareTo(second) > 0) return first;
		return second;
	}
	public static <T extends Comparable<? super T>> T max(T[] array)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return max(it);
	}
	public static <T extends Comparable<? super T>> T max(Iterable<T> iterable)
	{
		final Iterator<T> it = iterable.iterator();
		return max(it);
	}
	public static <T extends Comparable<? super T>> T max(Iterator<T> iterator)
	{
		T biggest = null;
		while (iterator.hasNext() && biggest == null)
			biggest = iterator.next();
		while (iterator.hasNext())
		{
			T next = iterator.next();
			if (next == null) continue;
			biggest = max(biggest, next);
		}
		return biggest;
	}
	public static <T> T max(T first, T second, Comparator<? super T> comparator)
	{
		if (comparator.compare(first, second) > 0) return first;
		return second;
	}
	public static <T> T max(T[] array, Comparator<? super T> comparator)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return max(it, comparator);
	}
	public static <T> T max(Iterable<T> iterable, Comparator<? super T> comparator)
	{
		final Iterator<T> it = iterable.iterator();
		return max(it, comparator);
	}
	public static <T> T max(Iterator<T> iterator, Comparator<? super T> comparator)
	{
		T biggest = null;
		while (iterator.hasNext() && biggest == null)
			biggest = iterator.next();
		while (iterator.hasNext())
		{
			T next = iterator.next();
			if (next == null) continue;
			biggest = max(biggest, next, comparator);
		}
		return biggest;
	}

	public static <T extends Comparable<? super T>> T min(T first, T second)
	{
		if (first.compareTo(second) < 0) return first;
		return second;
	}
	public static <T extends Comparable<? super T>> T min(T[] array)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return min(it);
	}
	public static <T extends Comparable<? super T>> T min(Iterable<T> iterable)
	{
		final Iterator<T> it = iterable.iterator();
		return min(it);
	}
	public static <T extends Comparable<? super T>> T min(Iterator<T> iterator)
	{
		T lowest = null;
		while (iterator.hasNext() && lowest == null)
			lowest = iterator.next();
		while (iterator.hasNext())
		{
			T next = iterator.next();
			if (next == null) continue;
			lowest = min(lowest, next);
		}
		return lowest;
	}
	public static <T> T min(T first, T second, Comparator<? super T> comparator)
	{
		if (comparator.compare(first, second) < 0) return first;
		return second;
	}
	public static <T> T min(T[] array, Comparator<? super T> comparator)
	{
		final Iterator<T> it = Arrays.stream(array).iterator();
		return min(it, comparator);
	}
	public static <T> T min(Iterable<T> iterable, Comparator<? super T> comparator)
	{
		final Iterator<T> it = iterable.iterator();
		return min(it, comparator);
	}
	public static <T> T min(Iterator<T> iterator, Comparator<? super T> comparator)
	{
		T lowest = null;
		while (iterator.hasNext() && lowest == null)
			lowest = iterator.next();
		while (iterator.hasNext())
		{
			T next = iterator.next();
			if (next == null) continue;
			lowest = min(lowest, next, comparator);
		}
		return lowest;
	}
}


























