package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import adt.bst.BSTNode;

public class StudentAVLTest {

	private AVLTree<Integer> avl;
	private BSTNode<Integer> NIL = new BSTNode<Integer>();

	@Before
	public void setUp() {
		avl = new AVLTreeImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(avl.isEmpty());
		assertEquals(0, avl.size());
		assertEquals(-1, avl.height());
		assertEquals(NIL, avl.getRoot());
	}

	@Test
	public void testInsert() {
		avl.insert(-10);
		assertEquals(1, avl.size());
		assertEquals(0, avl.height());
		assertArrayEquals(new Integer[] { -10 }, avl.preOrder());

		assertFalse(avl.isEmpty());
		assertEquals(new Integer(-10), avl.getRoot().getData());

		avl.insert(-15);
		assertEquals(2, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15 }, avl.preOrder());

		avl.insert(20);
		assertEquals(3, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15, 20 }, avl.preOrder());
	}

	@Test
public void insert01() {
    avl.insert(30);
    assertEquals(1, avl.size());
    assertEquals(0, avl.height());
    assertArrayEquals(new Integer[] { 30 }, avl.preOrder());

    avl.insert(20);
    assertEquals(2, avl.size());
    assertEquals(1, avl.height());
    assertArrayEquals(new Integer[] { 30, 20 }, avl.preOrder());

    avl.insert(40);
    assertEquals(3, avl.size());
    assertEquals(1, avl.height());
    assertArrayEquals(new Integer[] { 30, 20, 40 }, avl.preOrder());

    avl.insert(10);
    assertEquals(4, avl.size());
    assertEquals(2, avl.height());
    assertArrayEquals(new Integer[] { 30, 20, 10, 40 }, avl.preOrder());
}

@Test
public void insert02() {
    avl.insert(50);
    avl.insert(25);
    avl.insert(75);
    assertEquals(3, avl.size());
    assertEquals(1, avl.height());
    assertArrayEquals(new Integer[] { 50, 25, 75 }, avl.preOrder());

    avl.insert(20);
    assertEquals(4, avl.size());
    assertEquals(2, avl.height());
    assertArrayEquals(new Integer[] { 50, 25, 20, 75 }, avl.preOrder());

    avl.insert(30);
    assertEquals(5, avl.size());
    assertEquals(2, avl.height());
    assertArrayEquals(new Integer[] { 50, 25, 20, 30, 75 }, avl.preOrder());
}

@Test
public void insert03() {
    avl.insert(15);
    avl.insert(5);
    assertEquals(2, avl.size());
    assertEquals(1, avl.height());
    assertArrayEquals(new Integer[] { 15, 5 }, avl.preOrder());

	
    avl.insert(10);
    assertEquals(3, avl.size());
    assertEquals(1, avl.height());


    assertArrayEquals(new Integer[] { 10,5,15 }, avl.preOrder());

    avl.insert(20);
    assertEquals(4, avl.size());
    assertEquals(2, avl.height());
    assertArrayEquals(new Integer[] { 10,5,15,20 }, avl.preOrder());

	AVLTreeVerifierImpl treeVerif = new AVLTreeVerifierImpl(avl);
	assertTrue(treeVerif.isAVLTree());
}

@Test
public void insert04() {
    avl.insert(100);
    avl.insert(50);
    avl.insert(150);
    assertEquals(3, avl.size());
    assertEquals(1, avl.height());
    assertArrayEquals(new Integer[] { 100, 50, 150 }, avl.preOrder());

    avl.insert(75);
    assertEquals(4, avl.size());
    assertEquals(2, avl.height());
    assertArrayEquals(new Integer[] { 100, 50, 75, 150 }, avl.preOrder());

    avl.insert(125);
    assertEquals(5, avl.size());
    assertEquals(2, avl.height());
	AVLTreeVerifierImpl treeVerif = new AVLTreeVerifierImpl(avl);
	assertTrue(treeVerif.isAVLTree());
	//System.out.println(avl.preOrder());
    assertArrayEquals(new Integer[] { 100, 50, 75, 150,125 }, avl.preOrder());
}

@Test
public void insert05() {
    avl.insert(10);
    avl.insert(20);
    avl.insert(30);
    assertEquals(3, avl.size());
    assertEquals(1, avl.height());
    assertArrayEquals(new Integer[] { 20, 10, 30 }, avl.preOrder());

    avl.insert(25);
    assertEquals(4, avl.size());
    assertEquals(2, avl.height());
    assertArrayEquals(new Integer[] { 20, 10, 30, 25 }, avl.preOrder());

    avl.insert(15);
    assertEquals(5, avl.size());
    assertEquals(2, avl.height());
    assertArrayEquals(new Integer[] {  20, 10, 15, 30, 25 }, avl.preOrder());
}


	@Test
	public void testRemove() {
		avl.insert(55);
		avl.insert(9);
		avl.insert(91);
		avl.insert(12);

		avl.remove(-1);
		assertEquals(4, avl.size());

		avl.remove(91);
		assertEquals(3, avl.size());
		assertArrayEquals(new Integer[] { 12, 9, 55 }, avl.preOrder());

		avl.remove(12);
		assertEquals(2, avl.size());
		assertArrayEquals(new Integer[] { 55, 9 }, avl.preOrder());

		avl.remove(9);
		avl.remove(55);
		assertEquals(NIL, avl.getRoot());
		assertTrue(avl.isEmpty());
	}

	@Test
public void remove01() {
    avl.insert(30);
    avl.insert(15);
    avl.insert(50);
    avl.insert(10);
    avl.insert(20);
    avl.insert(40);
    avl.insert(60);

    avl.remove(20);
    assertEquals(6, avl.size());
    assertArrayEquals(new Integer[] { 30, 15, 10, 50, 40, 60 }, avl.preOrder());

    avl.remove(10);
    assertEquals(5, avl.size());
    assertArrayEquals(new Integer[] { 30, 15, 50, 40, 60 }, avl.preOrder());
}

@Test
public void remove02() {
    avl.insert(100);
    avl.insert(50);
    avl.insert(150);
    avl.insert(25);
    avl.insert(75);
    avl.insert(125);
    avl.insert(175);

    avl.remove(100); // Remover a raiz
    assertEquals(6, avl.size());
    assertArrayEquals(new Integer[] { 125, 50, 25, 75, 150, 175 }, avl.preOrder());

    avl.remove(75);
    assertEquals(5, avl.size());
    assertArrayEquals(new Integer[] { 125, 50, 25, 150, 175 }, avl.preOrder());
}

@Test
public void remove03() {
    avl.insert(20);
    avl.insert(10);
    avl.insert(30);
    avl.insert(5);
    avl.insert(15);
    avl.insert(25);
    avl.insert(35);

    avl.remove(5);  // Remover folha
    assertEquals(6, avl.size());
    assertArrayEquals(new Integer[] { 20, 10, 15, 30, 25, 35 }, avl.preOrder());

    avl.remove(35); // Remover outra folha
    assertEquals(5, avl.size());
    assertArrayEquals(new Integer[] { 20, 10, 15, 30, 25 }, avl.preOrder());
}

@Test
public void remove04() {
    avl.insert(80);
    avl.insert(70);
    avl.insert(90);
    avl.insert(60);
    avl.insert(75);
    avl.insert(85);
    avl.insert(95);

    avl.remove(70);  // Remover nó com um filho
    assertEquals(6, avl.size());
    assertArrayEquals(new Integer[] { 80, 75, 60, 90, 85, 95 }, avl.preOrder());

    avl.remove(90);  // Remover nó com dois filhos
    assertEquals(5, avl.size());
    assertArrayEquals(new Integer[] { 80, 75, 60, 95, 85 }, avl.preOrder());
}

@Test
public void remove05() {
    avl.insert(45);
    avl.insert(20);
    avl.insert(60);
    avl.insert(10);
    avl.insert(30);
    avl.insert(50);
    avl.insert(70);

    avl.remove(45);  // Remover a raiz
    assertEquals(6, avl.size());
    assertArrayEquals(new Integer[] { 50, 20, 10, 30, 60, 70 }, avl.preOrder());

    avl.remove(60);
    assertEquals(5, avl.size());
    assertArrayEquals(new Integer[] { 50, 20, 10, 30, 70 }, avl.preOrder());
}

}
