package orderStatistic;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestQuickSelect {
    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public QuickSelect<Integer> implementation;

	@Before
	public void setUp() {
		vetorTamPar = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		vetorTamImpar = new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
		vetorValoresRepetidos = new Integer[] { 4, 9, 8, 4, 1, 5, 1, 4 };
		vetorValoresIguais = (new Integer[] { 6, 6, 6, 6 });
        getImplementation();
	}

	private void getImplementation() {
		this.implementation = new QuickSelect();
	}

    @Test
    public void teste01() {
        Integer actual = implementation.quickSelect(vetorTamImpar, 2);
		Integer expected = 6;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void teste02() {
        Integer actual = implementation.quickSelect(vetorTamImpar, 1);
		Integer expected = 4;
        Assert.assertEquals( expected, actual);
    }

    @Test
    public void teste03() {
        Integer actual = implementation.quickSelect(vetorTamImpar, 5);
		Integer expected = 18;
        Assert.assertEquals( expected, actual);
    }

    @Test
    public void teste04() {
        Integer actual = implementation.quickSelect(vetorTamImpar, 11);
		Integer expected = 49;
        Assert.assertEquals( expected, actual);
    }

    @Test
    public void teste05() {
        Integer actual = implementation.quickSelect(vetorTamPar, 9);
		Integer expected = 30;
        Assert.assertEquals( expected, actual);
    }

    @Test
    public void teste06() {
        Integer actual = implementation.quickSelect(vetorTamPar, 20);
		Integer expected = null;
        Assert.assertEquals( expected, actual);
    }

    @Test
    public void teste07() {
        Integer actual = implementation.quickSelect(vetorVazio, 0);
		Integer expected = null;
        Assert.assertEquals( expected, actual);
    }

    @Test
    public void teste08() {
        Integer actual = implementation.quickSelect(vetorValoresRepetidos, 5);
		Integer expected = 4;
        Assert.assertEquals( expected, actual);
    }

    @Test
    public void teste09() {
        Integer actual = implementation.quickSelect(vetorValoresRepetidos, 7);
		Integer expected = 8;
        Assert.assertEquals( expected, actual);
    }

    @Test
    public void teste10() {
        Integer actual = implementation.quickSelect(vetorValoresIguais, 4);
		Integer expected = 6;
        Assert.assertEquals( expected, actual);
    }
    @Test
    public void teste11() {
        Integer actual = implementation.quickSelect(vetorValoresIguais, 1);
		Integer expected = 6;
        Assert.assertEquals( expected, actual);
    }
    @Test
    public void teste12() {
        Integer actual = implementation.quickSelect(vetorValoresIguais, 0);
		Integer expected = null;
        Assert.assertEquals( expected, actual);
    }

}
