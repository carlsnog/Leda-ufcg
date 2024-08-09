package orderStatistic;

import org.junit.Assert;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class KLargestTest {
   private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public KLargestOrderStatisticsImpl<Integer> implementation;

	@Before
	public void setUp() {
		vetorTamPar = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		vetorTamImpar = new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
		vetorValoresRepetidos = new Integer[] { 4, 9, 8, 4, 1, 5, 1, 4 };
		vetorValoresIguais = (new Integer[] { 6, 6, 6, 6 });
        getImplementation();
	}

	private void getImplementation() {
		this.implementation = new KLargestOrderStatisticsImpl<>();
	}

  	public void genericTest(Integer[] array, int k) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		Integer[] result = implementation.getKLargest(array, k);

		if (k > array.length || k < 1) {
			Assert.assertArrayEquals(result, new Integer[0]);
		} else {
		Arrays.sort(copy1);
        Integer[] part = new Integer[k];
        int i = part.length-1;
        for (int j = copy1.length - 1; j >= copy1.length - k; j--)  {
            part[i--] = copy1[j];
        }
		Assert.assertArrayEquals(part, result); }
	}

    @Test
    public void teste01(){
        genericTest(vetorTamImpar, 1);
    }
	@Test
	public void teste02() {
		genericTest(vetorTamPar, 2);
	}

	@Test
	public void teste03() {
		genericTest(vetorTamPar, 5);
	}

	@Test
	public void teste04() {
		genericTest(vetorValoresIguais, 5);
	}

	@Test
	public void teste05() {
		genericTest(vetorValoresIguais, 4);
	}

	@Test
	public void teste06() {
		genericTest(vetorValoresIguais, 2);
	}

	@Test
	public void teste07() {
		genericTest(new Integer[0], 5);
	}

	@Test
	public void teste08() {
		genericTest(new Integer[0], 0);
	}

	@Test
	public void teste09() {
		genericTest(vetorValoresRepetidos, 5);
	}

	@Test
	public void teste10() {
		genericTest(vetorVazio, 5);
	}

	@Test
	public void teste11() {
		genericTest(vetorTamImpar,15);
	}

	@Test
	public void teste12() {
		genericTest(vetorTamImpar,12);
	}

}
