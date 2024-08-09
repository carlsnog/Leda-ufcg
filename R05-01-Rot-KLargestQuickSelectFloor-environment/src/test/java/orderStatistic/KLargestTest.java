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
		this.implementation = new KLargestOrderStatisticsImpl();
	}

  	public void genericTest(Integer[] array, int k) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		Integer[] result = implementation.getKLargest(array, k);

		Arrays.sort(copy1);
        Integer[] part = new Integer[k];
        int i = part.length-1;
        for (int j = copy1.length - 1; j >= copy1.length - k; j--)  {
            part[i--] = copy1[j];
        }
		Assert.assertArrayEquals(part, result);
	}

    @Test
    public void teste01(){
        genericTest(vetorTamImpar, 1);
    }
    @Test
    public void teste02() {
        Integer[] actual = implementation.getKLargest(vetorTamImpar, 2);
        Integer[] expected = new Integer[] {41, 49};
        Assert.assertArrayEquals(expected, actual);
    }
}
