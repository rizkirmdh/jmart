package com.RizkiRamadhanJmartPK;

/**
 * Class ini berfungsi untuk menyediakan method predicate
 */

@FunctionalInterface
public interface Predicate<T>{
	boolean predicate(T arg);
}

