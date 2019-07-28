package org.prolobjectlink.db.prolog;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class LinkedListTest extends CollectionTest {

	private PrologLinkedList<Integer> list = new PrologLinkedList<Integer>(
			Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine));

	@Test
	public final void testHashCode() {

		assertEquals(
				new PrologLinkedList<Integer>(Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine))
						.hashCode(),
				list.hashCode());

	}

	@Test
	public final void testIsEmpty() {

		assertTrue(new PrologLinkedList<Object>().isEmpty());
		assertFalse(list.isEmpty());

	}

	@Test
	public final void testToString() {
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
	}

	@Test
	public final void testEquals() {
		assertEquals(new PrologLinkedList<Integer>(
				Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine)), list);
	}

	@Test
	public final void testClear() {
		list.clear();
		assertEquals(new PrologLinkedList<Integer>(), list);
		assertEquals(0, list.size());
	}

	@Test
	public final void testSize() {
		System.out.println(new PrologLinkedList<Object>());
		assertEquals(0, new PrologLinkedList<Object>().size());
		assertEquals(10, list.size());

	}

	@Test
	public final void testContains() {

		assertTrue(list.contains(zero));
		assertTrue(list.contains(one));
		assertTrue(list.contains(two));
		assertTrue(list.contains(three));
		assertTrue(list.contains(four));
		assertTrue(list.contains(five));
		assertTrue(list.contains(six));
		assertTrue(list.contains(seven));
		assertTrue(list.contains(eight));
		assertTrue(list.contains(nine));

		list = new PrologLinkedList<Integer>();
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}

		for (int i = 0; i < 10000; i++) {
			list.contains(i);
		}

	}

	@Test
	public final void testContainsAll() {

		assertTrue(list.containsAll(

				Arrays.asList(

						zero, one, two, three, four, five, six, seven, eight, nine

				)

		));
	}

	@Test
	public final void testRemove() {

		assertTrue(list.remove(zero));
		assertTrue(list.remove(two));
		assertTrue(list.remove(four));
		assertTrue(list.remove(six));
		assertTrue(list.remove(eight));

		assertArrayEquals(new Integer[] { one, three, five, seven, nine }, list.toArray(new Integer[0]));

	}

	@Test
	public final void testRetainAll() {

		assertTrue(list.retainAll(Arrays.asList(one, three, five, seven, nine)));
		assertArrayEquals(new Integer[] { one, three, five, seven, nine }, list.toArray(new Integer[0]));

	}

	@Test
	public final void testRemoveAll() {

		assertTrue(list.removeAll(Arrays.asList(zero, two, four, six, eight)));
		assertArrayEquals(new Integer[] { one, three, five, seven, nine }, list.toArray(new Integer[0]));

	}

	@Test
	public final void testIterator() {

		Iterator<Integer> iterator = list.iterator();

		int number = 0;
		for (; iterator.hasNext();) {
			Integer prologInteger = (Integer) iterator.next();
			assertEquals(new Integer(number++), prologInteger);
		}

	}

	@Test
	public final void testToArrayTArray() {
		assertArrayEquals(new Integer[] { zero, one, two, three, four, five, six, seven, eight, nine },
				list.toArray(new Integer[0]));
	}

	@Test
	public final void testToArray() {
		assertArrayEquals(new Integer[] { zero, one, two, three, four, five, six, seven, eight, nine }, list.toArray());
	}

	@Test
	public final void testAddO() {

		PrologLinkedList<Integer> integers = new PrologLinkedList<Integer>();

		assertTrue(integers.add(one));
		assertArrayEquals(new Integer[] { one }, integers.toArray(new Integer[0]));

		assertTrue(integers.add(three));
		assertArrayEquals(new Integer[] { one, three }, integers.toArray(new Integer[0]));

		assertTrue(integers.add(five));
		assertArrayEquals(new Integer[] { one, three, five, }, integers.toArray(new Integer[0]));

		assertTrue(integers.add(seven));
		assertArrayEquals(new Integer[] { one, three, five, seven }, integers.toArray(new Integer[0]));

		assertTrue(integers.add(nine));
		assertArrayEquals(new Integer[] { one, three, five, seven, nine }, integers.toArray(new Integer[0]));

	}

	@Test
	public final void testAddAll() {

		PrologLinkedList<Integer> integers = new PrologLinkedList<Integer>();
		assertTrue(integers.addAll(list));
		assertEquals(list, integers);

	}

	@Test
	public final void testAddAllCollectionOfQextendsO() {

		PrologLinkedList<Integer> integers = new PrologLinkedList<Integer>();
		assertTrue(integers.addAll(Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine)));
		assertEquals(10, integers.size());
		assertEquals(list, integers);

	}

	@Test
	public final void testGet() {

		assertEquals(zero, list.get(0));
		assertEquals(one, list.get(1));
		assertEquals(two, list.get(2));
		assertEquals(three, list.get(3));
		assertEquals(four, list.get(4));
		assertEquals(five, list.get(5));
		assertEquals(six, list.get(6));
		assertEquals(seven, list.get(7));
		assertEquals(eight, list.get(8));
		assertEquals(nine, list.get(9));

	}

	@Test
	public final void testSet() {

		PrologLinkedList<Integer> integers = new PrologLinkedList<Integer>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));

		assertEquals(nine, integers.set(0, zero));
		assertEquals(eight, integers.set(1, one));
		assertEquals(seven, integers.set(2, two));
		assertEquals(six, integers.set(3, three));
		assertEquals(five, integers.set(4, four));
		assertEquals(four, integers.set(5, five));
		assertEquals(three, integers.set(6, six));
		assertEquals(two, integers.set(7, seven));
		assertEquals(one, integers.set(8, eight));
		assertEquals(zero, integers.set(9, nine));

		assertEquals(list, integers);

	}

	@Test
	public final void testAddIntO() {

		PrologLinkedList<Integer> integers = new PrologLinkedList<Integer>();

		integers.add(0, zero);
		integers.add(1, one);
		integers.add(2, two);
		integers.add(3, three);
		integers.add(4, four);
		integers.add(5, five);
		integers.add(6, six);
		integers.add(7, seven);
		integers.add(8, eight);
		integers.add(9, nine);

		assertEquals(list, integers);

	}

	@Test
	public final void testAddAllIntCollectionOfQextendsO() {

		PrologLinkedList<Integer> integers = new PrologLinkedList<Integer>(Arrays.asList(zero, one, eight, nine));
		assertTrue(integers.addAll(2, Arrays.asList(two, three, four, five, six, seven)));
		assertEquals(list, integers);

	}

	@Test
	public final void testRemoveInt() {

		assertEquals(zero, list.remove(0));
		assertEquals(two, list.remove(1));
		assertEquals(four, list.remove(2));
		assertEquals(six, list.remove(3));
		assertEquals(eight, list.remove(4));

		assertArrayEquals(new Integer[] { one, three, five, seven, nine }, list.toArray(new Integer[0]));

	}

	@Test
	public final void testIndexOf() {

		PrologLinkedList<Integer> list = new PrologLinkedList<Integer>(

				Arrays.asList(

						one, two, three, four, nine, five, six, seven, eight, nine, five, one

				)

		);

		assertEquals(0, list.indexOf(one));
		assertEquals(5, list.indexOf(five));
		assertEquals(1, list.indexOf(two));
		assertEquals(4, list.indexOf(nine));

	}

	@Test
	public final void testLastIndexOf() {

		PrologLinkedList<Integer> list = new PrologLinkedList<Integer>(

				Arrays.asList(

						one, two, three, four, nine, five, six, seven, eight, nine, five, one

				)

		);

		assertEquals(0, list.indexOf(one));
		assertEquals(11, list.lastIndexOf(one));

		assertEquals(5, list.indexOf(five));
		assertEquals(10, list.lastIndexOf(five));

		assertEquals(4, list.indexOf(nine));
		assertEquals(9, list.lastIndexOf(nine));

	}

	@Test
	public final void testListIterator() {

		ListIterator<Integer> iterator = list.listIterator();

		int number = 0;
		for (; iterator.hasNext();) {
			Integer prologInteger = (Integer) iterator.next();
			assertEquals(new Integer(number++), prologInteger);
		}

	}

	@Test
	public final void testListIteratorInt() {

		ListIterator<Integer> iterator = list.listIterator(5);

		int number = 5;
		for (; iterator.hasNext();) {
			Integer prologInteger = (Integer) iterator.next();
			assertEquals(new Integer(number++), prologInteger);
		}
	}

	@Test
	public final void testSubList() {
		assertArrayEquals(new Integer[] { zero, one, two, three, four, five, six, seven, eight, nine },
				list.subList(0, list.size()).toArray(new Integer[0]));
		assertArrayEquals(new Integer[] { two, three, four, five, six, seven },
				list.subList(2, 8).toArray(new Integer[0]));
		assertEquals(10, list.subList(0, list.size()).size());
		assertEquals(6, list.subList(2, 8).size());

	}

	@Test
	public void testSetElement() {
		PrologLinkedList<Integer> list = new PrologLinkedList<Integer>();
		assertNull(list.getElement());
		list.setElement(_one);
		assertNotNull(list.getElement());
		assertEquals(_one, list.getElement());
	}

	@Test
	public void testGetElement() {
		PrologLinkedList<Integer> list = new PrologLinkedList<Integer>();
		assertNull(list.getElement());
		list.setElement(_one);
		assertNotNull(list.getElement());
		assertEquals(_one, list.getElement());
	}

	@Test
	public void testSetNext() {
		PrologLinkedList<Integer> list = new PrologLinkedList<Integer>();
		PrologLinkedList<Integer> next = new PrologLinkedList<Integer>();
		assertNull(list.getNext());
		list.setNext(next);
		assertNotNull(list.getNext());
		assertEquals(next, list.getNext());
	}

	@Test
	public void testGetNext() {
		PrologLinkedList<Integer> list = new PrologLinkedList<Integer>();
		PrologLinkedList<Integer> next = new PrologLinkedList<Integer>();
		assertNull(list.getNext());
		list.setNext(next);
		assertNotNull(list.getNext());
		assertEquals(next, list.getNext());
	}

}
