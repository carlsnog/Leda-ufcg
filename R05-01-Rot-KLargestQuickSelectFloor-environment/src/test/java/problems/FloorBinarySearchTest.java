package problems;


public class FloorBinarySearchTest {
    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public Floor implementation;

	@Before
	public void setUp() {
		vetorTamPar = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		vetorTamImpar = new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
		vetorValoresRepetidos = new Integer[] { 4, 9, 8, 4, 1, 5, 1, 4 };
		vetorValoresIguais = (new Integer[] { 6, 6, 6, 6 });
        getImplementation();
	}
    private void getImplementation() {
		this.implementation = new FloorBinarySearchImpl();

	}

    @Test
    public void teste01() {
        Integer a = implementation.floor(vetorTamImpar, 4);
        Assert.assertEquals(a, 4);
    }

    @Test
    public void teste02() {
        Integer a = implementation.floor(vetorTamImpar, 27);
        Assert.assertEquals(a, 26);
    }

    @Test
    public void teste03() {
        Integer a = implementation.floor(vetorTamImpar, 50);
        Assert.assertNull(a);
    }

    @Test
    public void teste04() {
        Integer a = implementation.floor(vetorVazio, 5);
        Assert.assertNull(a);
    }
    import org.junit.Test;
    import problems.*;
    

    @Test
    public void teste05() {
        Integer a = implementation.floor(vetorTamPar, 5);
        Assert.assertArrayEquals(a, 4);    
    }

}
