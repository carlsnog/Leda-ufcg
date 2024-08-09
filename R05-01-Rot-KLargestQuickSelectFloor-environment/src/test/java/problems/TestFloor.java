package problems;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class TestFloor {
    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
    private Integer[] vetorDesordenado;

	public Floor implementation;

	@Before
	public void setUp() {
		vetorTamPar = new Integer[] { -15, 9, 78, 150, 645, 1000};
		vetorTamImpar = new Integer[] { 0, 2, 4, 20, 21, 25, 29, 30, 31 };
        vetorDesordenado = new Integer[] {5, 9, 4, 3, -5, 6, 4, 6, 4};
        getImplementation();
	}
    private void getImplementation() {
		this.implementation = new FloorBinarySearchImpl();

	}

    @Test
    public void teste01() {
        Integer expected = implementation.floor(vetorTamImpar, 4);
		Integer actual = 4;
        Assert.assertEquals(actual, expected);
    }

	@Test
    public void teste02() {
        Integer expected = implementation.floor(vetorTamImpar, 30);
		Integer actual = 30;
        Assert.assertEquals(actual, expected);
    }

	@Test
    public void teste03() {
        Integer expected = implementation.floor(vetorTamImpar, 27);
		Integer actual = 25;
        Assert.assertEquals(actual, expected);
    }

	@Test
    public void teste04() {
        Integer expected = implementation.floor(vetorTamPar, 0);
		Integer actual = -15;
        Assert.assertEquals(actual, expected);
    }

	@Test
    public void teste05() {
        Integer expected = implementation.floor(vetorTamPar, 800);
		Integer actual = 645;
        Assert.assertEquals(actual, expected);
    }

	@Test
    public void teste06() {
        Integer expected = implementation.floor(vetorTamImpar, -2);
        Assert.assertNull(expected);
    }

	@Test
    public void teste07() {
        Integer expected = implementation.floor(vetorVazio, 20);
        Assert.assertNull(expected);
    }

	// //@Test
    // public void teste08() {
    //     Integer expected = implementation.floor(vetorDesordenado, 800);
	// 	Integer actual = 9;
    //     Assert.assertEquals(actual, expected);
    // }

}
